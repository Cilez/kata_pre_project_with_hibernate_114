package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
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
