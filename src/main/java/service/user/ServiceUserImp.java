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
    public void insertUser(User user) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement("insert into user (role_id, first_name, last_name, gender, date_of_birth, phone, address, email, username, password, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
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
            System.err.println("Khong them duoc user");
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int roleId;
        String tempRole = null;
        String firstName;
        String lastName;
        boolean gender;
        String tempGender;
        Date dateOfBirth;
        String phone;
        String email;
        int status;
        String tempStatus;
        String address;
        String username;
        String password;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement("select * from user where id = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roleId = resultSet.getInt("role_id");
                switch (roleId) {
                    case 1:
                        tempRole = "Khách hàng";
                        break;
                    case 2:
                        tempRole = "Admin";
                        break;
                    case 3:
                        tempRole = "Khách hàng VIP 1";
                        break;
                    default:
                        break;
                }
                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                gender = resultSet.getBoolean("gender");
                if (gender) {
                    tempGender = "Nam";
                } else {
                    tempGender = "Nữ";
                }
                dateOfBirth = resultSet.getDate("date_of_birth");
                phone = resultSet.getString("phone");
                email = resultSet.getString("email");
                status = resultSet.getInt("status");
                if (status == 1) {
                    tempStatus = "Đang hoạt động";
                } else {
                    tempStatus = "Bị khóa";
                }
                address = resultSet.getString("address");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                user = new User(id, tempRole, firstName, lastName, tempGender, dateOfBirth, phone, email, tempStatus, address, username, password);
            }
        } catch (SQLException ex) {
            System.err.println("Khong tim thay user");
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
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement("delete from user where id = ?;");
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Khong xoa duoc tai khoan");
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate = false;
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DBHandle.getConnection();
            preparedStatement = connection.prepareStatement("update user set role_id = ?, first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, phone = ?, email = ?, status = ?, address = ?, username = ?, password = ? where id = ?;");
            preparedStatement.setInt(1, user.getRoleId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setBoolean(4, user.getGender());
            preparedStatement.setDate(5, user.getDateOfBirth());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getStatus());
            preparedStatement.setString(9, user.getAddress());
            preparedStatement.setString(10, user.getUsername());
            preparedStatement.setString(11, user.getPassword());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Khong update duoc user");
        }
        return rowUpdate;
    }
}
