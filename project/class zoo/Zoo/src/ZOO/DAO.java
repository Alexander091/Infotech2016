package ZOO;

import java.sql.*;
/**
 * Created by user on 17.12.2016.
 */
public class DAO {

    private static final String driver = "postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "1234";

    private final String query = "select * from objects";
    private String queryTest = "";
    private Connection connection;
    private Statement statement;

    public DAO() {

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection( url,user,pass);
        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }

    protected void closeConnection() { //закрываем соединение
        try{
            connection.close();
            statement.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    protected void printAllObjects() {
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
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    protected void saveAnimal(int obj_id, int par_id, int obj_type_id, String name){
        queryTest = "INSERT INTO objects (object_id, parent_id, object_type_id, name) VALUES ('"+obj_id+"','"+par_id+"','"+obj_type_id+"', '"+name+"');";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(queryTest);
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    protected void deleteAnimal(String name){
        queryTest  = "DELETE FROM objects WHERE name = '"+name+"';";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(queryTest);
        }catch (SQLException s) {
            s.printStackTrace();
        }
    }

    protected void allCats(){
        try{
        queryTest  = "SELECT * FROM objects WHERE object_id = '"+4+"';";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(queryTest);
        while (resultSet.next()){
            int object_id = resultSet.getInt("object_id");
            int parent_id = resultSet.getInt("parent_id");
            int object_type_id = resultSet.getInt("object_type_id");
            String name = resultSet.getString("name");
            System.out.println(object_id + " " + name );
            }
        }
        catch (SQLException s) {
        s.printStackTrace();
        }
    }

    protected void allDogs(){
        try{
            queryTest  = "SELECT * FROM objects WHERE object_id = '"+5+"';";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryTest);
            while (resultSet.next()){
                int object_id = resultSet.getInt("object_id");
                int parent_id = resultSet.getInt("parent_id");
                int object_type_id = resultSet.getInt("object_type_id");
                String name = resultSet.getString("name");
                System.out.println(object_id + " " + name );
            }
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

}
