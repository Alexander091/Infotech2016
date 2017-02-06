import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionBD {

    private final String HOST = "jdbc:postgresql://localhost:5432/zooshop";
    private final String USERNAME ="postgres";
    private final String PASSWORD ="5991";
    private Connection connection;

    public ConnectionBD (){
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при подключении к бд");
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
