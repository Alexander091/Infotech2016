package com.DAO;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Cat;
import com.zoo.Dog;
import com.zoo.Entity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DAO {

    /*
    * данные для подключения к базе
    */

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";

    /*
    * запросы
    */

    private final static String QUERY_SELECT = "SELECT value, attr_id FROM  params  WHERE object_id = ?;"; //запрос
    private final static String QUERY_INSERT = "INSERT INTO objects (parent_id, object_type_id, name) VALUES (?, ?, ?)";
    private final static String QUERY_INSERT_VALUE = "INSERT INTO params (attr_id, value) VALUES (?, ?)";
    private final static String QUERY_DELETE = "DELETE FROM objects WHERE object_id = ? ";

    /*
    * то что касается непосредственного
    * соединения с БД, открытие и закрытие соединений
    */

    private Connection connection;
    private PreparedStatement preparedStatement;

    /*
    *  следующие 3 записи позволяют создать
    *  одно соединение т работать только с
    *  одним подключением к БД +
    *  закрытый консткруктор не позволит создвать
    *  объекты этого класса
    */

    private static final DAO DAOINSTANCE = new DAO();

    private DAO() { // конструктор с установкой соединение с БД

        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); // устанавливаем соединение
        }catch (SQLException s){ // ловим ошибку
            s.printStackTrace();
        }
    }

    public static DAO getDaoInstance(){

        return DAOINSTANCE;

    }

    public void closeConnection() { //закрываем соединение
        try{
            connection.close();
            preparedStatement.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    /*
    * методы по работе с сущностями
    */

    // метод, который возвращает все поля помеченные аннотациями
    // для дочернего и базового классов

    private static List<Field> getInheritedFields(Class<?> type) { //получить поля класса

        List<Field> fields = new ArrayList<Field>(); //добавляем поля в массив
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields())); //добавляем все задекларированные поля в массив
        }
        return fields;
    }

    public <T extends Entity> void save(T obj) throws IllegalAccessException {

        Class cl = obj.getClass(); //получаем ссылку на объект класса T
        Class cl2 = cl.getSuperclass(); //тоже но для базового класса, это нужно чтобы получить доступ к аннотациям описанным в базовом классе


        List<Field> fieldClass = getInheritedFields(obj.getClass());

        if (cl.isAnnotationPresent(ObjectType.class)) { //здесь мы проверяем на наличие аннотации ObjectType
            ObjectType objectType = (ObjectType) cl.getAnnotation(ObjectType.class);
            try {
                preparedStatement = connection.prepareStatement(QUERY_INSERT);
                preparedStatement.setLong(1, obj.getParentId());
                preparedStatement.setLong(2, objectType.value());
                preparedStatement.setString(3, obj.getName());
                preparedStatement.execute();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
//TODO получить id объекта

        for (Field field : fieldClass) { // для всех полей базового класса
            if (field.isAnnotationPresent(Attribute.class)) { // есть ли указанная аннотация
                field.setAccessible(true); // устанавливаем доступ к private полям
                Attribute attr = field.getAnnotation(Attribute.class); // получаем аннотацию
                try {
                    Object objectValue = field.get(obj);
                    if(objectValue == null) continue;
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE); //устанавливаем соединение
                    preparedStatement.setLong(1, attr.value());

                    preparedStatement.setString(2,  field.get(obj).toString()); // добавляем в БД значение поля
                    preparedStatement.execute();

                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
                if (field.get(obj) != null) {
                    System.out.println(field.get(obj));
                }
            }
        }
    }

    public Map<Long, String> getParamsByObjectId(long id) throws SQLException {
        Map<Long, String> objectValues = new HashMap<>();
        preparedStatement = connection.prepareStatement(QUERY_SELECT);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            //int objectId = resultSet.getInt("object_id");
            String value = resultSet.getString("value");
            Long attrId = resultSet.getLong("attr_id");
            objectValues.put(attrId, value);
        }
        return objectValues;
    }

    public void delete(int objId){ //удаляем из таблицы
        try {
            preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, objId);
            preparedStatement.execute();
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public  <T extends Entity> T getObject(Class<T> cl, long id) throws IllegalAccessException, InstantiationException, SQLException {
        //значение объекта
        Map<Long, String> resultSetObjectValues = getParamsByObjectId(id);

        ObjectType objectTypeAnnotation = cl.getAnnotation(ObjectType.class); // получаем ссылку на объект аннотации
        Long objectTypeId = objectTypeAnnotation.value(); // получаем значение из поля value аннотации ObjectType
        System.out.println(objectTypeId);
        T entityOfAnimal = cl.newInstance(); // создаём новую сущность класса Т
        entityOfAnimal.setName("Entity name"); // имя сущности

        for(Field field  : getInheritedFields(cl))
        {
            if (field.isAnnotationPresent(Attribute.class))
            {
                field.setAccessible(true);
                Attribute attrAnnotation = field.getAnnotation(Attribute.class);
                Long attrId = attrAnnotation.value();
                System.out.println(attrId);
                for (Map.Entry<Long, String> entry : resultSetObjectValues.entrySet()) {
                    if(entry.getKey().equals(attrId)){
                        field.set(entityOfAnimal, entry.getValue());
                    }
                }
            }
        }
        return entityOfAnimal;
    }

}
