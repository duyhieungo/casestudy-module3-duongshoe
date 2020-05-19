package main.java.service.product;

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
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class ProductServiceImp implements IProductService {
    private Connection connection;
    private PreparedStatement statement;

    public ProductServiceImp() {
        connection = DBHandle.getConnection();
    }

    public List<Product> getProductList() throws SQLException {
        List<Product> products = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_ALL_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            products.add(parseResultSet(resultSet));
        }
        return products;
    }

    public List<String> getImageLinks(Product product) throws SQLException {
        List<String> imageLinks = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_ALL_IMAGE_FROM_PRODUCT);
        statement.setInt(1, product.getProductID());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            imageLinks.add(resultSet.getString("image_link"));
        }
        return imageLinks;
    }

    public Product getProductByID(int id) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.first();
        return parseResultSet(resultSet);
    }

    public List<Integer> getSizeList() throws SQLException {
        List<Integer> sizeList = new LinkedList<>();
        String query = "SELECT * FROM size";
        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            sizeList.add(resultSet.getInt("size"));
        }
        return sizeList;
    }

    public boolean addToDB(Product product) throws SQLException {
        String query = "INSERT INTO product" +
                "    (catalog_id, product_name, description, status)" +
                "VALUES (?, ?, ?, ?);";
        statement = connection.prepareStatement(query);
        statement.setInt(1, product.getCatalogID());
        statement.setString(2, product.getProductName());
        statement.setString(3, product.getDescription());
        statement.setInt(4, product.getStatus());
        if (statement.executeUpdate() != -1) {
            String query2 = "INSERT INTO product_detail" +
                    "    (product_id, size_id)" +
                    "VALUES ((SELECT product.id FROM product ORDER BY id DESC LIMIT 1), " +
                    "(SELECT size.id FROM size WHERE size = ?));";
            statement = connection.prepareStatement(query2);
            statement.setInt(1, product.getSize());
            if (statement.executeUpdate() != -1) {
                String query3 = "INSERT INTO attachment(product_id, image_link, status) " +
                        "VALUES ((SELECT product.id FROM product ORDER BY id DESC LIMIT 1),?,1)," +
                        "((SELECT product.id FROM product ORDER BY id DESC LIMIT 1),?,1)," +
                        "((SELECT product.id FROM product ORDER BY id DESC LIMIT 1),?,1);";
                statement = connection.prepareStatement(query3);
                statement.setString(1, product.getImages().get(0));
                statement.setString(2, product.getImages().get(1));
                statement.setString(3, product.getImages().get(2));
                return statement.executeUpdate() != -1;
            }
        }
        return false;
    }

    private Product parseResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        Catalog catalog = new Catalog();
        product.setProductID(resultSet.getInt("product_detail.id"));
        product.setCatalogID(resultSet.getInt("catalog.id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setDescription(resultSet.getString("product.description"));
        product.setStatus(resultSet.getInt("product_detail.status"));
        product.setSize(resultSet.getInt("size"));
        catalog.setCatalogID(resultSet.getInt("catalog.id"));
        catalog.setCatalogName(resultSet.getString("name"));
        catalog.setDescription(resultSet.getString("catalog.description"));
        catalog.setStatus(resultSet.getInt("catalog.status"));
        product.setCatalog(catalog);
        product.setImages(getImageLinks(product));
        return product;
    }
}
