package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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


    }
}
