package main.java.service.bill;

import main.java.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/duongshoe?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_BILLS_SQL =
            "INSERT INTO bill" +
                    "  (amount,message,discount,shipping_fee,payment,date_of_payment,status,create_date,update_date) VALUES " +
                    " (?, ?, ?,?, ?, ?,?, ?, ?);";
    private static final String SELECT_BILL_BY_ID =
            "select id,user_id,amount,message,discount,shipping_fee,payment,date_of_payment,status,create_date,update_date " +
                    "from bill where id =?";
    private static final String SELECT_ALL_BILLS = "select * from bill";
    private static final String DELETE_BILLS_SQL = "delete from bill where id = ?;";
    private static final String UPDATE_BILLS_SQL = "update bill set amount=?,message=?,discount=?,shipping_fee=?,payment,date_of_payment=?,status=?,create_date=?,update_date =? " +
            "where id = ?;";

    public BillServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertBill(Bill bill) throws SQLException {
        System.out.println(INSERT_BILLS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILLS_SQL)) {
            preparedStatement.setDouble(1, bill.getAmount());
            preparedStatement.setString(2, bill.getMessage());
            preparedStatement.setDouble(3, bill.getDiscount());
            preparedStatement.setDouble(4, bill.getShipping_fee());
            preparedStatement.setString(5, bill.getPayment());
            preparedStatement.setDate(6, (Date) bill.getDate_of_payment());
            preparedStatement.setInt(7, bill.getStatus());
            preparedStatement.setDate(8, (Date) bill.getCreate_date());
            preparedStatement.setDate(9, (Date) bill.getUpdate_date());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Bill selectBill(int id) {
        Bill bill = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                double amount = rs.getDouble("amount");
                String message = rs.getString("message");
                double discount = rs.getDouble("discount");
                double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                Date date_of_payment = rs.getDate("date_of_payment");
                int status = rs.getInt("status");
                Date create_date = rs.getDate("create_date");
                Date update_date = rs.getDate("update_date");

                bill = new Bill(id, user_id, amount, message, discount, shipping_fee, payment, date_of_payment, status, create_date, update_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bill;
    }

    public List<Bill> selectAllBills() {
        List<Bill> bills = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILLS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                double amount = rs.getDouble("amount");
                String message = rs.getString("message");
                double discount = rs.getDouble("discount");
                double shipping_fee = rs.getDouble("shipping_fee");
                String payment = rs.getString("payment");
                Date date_of_payment = rs.getDate("date_of_payment");
                int status = rs.getInt("status");
                Date create_date = rs.getDate("create_date");
                Date update_date = rs.getDate("update_date");
                bills.add(new Bill(id, user_id, amount, message, discount, shipping_fee, payment, date_of_payment, status, create_date, update_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bills;
    }

    public boolean deleteBill(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BILLS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBill(Bill bill) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BILLS_SQL);) {
            statement.setDouble(1, bill.getAmount());
            statement.setString(2, bill.getMessage());
            statement.setDouble(3, bill.getDiscount());
            statement.setDouble(4, bill.getShipping_fee());
            statement.setString(5, bill.getPayment());
            statement.setDate(6, (Date) bill.getDate_of_payment());
            statement.setInt(7, bill.getStatus());
            statement.setDate(8, (Date) bill.getCreate_date());
            statement.setDate(9, (Date) bill.getUpdate_date());
            statement.setInt(10, bill.getUser_id());
            statement.setInt(11, bill.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
