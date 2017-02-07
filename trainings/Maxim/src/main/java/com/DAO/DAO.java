package com.DAO;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;
import com.zoo.Entity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DAO {

    private static long count; // счётчик

    /*
    * данные для подключения к базе
    */

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";

    /*
    * запросы
    */
    private final static String QUERY_SELECT_ID = "SELECT  MAX(object_id) as max  FROM objects;";
    private final static String QUERY_SELECT = "SELECT value, attr_id FROM  params  WHERE object_id = ?;";
    private final static String QUERY_INSERT = "INSERT INTO objects (object_id, parent_id, object_type_id, name) VALUES (?, ?, ?, ?)";
    private final static String QUERY_INSERT_VALUE = "INSERT INTO params (attr_id, object_id, value) VALUES (?, ?, ?)";
    private final static String QUERY_DELETE_FROM_OBJECTS = "DELETE FROM objects WHERE object_id = ? ";

    /*
    * то что касается непосредственного
    * соединения с БД, открытие и закрытие соединений
    */

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    /*
    *  следующие 3 записи позволяют создать
    *  одно соединение и работать только с
    *  одним подключением к БД +
    *  закрытый консткруктор не позволит создвать
    *  объекты этого класса
    */

    private static final DAO DAO_INSTANCE = new DAO();

    public DAO() { // конструктор с установкой соединение с БД

        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); // устанавливаем соединение
        }catch (SQLException s){ // ловим ошибку
            s.printStackTrace();
        }
    }

    public static DAO getDaoInstance(){

        return DAO_INSTANCE;

    }

    public void closeConnection() throws SQLException { //закрываем соединение

        try {
            connection.close();
            preparedStatement.close();

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    /*
    * счётчик
    */

    private static long getCount() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY_SELECT_ID);
        while (resultSet.next()){
            count = resultSet.getLong("max");
        }
        return count;
    }

    /* метод, который возвращает все поля помеченные аннотациями
    * для дочернего и базового классов
    */

    private static List<Field> getInheritedFields(Class<?> type) { //получить поля класса

        List<Field> fields = new ArrayList<>(); //добавляем поля в массив
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields())); //добавляем все задекларированные поля в массив
        }
        return fields;
    }

    /*
    * метод добавляющией сущность в БД
    * в таблицы objects и params
    */

    public <T extends Entity> void saveEntityInDatabase(T obj) throws IllegalAccessException {

        Class cl = obj.getClass(); //получаем ссылку на объект класса T
        List<Field> fieldClass = getInheritedFields(obj.getClass()); // получаем все поля класса

        if (cl.isAnnotationPresent(ObjectType.class)) { //здесь мы проверяем на наличие аннотации ObjectType
            ObjectType objectType = (ObjectType) cl.getAnnotation(ObjectType.class);
            try {

                preparedStatement = connection.prepareStatement(QUERY_INSERT);
                ///////////////////////////////////////////////////////////////////////////////
                obj.setObjectId(DAO.getCount() + 1); // устанавливаем id //TODO место где устанавливается id
                preparedStatement.setLong(1, obj.getObjectId()); // добавляем в таблицу
                ///////////////////////////////////////////////////////////////////////////////
                if (objectType.value() == 3 || objectType.value() == 2) { // если тип объекта 2 или 3 устанавливаем parentId 2

                    obj.setParentId(2);

                }
                preparedStatement.setLong(2, obj.getParentId()); // добавляем в таблицу
                ///////////////////////////////////////////////////////////////////////////////
                obj.setObjectTypeId(objectType.value()); // те же действия с объектным типом
                preparedStatement.setLong(3, obj.getObjectTypeId());
                ///////////////////////////////////////////////////////////////////////////////
                if (objectType.value() == 3) {

                    obj.setNameType("dog");

                }
                else if (objectType.value() == 2){

                    obj.setNameType("cat");

                }
                preparedStatement.setString(4, obj.getNameType());
                ///////////////////////////////////////////////////////////////////////////////
                preparedStatement.execute(); //выполняем запрос
                ///////////////////////////////////////////////////////////////////////////////
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }

        for (Field field : fieldClass) { // для всех полей класса
            if (field.isAnnotationPresent(Attribute.class)) { // есть ли указанная аннотация
                field.setAccessible(true); // устанавливаем доступ к private полям
                Attribute attr = field.getAnnotation(Attribute.class); // получаем аннотацию
                try {

                    Object objectValue = field.get(obj);
                    if(objectValue == null) continue;

                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE); //устанавливаем соединение

                    preparedStatement.setLong(1, attr.value()); // устанавливаем attrId
                    preparedStatement.setLong(2, obj.getObjectId()); // устанавливаем objectId
                    preparedStatement.setString(3,  field.get(obj).toString()); // добавляем в БД значение поля

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

    // метод по извлечению объекта из БД

    public <T extends Animal> Animal getParamsByObjectId(T obj, long objectId) throws SQLException {

        preparedStatement = connection.prepareStatement(QUERY_SELECT);
        preparedStatement.setLong(1, objectId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            Long attrId = resultSet.getLong("attr_id");

            if (attrId == 1) {
                Double weight = resultSet.getDouble("value");
                obj.setWeight(weight);
            }
            else if (attrId == 2) {
                Double length = resultSet.getDouble("value");
                obj.setLength(length);
            }
            else if(attrId == 3){
                Integer age = resultSet.getInt("value");
                obj.setAge(age);
            }
            else if(attrId == 4){
                String name = resultSet.getString("value");
                obj.setName(name);
            }
            else if(attrId == 5){
                String colour = resultSet.getString("value");
                obj.setColour(colour);
            }
            else if(attrId == 6){
                String kind = resultSet.getString("value");
                obj.setKind(kind);
            }
        }
        return obj;
    }

    // метод по удалению сущности из таблицы

    public void deleteEntityFromDatabase(long objectId){ //удаляем из таблицы

        try {
            preparedStatement = connection.prepareStatement(QUERY_DELETE_FROM_OBJECTS);
            preparedStatement.setLong(1, objectId);
            preparedStatement.execute();

        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

}
