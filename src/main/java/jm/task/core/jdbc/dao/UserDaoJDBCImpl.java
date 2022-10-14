package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getMyConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            final Statement statement = connection.createStatement();
//            final String sql = "create table if not exists USERS"
//                    + "("
//                    + " ID serial,"
//                    + " firstName varchar(100) NOT NULL,"
//                    + " lastName varchar(100) NOT NULL,"
//                    + " age INT NOT NULL,"
//                    + " PRIMARY KEY (ID)"
//                    + ")";
            statement.execute("create table if not exists USERS"
                                + "("
                                + " ID serial,"
                                + " firstName varchar(100) NOT NULL,"
                                + " lastName varchar(100) NOT NULL,"
                                + " age INT NOT NULL,"
                                + " PRIMARY KEY (ID)"
                                + ")"
                              );
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }

    public void dropUsersTable() {
        try {
            final Statement statement = connection.createStatement();
//            final String sql = "drop table if exists USERS";
            statement.executeUpdate("drop table if exists USERS");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
//            final String sql = "INSERT INTO db_for_113.users (firstName, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO db_for_113.users (firstName, lastName, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
//            final String sql = "DELETE FROM db_for_113.users WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM db_for_113.users WHERE ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new LinkedList<>();

        try {
            final Statement statement = connection.createStatement();
//            final String sql = "SELECT * FROM db_for_113.users";
            ResultSet rs = statement.executeQuery("SELECT * FROM db_for_113.users");

            while (rs.next()) {
                list.add(new User(  rs.getString("firstName"),
                                    rs.getString("lastName"),
                                    rs.getByte(  "age")));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return list;
    }

    public void cleanUsersTable() {
        try {
            final Statement statement = connection.createStatement();
            final String sql = "DELETE FROM db_for_113.users";
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
