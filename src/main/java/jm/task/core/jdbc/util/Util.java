package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getMyConnection() throws SQLException {
        String hostName = "localhost";
        String dbName = "db_for_113";
        String userName = "root";
        String password = "root";
        return getMyConnection(hostName, dbName, userName, password);

    }

    private static Connection getMyConnection(String hostName, String dbName, String userName, String password) throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
