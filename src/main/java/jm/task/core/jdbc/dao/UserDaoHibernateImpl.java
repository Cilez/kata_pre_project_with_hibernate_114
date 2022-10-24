package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("create table if not exists users(id bigint not null auto_increment," +
                            "firstName varchar(100) not null," +
                            "lastName varchar(100) not null," +
                            "age int not null," +
                            "primary key (id))")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            List<User> users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
            return users;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
