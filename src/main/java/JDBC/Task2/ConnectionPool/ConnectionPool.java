package JDBC.Task2.ConnectionPool;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private Connection connection;

    private BlockingQueue<Connection> connectionPool;
    private BlockingQueue<Connection> usedConnections;

    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    public ConnectionPool() {
        driver = ResourceManager.getValues(ResourceManager.DRIVER);
        url = ResourceManager.getValues(ResourceManager.URL);
        user = ResourceManager.getValues(ResourceManager.USER);
        password = ResourceManager.getValues(ResourceManager.PASSWORD);
        poolSize = Integer.parseInt(ResourceManager.getValues(ResourceManager.POOLSIZE));
    }

    @SneakyThrows
    public void init() {
        connectionPool = new ArrayBlockingQueue<>(poolSize);
        usedConnections = new ArrayBlockingQueue<>(poolSize);

        Class.forName(driver);
        for (int i = 0; i < poolSize; i++) {
            connection = DriverManager.getConnection(url, user, password);
            connectionPool.add(connection);
        }
    }

    @SneakyThrows
    public Connection getConnection() {
        Connection connection = null;
        connection = connectionPool.take();
        connectionPool.remove(connection);
        usedConnections.add(connection);

        return  connection;
    }

    public void returnConnection(Connection connection) {
        usedConnections.remove(connection);
        connectionPool.add(connection);
    }

    @SneakyThrows
    public void closeConnections() {
        for (Connection connection : connectionPool)
            if (!connection.getAutoCommit())
                connection.commit();
            connection.close();
    }

    @SneakyThrows
    public void closeResultSet(ResultSet resultSet) {
        resultSet.close();
    }

    @SneakyThrows
    public void closeStatement(Statement statement) {
        statement.close();
    }
}

class ResourceManager {
    static final String DRIVER = "driver";
    static final String URL = "url";
    static final String USER = "user";
    static final String PASSWORD = "password";
    static final String POOLSIZE = "poolsize";

    private static ResourceBundle bundle = ResourceBundle.getBundle("JDBC/Task2/dbconnection");

    public static String getValues(String key) {
        return bundle.getString(key);
    }
}
