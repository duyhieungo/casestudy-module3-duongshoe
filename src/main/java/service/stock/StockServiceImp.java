package main.java.service.stock;

import main.java.model.ImportRecord;
import main.java.model.Product;
import main.java.service.product.IProductService;
import main.java.service.product.ProductServiceImp;
import main.java.util.DBHandle;
import main.java.util.Query;

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
    private IProductService productService;

    public StockServiceImp() {
        connection = DBHandle.getConnection();
        productService = new ProductServiceImp();
    }

    public StockServiceImp(IProductService productService) {
        connection = DBHandle.getConnection();
        this.productService = productService;
    }

    public List<ImportRecord> getImportRecordByProduct(Product product) throws SQLException {
        return getImportRecordByProductID(product.getProductID());
    }

    public List<ImportRecord> getImportRecordByProductID(int id) throws SQLException {
        List<ImportRecord> importRecords = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_IMPORT_BY_PRODUCT_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            importRecords.add(parseResultSet(resultSet));
        }
        return importRecords;
    }

    private ImportRecord parseResultSet(ResultSet resultSet) throws SQLException {
        ImportRecord importRecord = new ImportRecord();
        importRecord.setImportID(resultSet.getInt("import.id"));
        importRecord.setProductDetailID(resultSet.getInt("product_detail_id"));
        importRecord.setProductCode(resultSet.getString("product_code"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setImportDateTime(resultSet.getTimestamp("import_date").toLocalDateTime());
        importRecord.setStatus(resultSet.getInt("import.status"));
        importRecord.setProduct(productService.getProductByID(resultSet.getInt("product_detail_id")));
        return importRecord;
    }
}
