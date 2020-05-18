package main.java.service.user;

import main.java.model.User;
import main.java.util.DBHandle;
import main.java.util.Error;
import main.java.util.Link;
import main.java.util.Query;

import java.sql.*;
import java.util.List;

public class ServiceUserImp implements IServiceUser {

    @Override
    public User selectAdmin() {
        User admin = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String username;
        String password;
        try {
            connection = DBHandle.getConnec();
            preparedStatement = connection.prepareStatement(Query.SELECT_ADMIN_FROM_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                admin = new User(username, password);
            }
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_003);
        }
        return admin;
    }

    @Override
    public void insertUser(User user) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
