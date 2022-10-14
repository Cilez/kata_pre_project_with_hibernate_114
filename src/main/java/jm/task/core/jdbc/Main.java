package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl dao = new UserDaoJDBCImpl();

        dao.createUsersTable();
        dao.saveUser("Sergey", "Ivanko", (byte)(33));
        dao.saveUser("Egor", "Foo", (byte)(44));
        dao.saveUser("Andrey", "Fooo", (byte)(55));
        dao.saveUser("Anton", "Som", (byte)(66));
        for (User u : dao.getAllUsers()) {
            System.out.println(u.toString());
        }
        dao.cleanUsersTable();
        dao.dropUsersTable();

//        Session sess = Util.getSessionFactory().openSession();
//
//        String sql2 = "Create table USERS(id serial, firstName varchar(100) NOT NULL, lastName varchar(100) NOT NULL, age INT NOT NULL, PRIMARY KEY (ID))";
//        Transaction tx = null;
//        try {
//            tx = sess.beginTransaction();
//            Query query = sess.createSQLQuery(sql2);
//            tx.commit();
//        }
//        catch (Exception e) {
//            if (tx!=null) tx.rollback();
//            throw e;
//        }
//        finally {
//            sess.close();
//        }


    }
}
