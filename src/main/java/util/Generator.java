package main.java.util;

import main.java.util.DBHandle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class Generator {
    public static void main(String[] args) {
        Connection connection = DBHandle.getConnection();
        Random random = new Random();
        String query = "INSERT INTO duongshoe.import " +
                "(product_detail_id, " +
                "product_code, " +
                "bid, " +
                "import_date, " +
                "status) " +
                "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int index = 1; index < 150; index++) {
                statement.setInt(1, random.nextInt(42) + 1);
                statement.setString(2, String.valueOf(100000000 + random.nextInt(899999999)));
                statement.setInt(3, (int) (1000000 + (BigDecimal.valueOf(random.nextDouble()).setScale(1, RoundingMode.HALF_UP).doubleValue() * 1000000)));
                int year = 2010 + random.nextInt(10);
                int month = 1 + random.nextInt(11);
                int day = 1 + random.nextInt(28);
                int hour = 10 + random.nextInt(10);
                int minute = 10 + random.nextInt(40);
                int sec = 10 + random.nextInt(40);
                statement.setString(4, LocalDateTime.of(
                        year, month, day, hour, minute, sec
                ).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                statement.setInt(5, 1);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Sale {
        public static void main(String[] args) {
            Connection connection = DBHandle.getConnection();
            Random random = new Random();
            String query = "INSERT INTO duongshoe.sale " +
                    "(product_id, " +
                    "price, " +
                    "status, " +
                    "created_date) " +
                    "VALUES (?,?,?,?);";
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                for (int index = 1; index < 150; index++) {
                    statement.setInt(1, random.nextInt(10) + 1);
                    statement.setInt(2, (int) (2000000 + (BigDecimal.valueOf(random.nextDouble()).setScale(1, RoundingMode.HALF_UP).doubleValue() * 1000000)));
                    int year = 2010 + random.nextInt(10);
                    int month = 1 + random.nextInt(11);
                    int day = 1 + random.nextInt(28);
                    int hour = 10 + random.nextInt(10);
                    int minute = 10 + random.nextInt(40);
                    int sec = 10 + random.nextInt(40);
                    statement.setInt(3, 1);
                    statement.setString(4, LocalDateTime.of(
                            year, month, day, hour, minute, sec
                    ).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
