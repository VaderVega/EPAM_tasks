package JDBC.Task1.DAO;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLConnection {
    public static final String URL = "jdbc:postgresql://127.0.0.1/test";
    public static final String USER = "jdbcuser";
    public static final String PASSWORD = "jdbcpass";

    private static SQLConnection instance;

    public static SQLConnection getInstance() {
        if (instance == null)
            instance = new SQLConnection();
        return instance;
    }

    @SneakyThrows
    public Connection getConnection() {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
