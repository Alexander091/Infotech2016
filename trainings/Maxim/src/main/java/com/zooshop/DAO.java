package com.zooshop;

import java.sql.*;
import java.sql.Statement;

public class DAO {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "123";
    private final String query = "select * from objects"; //запрос
    private Connection connection;
    private Statement statement;

    public DAO() { // конструктор с установкой соединение с БД

        try {
            Class.forName("org.postgresql.Driver"); //проверяем наличие драйвера
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); // устанавливаем соединение
        }catch (SQLException s){ // ловим ошибку
            s.printStackTrace();
        }
    }

    public void closeConnection() { //закрываем соединение
        try{
            connection.close();
            statement.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    public void printAllObjects() { // получаем все строки
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int object_id = resultSet.getInt("object_id");
                int parent_id = resultSet.getInt("parent_id");
                int object_type_id = resultSet.getInt("object_type_id");
                String name = resultSet.getString("name");
                System.out.println(object_id + " " + name );
            }
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void saveAnimal(int obj_id, int par_id, int obj_type_id, String name){ //добавляем в таблицу
        String query1 = "INSERT INTO objects (object_id, parent_id, object_type_id, name) VALUES ('"+obj_id+"','"+par_id+"','"+obj_type_id+"', '"+name+"');";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query1);
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void deleteAnimal(String name){ //удаляем из таблицы
        String query2 = "DELETE FROM objects WHERE name = '"+name+"';";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query2);
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }
}
