package main.java.service.catalog;

import main.java.model.Catalog;
import main.java.model.Product;
import main.java.util.DBHandle;
import main.java.util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/20/2020
 * @project casestudy-module3-duongshoe
 **/

public class CatalogService implements ICatalogService {
    private Connection connection;
    private PreparedStatement statement;

    public CatalogService() {
        connection = DBHandle.getConnection();
    }

    public List<Catalog> getCatalogList() throws SQLException {
        List<Catalog> catalogList = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_FROM_CATALOG);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Catalog catalog = new Catalog();
            catalog.setCatalogID(resultSet.getInt("id"));
            catalog.setCatalogName(resultSet.getString("name"));
            catalog.setDescription(resultSet.getString("description"));
            catalog.setStatus(resultSet.getInt("status"));
            catalogList.add(catalog);
        }
        return catalogList;
    }
}
