package main.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

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
            Class.forName(Jdbc.JDBC_DRIVER);
            connection = DriverManager.getConnection(Jdbc.DATABASE_URL, Jdbc.USER, Jdbc.PASSWORD);
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_001);
        } catch (ClassNotFoundException ex) {
            System.err.println(Error.ERROR_002);
        }
        return connection;
    }
}
