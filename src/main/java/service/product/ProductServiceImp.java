package main.java.service.product;

import main.java.model.Catalog;
import main.java.model.Product;
import main.java.util.DBHandle;
import main.java.util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
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

    public List<Product> getProductList(Catalog catalog) throws SQLException {
        List<Product> products = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_CATALOG_ID);
        statement.setInt(1, catalog.getCatalogID());
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

    public Product getProductByDetailID(int id) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_DETAIL_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.first();
        return parseResultSet(resultSet);
    }

    public List<Integer> getSizeList() throws SQLException {
        List<Integer> sizeList = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_FROM_SIZE);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            sizeList.add(resultSet.getInt("size"));
        }
        return sizeList;
    }

    public boolean addNewProduct(Product product) throws SQLException {
        if (addProduct(product)) {
            return addNewProductSize(product) && addNewProductAllImageDB(product);
        }
        return false;
    }

    public boolean addProduct(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.INSERT_NEW_PRODUCT);
        statement.setInt(1, product.getCatalogID());
        statement.setString(2, product.getProductName());
        statement.setString(3, product.getDescription());
        statement.setInt(4, product.getStatus());
        return statement.executeUpdate() != -1;
    }

    public boolean addNewProductAllImageDB(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_NEW_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        int productId = resultSet.getInt("id");
        List<String> imageLinks = product.getImages();
        for (String imageLink : imageLinks) {
            if (!addProductImage(productId, imageLink)) {
                return false;
            }
        }
        return true;
    }

    public boolean addProductImage(int productID, String imageLink) throws SQLException {
        statement = connection.prepareStatement(Query.INSERT_PRODUCT_IMAGE);
        System.out.println(productID);
        statement.setInt(1, productID);
        statement.setString(2, imageLink);
        statement.setInt(3, 1);
        return statement.executeUpdate() != -1;
    }

    public boolean addNewProductSize(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_NEW_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        int productId = resultSet.getInt("id");
        return addProductSize(productId, product.getSize());
    }

    public boolean addProductSize(int productID, int size) throws SQLException {
        statement = connection.prepareStatement(Query.INSERT_PRODUCT_SIZE);
        statement.setInt(1, productID);
        statement.setInt(2, size);
        return statement.executeUpdate() != -1;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        if (updateProductDB(product)) {
            return updateProductSizeDB(product) && updateProductImageDB(product);
        }
        return false;
    }

    public boolean updateProductDB(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.UPDATE_PRODUCT);
        statement.setInt(1, product.getCatalogID());
        statement.setString(2, product.getProductName());
        statement.setString(3, product.getDescription());
        statement.setInt(4, product.getStatus());
        statement.setInt(5, product.getProductID());
        return statement.executeUpdate() != -1;
    }

    public boolean updateProductSizeDB(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.UPDATE_PRODUCT_SIZE);
        statement.setInt(1, product.getSize());
        statement.setInt(2, product.getDetailID());
        return statement.executeUpdate() != -1;
    }

    public boolean updateProductImageDB(Product product) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_ATTACHMENT_ID_BY_PRODUCT_ID);
        statement.setInt(1, product.getProductID());
        ResultSet resultSet = statement.executeQuery();
        List<Integer> idList = new LinkedList<>();
        while (resultSet.next()) {
            idList.add(resultSet.getInt("id"));
        }
        statement = connection.prepareStatement(Query.UPDATE_PRODUCT_IMAGE);
        List<String> imageLinks = product.getImages();
        Iterator<Integer> iterator = idList.iterator();
        for (String imageLink : imageLinks) {
            statement.setString(1, imageLink);
            if (!iterator.hasNext()) {
                if (!addProductImage(product.getProductID(), imageLink)) {
                    return false;
                }
            } else {
                statement.setInt(2, iterator.next());
                if (statement.executeUpdate() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        String query = "UPDATE product_detail SET status = -1 WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeUpdate() != -1;
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
