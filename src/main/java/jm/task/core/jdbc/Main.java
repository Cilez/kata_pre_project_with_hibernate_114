package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;



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
//        Configuration configuration = new Configuration().addAnnotatedClass(User1.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        SessionFactory sessionFactory = Util.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//
//        try {
//            session.beginTransaction();
//
//
//
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

        UserDaoHibernateImpl dao = new UserDaoHibernateImpl();
        dao.dropUsersTable();





    }
}
