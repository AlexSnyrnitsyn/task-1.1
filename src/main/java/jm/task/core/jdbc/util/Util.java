package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    private final static String URL = "jdbc:postgresql://localhost:5432/mentor_db";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "253782511180598qq";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Problem creating session factory");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


//        public static Connection getPostgresqlConnection() {
//        String hostName = "localhost";
//        String dbName = "mentor_db";
//        String userName = "postgres";
//        String password = "253782511180598qq";
//
//        return getPostgresqlConnection(hostName, dbName, userName, password);
//    }
//
//    public static Connection getPostgresqlConnection(String hostName, String dbName, String userName, String password) {
//
//        String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
//
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(connectionURL, userName, password);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return connection;
//    }
}
