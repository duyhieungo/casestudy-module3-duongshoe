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
        statement = connection.prepareStatement(Query.INSERT_NEW_PRODUCT);
        statement.setInt(1, product.getCatalogID());
        statement.setString(2, product.getProductName());
        statement.setString(3, product.getDescription());
        statement.setInt(4, product.getStatus());
        if (statement.executeUpdate() != -1) {
            statement = connection.prepareStatement(Query.INSERT_PRODUCT_SIZE);
            statement.setInt(1, product.getSize());
            if (statement.executeUpdate() != -1) {
                statement = connection.prepareStatement(Query.INSERT_PRODUCT_IMAGE);
                List<String> imageLinks = product.getImages();
                for (String imageLink : imageLinks) {
                    statement.setString(1, imageLink);
                    if (statement.executeUpdate() == -1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDB(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.UPDATE_PRODUCT);
        statement.setInt(1, product.getCatalogID());
        statement.setString(2, product.getProductName());
        statement.setString(3, product.getDescription());
        statement.setInt(4, product.getStatus());
        statement.setInt(5, product.getProductID());
        if (statement.executeUpdate() != -1) {
            statement = connection.prepareStatement(Query.UPDATE_PRODUCT_SIZE);
            statement.setInt(1, product.getSize());
            statement.setInt(2, product.getDetailID());
            if (statement.executeUpdate() != -1) {
                statement = connection.prepareStatement(Query.SELECT_ATTACHMENT_ID_BY_PRODUCT_ID);
                statement.setInt(1, product.getProductID());
                ResultSet resultSet = statement.executeQuery();
                List<Integer> idList = new LinkedList<>();
                resultSet.next();
                while (resultSet.next()) {
                    idList.add(resultSet.getInt("id"));
                }
                statement = connection.prepareStatement(Query.UPDATE_PRODUCT_IMAGE);
                List<String> imageLinks = product.getImages();
                int count = 0;
                for (String imageLink : imageLinks) {
                    statement.setString(1, imageLink);
                    statement.setInt(2, idList.get(count++));
                    if (statement.executeUpdate() == -1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private Product parseResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        Catalog catalog = new Catalog();
        product.setDetailID(resultSet.getInt("product_detail.id"));
        product.setProductID(resultSet.getInt("product_id"));
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
