package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
//    private static SessionFactory sessionFactory;

//    static {
//        Configuration configuration = new Configuration().addAnnotatedClass(User1.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static Connection getMyConnection(){
        final String connectionURL = "jdbc:mysql://localhost:3306/db_for_113";
        final String userName = "root";
        final String password = "root";
        try {
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
