package com.ParcialFX.SQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionEnfermedades {
    private static String databaseName = "base_enfermedades";
    private static String databaseUser = "root";
    private static String databasePassword = "root";
    private static String url = "jdbc:mysql://localhost:3306/" + databaseName;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, databaseUser, databasePassword);
    }

}
