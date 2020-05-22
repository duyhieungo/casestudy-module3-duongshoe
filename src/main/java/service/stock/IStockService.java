package main.java.service.stock;

import main.java.model.Catalog;
import main.java.model.ImportRecord;
import main.java.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IStockService {
    List<ImportRecord> getImportRecordByProduct(Product product) throws SQLException;

    List<ImportRecord> getImportRecordByProduct(int detailID) throws SQLException;

    List<ImportRecord> getImportRecordByCatalog(Catalog catalog) throws SQLException;

    List<ImportRecord> getImportRecordByCatalog(int id) throws SQLException;

    List<ImportRecord> getImportRecordBySize(int size) throws SQLException;
}
