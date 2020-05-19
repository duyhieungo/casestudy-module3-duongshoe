package main.java.service.record.stock;

import main.java.model.ImportRecord;
import main.java.model.Product;
import main.java.service.product.IProductService;
import main.java.util.DBHandle;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class ImportServiceImp implements IImportService {
    private IProductService productService;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<ImportRecord> importRecords;

    public ImportServiceImp(IProductService productService) {
        this.productService = productService;
        connection = DBHandle.getConnection();
    }

    public List<ImportRecord> getImportRecords(int id) {
        if (importRecords == null) {
            importRecords = new LinkedList<>();
            if (isEmpty()) {
                return importRecords;
            }
            String query = "SELECT import.id,\n" +
                    "       import.product_id,\n" +
                    "       import.quantity,\n" +
                    "       import.bid,\n" +
                    "       import.import_date,\n" +
                    "       CASE import.status\n" +
                    "           WHEN import.status = 1 THEN 'Đủ hàng'\n" +
                    "           WHEN import.status = 0 THEN 'Thừa hàng'\n" +
                    "           ELSE 'Thiếu hàng'\n" +
                    "           END AS status\n" +
                    "FROM import\n" +
                    "WHERE product_id = ?;";
            try {
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    ImportRecord record = new ImportRecord(
                            resultSet.getInt("id"),
                            productService.getProductById(id),
                            resultSet.getInt("quantity"),
                            resultSet.getDouble("bid"),
                            resultSet.getTimestamp("import_date").toLocalDateTime(),
                            resultSet.getString("status")
                    );
                    productService.getProductById(id).addImportRecords(record);
                    importRecords.add(record);
                    System.out.println(importRecords);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return importRecords;
    }

    private boolean isEmpty() {
        return false;
    }
}
