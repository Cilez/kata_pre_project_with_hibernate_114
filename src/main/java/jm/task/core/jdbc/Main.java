package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
//        UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
//
//        dao.createUsersTable();
//        dao.saveUser("Sergey", "Ivanko", (byte)(33));
//        dao.saveUser("Egor", "Foo", (byte)(44));
//        dao.saveUser("Andrey", "Fooo", (byte)(55));
//        dao.saveUser("Anton", "Som", (byte)(66));
//        for (User u : dao.getAllUsers()) {
//            System.out.println(u.toString());
//        }
//        dao.cleanUsersTable();
//        dao.dropUsersTable();

        SessionFactory sessionFactory = Util.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL," +
                "lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)");

//        String sql = "DROP TABLE IF EXISTS users";
//
//        Query query = session.createSQLQuery(sql);

        session.getTransaction().commit();
        sessionFactory.close();



    }
}
