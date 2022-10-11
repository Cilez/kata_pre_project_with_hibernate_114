package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection;
    private final Statement statement;

    {
        try {
            connection = Util.getMyConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            final String sql = "CREATE TABLE USERS"
                    + "("
                    + " ID serial,"
                    + " firstName varchar(100) NOT NULL,"
                    + " lastName varchar(100) NOT NULL,"
                    + " age INT NOT NULL,"
                    + " PRIMARY KEY (ID)"
                    + ")";
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }

    public void dropUsersTable() {
        try {
            final String sql = "DROP TABLE USERS";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            final String sql = "INSERT INTO db_for_113.users (firstName, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            System.out.println( "User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            final String sql = "DELETE FROM db_for_113.users WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new LinkedList<>();

        try {
            final String sql = "SELECT * FROM db_for_113.users";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(new User(rs.getString("firstName"), rs.getString("lastName"), rs.getByte("age")));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return list;
    }

    public void cleanUsersTable() {
        try {
            final String sql = "DELETE FROM db_for_113.users";
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
