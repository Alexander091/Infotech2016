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

    private final static int PAR_ID_CAT = 2;
    private final static int PAR_ID_DOG = 3;
    private final static int OBJ_TYPE_ID_CAT = 3;
    private final static int OBJ_TYPE_ID_DOG = 4;

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";
    private final static String QUERY_SELECT = "SELECT  o.object_id, o.name, p.value FROM  objects o JOIN params p ON o.object_id = p.object_id WHERE o.object_id = ?;"; //запрос
    private final static String QUERY_INSERT = "INSERT INTO objects (parent_id, object_type_id, name) VALUES (?, ?, ?)";
    private final static String QUERY_INSERT_VALUE = "INSERT INTO params (attr_id, value) VALUES (?, ?)";
    private final static String QUERY_DELETE = "DELETE FROM objects WHERE object_id = ? ";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public DAO() { // конструктор с установкой соединение с БД
        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); // устанавливаем соединение
        }catch (SQLException s){ // ловим ошибку
            s.printStackTrace();
        }
    }

    public void closeConnection() { //закрываем соединение
        try{
            connection.close();
            preparedStatement.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    public <T> void save(T obj) throws IllegalAccessException {

        Class cl = obj.getClass(); //получаем ссылку на объект класса T
        Class cl2 = cl.getSuperclass(); //тоже но для базового класса, это нужно чтобы получить доступ к аннотациям описанным в базовом классе

        Field[] fieldSuperClass = cl2.getDeclaredFields(); //получаем все поля дочернего класса
        Field[] fieldClass = cl.getDeclaredFields(); //тоже для базового

        if (cl.isAnnotationPresent(ObjectType.class)) { //здесь мы проверяем на наличие аннотации ObjectType
            ObjectType objectType = (ObjectType) cl.getAnnotation(ObjectType.class);
            if (objectType.value() == 3) {
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT);
                    preparedStatement.setInt(1, PAR_ID_DOG);
                    preparedStatement.setInt(2, OBJ_TYPE_ID_DOG);
                    preparedStatement.setString(3, "dog");
                    preparedStatement.execute();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
            } else if (objectType.value() == 2) {
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT);
                    preparedStatement.setInt(1, PAR_ID_CAT);
                    preparedStatement.setInt(2, OBJ_TYPE_ID_CAT);
                    preparedStatement.setString(3, "cat");
                    preparedStatement.execute();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
            }
        }

        for (Field field : fieldSuperClass) { // для всех полей базового класса
            if (field.isAnnotationPresent(Attribute.class)) { // есть ли указанная аннотация
                field.setAccessible(true); // устанавливаем доступ к private полям
                Attribute attr = field.getAnnotation(Attribute.class); // получаем аннотацию
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE); //устанавливаем соединение
                    switch (attr.value()) { // смотрим значение аннотации
                        case 1:
                            preparedStatement.setInt(1, 1);
                            preparedStatement.setInt(2, (Integer) field.get(obj)); // добавляем в БД значение поля
                            preparedStatement.execute();
                            break;
                        case 2:
                            preparedStatement.setInt(1, 2);
                            preparedStatement.setInt(2, (Integer) field.get(obj));
                            preparedStatement.execute();
                            break;
                        case 3:
                            preparedStatement.setInt(1, 3);
                            preparedStatement.setInt(2, (Integer) field.get(obj));
                            preparedStatement.execute();
                            break;
                        case 4:
                            preparedStatement.setInt(1, 4);
                            preparedStatement.setString(2, (String) field.get(obj));
                            preparedStatement.execute();
                            break;
                        case 5:
                            preparedStatement.setInt(1, 5);
                            preparedStatement.setString(2, (String) field.get(obj));
                            preparedStatement.execute();
                            break;
                    }
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
                if (field.get(obj) != null) {
                    System.out.println(field.get(obj));
                }
            }
        }
        for (Field field1 : fieldClass) { //здесь нет switch так как у класса cat только одно поле с аннотацией
            if (field1.isAnnotationPresent(Attribute.class)) { //всё тоже самое но для дочернего класса
                field1.setAccessible(true);
                Attribute attr = field1.getAnnotation(Attribute.class);
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE);
                    preparedStatement.setInt(1, attr.value());
                    preparedStatement.setInt(2, 6);
                    preparedStatement.execute();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
                if (field1.get(obj) != null) {
                    System.out.println(field1.get(obj));
                }
            }
        }
    }

    public Map<String, String> get(int id) throws SQLException {
        Map<String, String> object = new HashMap<>();
        preparedStatement = connection.prepareStatement(QUERY_SELECT);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            //int objectId = resultSet.getInt("object_id");
            String name = resultSet.getString("name");
            String value = resultSet.getString("value");
            object.put(value, name);
        }
        return object;
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

    public static <T extends Entity> T getObject(Class<T> cl) throws IllegalAccessException, InstantiationException {
        //значение объекта
        Map<Long, String> resultSetObjectValues = new HashMap<>();

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
                int attrId = attrAnnotation.value();
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

    private static List<Field> getInheritedFields(Class<?> type) { //получить поля класса
        List<Field> fields = new ArrayList<Field>(); //добавляем поля в массив
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields())); //добавляем все задекларированные поля в массив
        }
        return fields;
    }

}
