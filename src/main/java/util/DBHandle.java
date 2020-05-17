package main.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

public class DBHandle {
    private DBHandle() {
    }

    public static Connection getConnection() {
        String urlDB = "jdbc:mysql://localhost:3306/duongshoe";
        String userDB = "root";
        String passDB = "123456";

        try {
            return DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
