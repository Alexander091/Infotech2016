package com.DAO;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Dog;
import com.zoo.Entity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DAO {

    private final static int PAR_ID_CAT = 1;
    private final static int PAR_ID_DOG = 1;
    private final static int OBJ_TYPE_ID_CAT = 2;
    private final static int OBJ_TYPE_ID_DOG = 3;

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";
    private final static String QUERY_SELECT = "SELECT * FROM objects  ORDER BY object_id"; //запрос
    private final static String QUERY_INSERT = "INSERT INTO objects (parent_id, object_type_id, name) VALUES (?, ?, ?)";
    private final static String QUERY_INSERT_VALUE = "INSERT INTO params (value, attr_id) VALUES (?, ?)";
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

    public <T> void set(T obj) throws IllegalAccessException {
        Class cl = obj.getClass();
        Class cl2 = cl.getSuperclass();
        if (obj instanceof Dog){
            try {
                preparedStatement = connection.prepareStatement(QUERY_INSERT);
                preparedStatement.setInt(1, PAR_ID_DOG);
                preparedStatement.setInt(2, OBJ_TYPE_ID_DOG);
                preparedStatement.setString(3, "dog");
                preparedStatement.execute();
            }catch (SQLException sql){
                sql.printStackTrace();
            }
        }
        else if (obj instanceof Cat){
            try {
                preparedStatement = connection.prepareStatement(QUERY_INSERT);
                preparedStatement.setInt(1, PAR_ID_CAT);
                preparedStatement.setInt(2, OBJ_TYPE_ID_CAT);
                preparedStatement.setString(3, "cat");
                preparedStatement.execute();
            }catch (SQLException sql){
                sql.printStackTrace();
            }
        }
        Field[] fieldSuperClass = cl2.getDeclaredFields();
        Field[] fieldClass = cl.getDeclaredFields();
        for (Field field : fieldSuperClass){
            if (field.isAnnotationPresent(Attribute.class)){
                field.setAccessible(true);
                Attribute attr = field.getAnnotation(Attribute.class);
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE);
                    switch (attr.value()) {
                        case 1:
                            preparedStatement.setInt(1, (Integer) field.get(obj));
                            preparedStatement.setInt(2, 1);
                            preparedStatement.execute();
                            break;
                        case 2:
                            preparedStatement.setInt(1, (Integer) field.get(obj));
                            preparedStatement.setInt(2, 2);
                            preparedStatement.execute();
                            break;
                        case 3:
                            preparedStatement.setInt(1, (Integer) field.get(obj));
                            preparedStatement.setInt(2, 3);
                            preparedStatement.execute();
                            break;
                        case 4:
                            preparedStatement.setString(1, (String) field.get(obj));
                            preparedStatement.setInt(2, 4);
                            preparedStatement.execute();
                            break;
                        case 5:
                            preparedStatement.setString(1, (String) field.get(obj));
                            preparedStatement.setInt(2, 5);
                            preparedStatement.execute();
                            break;
                    }
                }catch (SQLException sql){
                    sql.printStackTrace();
                }
                if (field.get(obj)!= null){
                    System.out.println(field.get(obj));
                }
            }
        }
        for (Field field1 : fieldClass){
            if (field1.isAnnotationPresent(Attribute.class)){
                field1.setAccessible(true);
                Attribute attr = field1.getAnnotation(Attribute.class);
                try {
                    preparedStatement = connection.prepareStatement(QUERY_INSERT_VALUE);
                    preparedStatement.setInt(1, attr.value());
                    preparedStatement.setInt(2, 6);
                    preparedStatement.execute();
                }catch (SQLException sql){
                    sql.printStackTrace();
                }
                if (field1.get(obj) != null ){
                    System.out.println(field1.get(obj));
                }
            }
        }
    }

    public void saveAnimal(Animal animal){ //добавляем в таблицу
        try {
            preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1,animal.getType());
           /* preparedStatement.setInt(2, animal.);
            preparedStatement.setInt(3, objTypeId);*/
            preparedStatement.setString(3, animal.getName());
            preparedStatement.execute();
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void deleteAnimal(int objId){ //удаляем из таблицы
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
    //TODO Dependency Injecion
}
