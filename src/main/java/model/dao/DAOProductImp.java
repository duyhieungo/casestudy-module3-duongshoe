package main.java.model.dao;

import main.java.model.product.Import;
import main.java.util.DBHandle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

public class DAOProductImp implements IDAOProduct {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public DAOProductImp() {
        connection = DBHandle.getConnection();
        System.out.println(connection);
    }

    public List<Import> getImportList() {
        List<Import> importList = new ArrayList<>();
        String query =
                "SELECT import.id,\n" +
                        "       product.product_name,\n" +
                        "       catalog.name AS brand,\n" +
                        "       product.size,\n" +
                        "       import.quantity,\n" +
                        "       import.import_date,\n" +
                        "       CASE import.status\n" +
                        "           WHEN import.status = 1 THEN 'Đủ'\n" +
                        "           WHEN import.status = -1 THEN 'Thiếu'\n" +
                        "           WHEN import.status = 0 THEN 'Thừa'\n" +
                        "           END AS status\n" +
                        "FROM import\n" +
                        "         JOIN product\n" +
                        "              on import.product_id = product.id\n" +
                        "         JOIN catalog on product.catalog_id = catalog.id;\n";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                String brand = resultSet.getString("brand");
                int size = resultSet.getInt("size");
                int quantity = resultSet.getInt("quantity");
                LocalDateTime importTime = resultSet.getTimestamp("import_date").toLocalDateTime();
                String status = resultSet.getString("status");
                importList.add(new Import(id, name, brand, size, quantity, importTime, status));
            }
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return importList;
    }
}
