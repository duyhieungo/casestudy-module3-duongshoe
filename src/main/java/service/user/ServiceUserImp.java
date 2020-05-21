package main.java.service.user;

import main.java.model.User;
import main.java.util.DBHandle;
import main.java.util.Error;
import main.java.util.Query;

import java.sql.*;
import java.util.ArrayList;
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
            connection = DBHandle.getConnection();
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
    public void createUser(User user) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement(Query.CREATE_USER_WITH_PARAMETERS);
            preparedStatement.setInt(1, user.getRoleId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setBoolean(4, user.getGender());
            preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getUsername());
            preparedStatement.setString(10, user.getPassword());
            preparedStatement.setInt(11, user.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_014);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int roleId;
        int status;
        boolean gender;
        Date dateOfBirth;
        String firstName, lastName;
        String phone, email, address;
        String username, password;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement(Query.SELECT_USER_WITH_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roleId = resultSet.getInt("role_id");
                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                gender = resultSet.getBoolean("gender");
                dateOfBirth = resultSet.getDate("date_of_birth");
                phone = resultSet.getString("phone");
                email = resultSet.getString("email");
                status = resultSet.getInt("status");
                address = resultSet.getString("address");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                user = new User(roleId, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status);
            }
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_015);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int id;
        int role;
        String name;
        int status;
        try {
            users = new ArrayList<>();
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement(Query.SELECT_INFORMATION_FROM_USER);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                role = resultSet.getInt("role_id");
                name = resultSet.getString("first_name");
                status = resultSet.getInt("status");
                users.add(new User(id, name, role, status));
            }
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_007);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement(Query.DELETE_USER_WITH_ID);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_016);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement(Query.UPDATE_USER_WITH_ID);
            preparedStatement.setInt(1, user.getRoleId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setBoolean(4, user.getGender());
            preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getUsername());
            preparedStatement.setString(10, user.getPassword());
            preparedStatement.setInt(11, user.getStatus());
            preparedStatement.setInt(12, user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_017);
        }
        return rowUpdate;
    }
}
