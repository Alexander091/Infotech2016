package com.zooshop;

import java.sql.*;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

public class DAO {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";
    private final static String QUERY_SELECT = "SELECT * FROM objects  ORDER BY object_id"; //запрос
    private final static String QUERY_INSERT = "INSERT INTO objects (object_id, parent_id, object_type_id, name) VALUES (?, ?, ?, ?)";
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

    public Map getAllObjects() { // получаем все строки
        Map map = new TreeMap();
        try{
            preparedStatement = connection.prepareStatement(QUERY_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int object_id = resultSet.getInt("object_id");
                //String value = resultSet.getString("value");
                String name = resultSet.getString("name");
                map.put(object_id, name);
                //System.out.println(object_id + " " + name);
            }
        }catch (SQLException s) {
            s.printStackTrace();
        }
        return map;
    }

    public void saveAnimal(int obj_id, int par_id, int obj_type_id, String name){ //добавляем в таблицу
        try {
            preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, obj_id);
            preparedStatement.setInt(2, par_id);
            preparedStatement.setInt(3, obj_type_id);
            preparedStatement.setString(4, name);
            preparedStatement.execute();
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void deleteAnimal(int obj_id){ //удаляем из таблицы
        try {
            preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, obj_id);
            preparedStatement.execute();
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

}
