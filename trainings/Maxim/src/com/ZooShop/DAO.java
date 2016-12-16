package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    Class.forName("org.postgresql.Driver");
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.0:5432/maxim","postgres", "123");
    connection.close();
}
