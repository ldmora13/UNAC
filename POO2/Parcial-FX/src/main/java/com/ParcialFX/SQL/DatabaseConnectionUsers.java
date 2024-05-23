package com.ParcialFX.SQL;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionUsers {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "base_users";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
