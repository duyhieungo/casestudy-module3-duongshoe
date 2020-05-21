package main.java.service.user;

import main.java.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceUser {
    public User selectAdmin() throws SQLException;

    public void createUser(User user) throws SQLException;

    public User selectUser(int id);

    public Map<String, String> selectClient();

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
