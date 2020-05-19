package main.java.service.stock;

import main.java.model.ImportRecord;
import main.java.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class StockServiceImp implements IStockService {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private List<ImportRecord> getImportListOfProduct(Product product) {
        List<ImportRecord> importRecords = new LinkedList<>();
        String query = "SELECT * FROM import\n" +
                "JOIN product_detail on import.product_detail_id = product_detail.id\n" +
                "WHERE product_detail_id = ?;";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, product.getProductID());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ImportRecord importRecord = new ImportRecord();
                importRecord.setImportID(resultSet.getInt("import.id"));
                importRecord.setProductDetailID(resultSet.getInt("product_detail_id"));
                importRecord.setProductCode(resultSet.getString("product_code"));
                importRecord.setPrice(resultSet.getInt("bid"));
                importRecord.setPrice(resultSet.getInt("bid"));
                importRecord.setPrice(resultSet.getInt("bid"));
                importRecord.setImportDateTime(resultSet.getTimestamp("import_date").toLocalDateTime());
                importRecord.setStatus(resultSet.getInt("import.status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
