package main.java.service.brand;

import main.java.model.Brand;
import main.java.util.DBHandle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

public class BrandServiceImp implements IBrandService {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Brand> brandList;

    public BrandServiceImp() {
        connection = DBHandle.getConnection();
    }

    public List<Brand> getBrandList() {
        if (brandList == null) {
            brandList = new ArrayList<>();
            if (isEmpty()) {
                return brandList;
            }
            String query = "SELECT catalog.id,\n" +
                    "catalog.catalog_code,\n" +
                    "catalog.name,\n" +
                    "catalog.description,\n" +
                    "       CASE\n" +
                    "           catalog.status\n" +
                    "           WHEN catalog.status = 1 THEN 'Đang hoạt động'\n" +
                    "           WHEN catalog.status = 0 THEN 'Ngừng hoạt động'\n" +
                    "           END AS status\n" +
                    "FROM catalog;\n";
            try {
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int code = resultSet.getInt("catalog_code");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String status = resultSet.getString("status");
                    Brand brand = new Brand(id, code, name, description, status);
                    brandList.add(brand);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return brandList;
    }

    @Override
    public boolean addBrandToDB(Brand brand) {
        if (!isExist(brand.getId())) {
            String query = "INSERT INTO duongshoe.catalog(name, description, status)" +
                    "VALUES(?,?,?)";
            try {
                statement = connection.prepareStatement(query);
                statement.setString(1, brand.getName());
                statement.setString(2, brand.getDescription());
                statement.setInt(3, brand.getStatus().equals("Đang hoạt động") ? 1 : 0);
                return (statement.executeUpdate() > -1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        if (isExist(brand.getId())) {
            String query = "UPDATE duongshoe.catalog SET name = ?, description = ?, status = ? WHERE id = ?";
            try {
                statement = connection.prepareStatement(query);
                statement.setString(1, brand.getName());
                statement.setString(2, brand.getDescription());
                statement.setInt(3, brand.getStatus().equals("Đang hoạt động") ? 1 : 0);
                statement.setInt(4, brand.getId());
                if (statement.executeUpdate() > -1) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Brand getBrandById(int id) {
        getBrandList();
        return brandList.get(id);
    }

    @Override
    public boolean isExist(int id) {
        String query = "SELECT * FROM duongshoe.catalog WHERE id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            if (statement.executeQuery() != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isEmpty() {
        String query = "SELECT * FROM duongshoe.catalog;";
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