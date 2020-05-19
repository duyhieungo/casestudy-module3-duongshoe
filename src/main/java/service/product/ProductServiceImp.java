package main.java.service.product;

import main.java.model.Catalog;
import main.java.model.Product;
import main.java.util.DBHandle;
import main.java.util.Link;

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
    private ResultSet resultSet;

    public ProductServiceImp() {
        connection = DBHandle.getConnection();
    }

    public List<Product> getProductList() {
        List<Product> products = new LinkedList<>();
        String query = "SELECT *\n" +
                "FROM product_detail\n" +
                "         JOIN product on product_detail.product_id = product.id\n" +
                "         JOIN catalog on product.catalog_id = catalog.id\n" +
                "         JOIN size on product_detail.size_id = size.id;";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
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
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<String> getImageLinks(Product product) {
        List<String> imageLinks = new LinkedList<>();
        String query = "SELECT * FROM attachment\n" +
                "WHERE product_id = ?;";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, product.getProductID());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                imageLinks.add(resultSet.getString("image_link"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imageLinks;
    }
}
