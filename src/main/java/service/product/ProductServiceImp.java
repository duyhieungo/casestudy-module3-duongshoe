/*

package main.java.service.product;

import main.java.model.Brand;
import main.java.model.Product;
import main.java.service.brand.IBrandService;
import main.java.util.DBHandle;
import main.java.util.Query;

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

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **//*



public class ProductServiceImp implements IProductService {

    private IBrandService serviceBrand;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Product> productList;

    public ProductServiceImp(IBrandService serviceBrand) {
        this.serviceBrand = serviceBrand;
        connection = DBHandle.getConnection();
    }

    @Override
    public List<Product> getProductList() {
        if (productList == null) {
            productList = new LinkedList<>();
            if (isEmpty()) {
                return productList;
            }
            try {
                statement = connection.prepareStatement(Query.SELECT_ALL_PRODUCTS);
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

    public List<Product> getProductListWithImage() {
        List<Product> products = getProductList();
        try {
            statement = connection.prepareStatement(Query.SELECT_ALL_IMAGES);
            resultSet = statement.executeQuery();
            int productID = resultSet.getInt("product_id");
            String imageLink = resultSet.getString("image_link");
            products.get(productID).addImageLink(imageLink);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public Product getProductById(int id) {
        return getProductList().get(id);
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
                    "description, " +
                    "status" +
                    ")" +
                    "VALUES(?,?,?,?,?,?);";
            try {
                setParam(product, query);
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
                    "description = ?, " +
                    "status = ?" +
                    "WHERE id = ?;";
            try {
                setParam(product, query);
                statement.setInt(7, product.getId());
                return (statement.executeUpdate() > -1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void setParam(Product product, String query) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setInt(1, product.getBrand().getId());
        statement.setInt(2, product.getProductCode());
        statement.setString(3, product.getName());
        statement.setInt(4, product.getSize());
        statement.setString(5, product.getDescription());
        statement.setInt(6, product.getStatus().equals("Đang kinh doanh") ? 1 : 0);
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
*/
