package main.java.service.product;

import main.java.model.Brand;
import main.java.model.Product;
import main.java.service.brand.IServiceBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public class ServiceProductImp implements IServiceProduct {
    private IServiceBrand serviceBrand;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Product> productList;

    public ServiceProductImp(IServiceBrand serviceBrand) {
        this.serviceBrand = serviceBrand;
    }

    @Override
    public List<Product> getProductList() {
        if (productList == null) {
            productList = new LinkedList<>();
            if (isEmpty()) {
                return productList;
            }
            String query = "SELECT product.id,\n" +
                    "       product.product_code,\n" +
                    "       product.product_name,\n" +
                    "       catalog.id           AS brand_id,\n" +
                    "       catalog.catalog_code AS brand_code,\n" +
                    "       catalog.name         AS brand_name,\n" +
                    "       product.size,\n" +
                    "       product.image_link,\n" +
                    "       product.description,\n" +
                    "       CASE product.status\n" +
                    "           WHEN product.status = 1 THEN 'Đang kinh doanh'\n" +
                    "           WHEN product.status = 0 THEN 'Không kinh doanh'\n" +
                    "           ELSE 'Sản phẩm lỗi'\n" +
                    "           END              AS status\n" +
                    "FROM product\n" +
                    "         JOIN catalog on product.catalog_id = catalog.id;";
            try {
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Brand brand = new Brand(
                            resultSet.getInt("brand_id"),
                            resultSet.getInt("brand_code"),
                            resultSet.getString("brand_name")
                    );
                    int brandIndex = serviceBrand.getBrandList().indexOf(brand);
                    brand = serviceBrand.getBrandList().get(brandIndex);

                    Product product = new Product(
                            resultSet.getInt("id"),
                            resultSet.getInt("product_code"),
                            resultSet.getString("product_name"),
                            resultSet.getInt("size"),
                            resultSet.getString("image_link"),
                            resultSet.getString("description"),
                            resultSet.getString("status"),
                            brand
                    );
                    brand.addProductToBrand(product);
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        getProductList();
        return productList.get(id);
    }

    @Override
    public boolean addProductToDB(Product product) {
        if (!isExist(product.getId())) {
            String query = "INSERT INTO duongshoe.product" +
                    "(" +
                    "catalog_id, " +
                    "product_code, " +
                    "product_name, " +
                    "size, " +
                    "image_link, " +
                    "description, " +
                    "status" +
                    ")" +
                    "VALUES(?,?,?,?,?,?,?);";
            try {
                updateProduct(product, query);
                return (statement.executeUpdate() > -1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        if (!isExist(product.getId())) {
            String query = "UPDATE duongshoe.product " +
                    "SET " +
                    "catalog_id = ?, " +
                    "product_code = ?, " +
                    "product_name = ?, " +
                    "size = ?, " +
                    "image_link = ?, " +
                    "description = ?, " +
                    "status = ?" +
                    "WHERE id = ?;";
            try {
                updateProduct(product, query);
                statement.setInt(8, product.getId());
                return (statement.executeUpdate() > -1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void updateProduct(Product product, String query) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setInt(1, product.getBrand().getId());
        statement.setInt(2, product.getProductCode());
        statement.setString(3, product.getName());
        statement.setInt(4, product.getSize());
        statement.setString(5, product.getImageLink());
        statement.setString(6, product.getDescription());
        statement.setInt(7, product.getStatus().equals("Đang kinh doanh") ? 1 : 0);
    }

    @Override
    public boolean isExist(int id) {
        String query = "SELECT * FROM duongshoe.product WHERE id = ?;";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            if (statement.executeQuery() != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private boolean isEmpty() {
        String query = "SELECT * FROM duongshoe.product;";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            if (resultSet == null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
