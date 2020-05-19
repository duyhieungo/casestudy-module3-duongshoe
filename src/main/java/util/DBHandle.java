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

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC.JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC.DATABASE_URL, JDBC.USER, JDBC.PASSWORD);
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_001);
        } catch (ClassNotFoundException ex) {
            System.err.println(Error.ERROR_002);
        }
        return connection;
    }
}
