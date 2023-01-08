package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

        public static Connection getPostgresqlConnection() {
        String hostName = "localhost";
        String dbName = "mentor_db";
        String userName = "postgres";
        String password = "253782511180598qq";

        return getPostgresqlConnection(hostName, dbName, userName, password);
    }

    public static Connection getPostgresqlConnection(String hostName, String dbName, String userName, String password) {

        String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
