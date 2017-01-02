package com.DAO;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;
import com.zoo.Entity;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DAO {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";
    private final static String QUERY_SELECT = "SELECT * FROM objects  ORDER BY object_id"; //запрос
    private final static String QUERY_INSERT = "INSERT INTO objects (parent_id, object_type_id, name) VALUES (?, ?, ?)";
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

    public void getAllObjects() { // получаем все строки
        try{
            preparedStatement = connection.prepareStatement(QUERY_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int object_id = resultSet.getInt("object_id");
                //String value = resultSet.getString("value");
                String name = resultSet.getString("name");
                System.out.println(object_id + " " + name);
            }
        }catch (SQLException s) {
            s.printStackTrace();
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

    private static List<Field> getInheritedFields(Class<?> type) { //получить поля класса
        List<Field> fields = new ArrayList<Field>(); //добавляем поля в массив
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields())); //добавляем все задекларированные поля в массив
        }
        return fields;
    }
    //TODO Раскидать по пакетам аннотации и т.д
    //TODO Dependency Injecion
}
