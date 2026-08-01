package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = getEnvOrDefault("DB_HOST", "localhost");
    private static final String PORT = getEnvOrDefault("DB_PORT", "3306");
    private static final String DB_NAME = getEnvOrDefault("DB_NAME", "bank_db");
    private static final String USER = getEnvOrDefault("DB_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("DB_PASSWORD", "");

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value != null && !value.trim().isEmpty()) ? value : defaultValue;
    }

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Database Connected Successfully!");
            return con;
        } catch (SQLException e) {
            System.err.println(" Database Connection Failed: " + e.getMessage());
            return null;
        }
    }
}
