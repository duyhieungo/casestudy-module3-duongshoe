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

public class ServiceBrandImp implements IServiceBrand {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Brand> brandList;


    private String query =
            "SELECT import.id,\n" +
                    "       brand.product_name,\n" +
                    "       catalog.name AS brand,\n" +
                    "       brand.size,\n" +
                    "       import.quantity,\n" +
                    "       import.import_date,\n" +
                    "       CASE import.status\n" +
                    "           WHEN import.status = 1 THEN 'Đủ'\n" +
                    "           WHEN import.status = -1 THEN 'Thiếu'\n" +
                    "           WHEN import.status = 0 THEN 'Thừa'\n" +
                    "           END AS status\n" +
                    "FROM import\n" +
                    "         JOIN brand\n" +
                    "              on import.product_id = brand.id\n" +
                    "         JOIN catalog on brand.catalog_id = catalog.id;\n";


    public ServiceBrandImp() {
        connection = DBHandle.getConnection();
        System.out.println(connection);
    }

    public List<Brand> getBrandListDAO() {
        List<Brand> brandList = new ArrayList<>();
        String query = "SELECT catalog.id,\n" +
                "       catalog.name,\n" +
                "       catalog.description,\n" +
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
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Brand brand = new Brand(id, name, description, status);
                brandList.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    public boolean addBrandToDB(Brand brand) {
        if (!isExist(brand)) {
            String query = "INSERT INTO duongshoe.catalog(name, description,status)" +
                    "VALUES(?,?,?)";
            try {
                statement = connection.prepareStatement(query);
                statement.setString(1, brand.getName());
                statement.setString(2, brand.getDescription());
                statement.setInt(3, brand.getStatus().equals("Đang hoạt động") ? 1 : 0);
                return (statement.executeUpdate() > -1);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean updateBrand(Brand brand) {
        if (isExist(brand)) {
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
                return false;
            }
        }
        return false;
    }

    public boolean isExist(Brand brand) {
        String query = "SELECT * FROM duongshoe.catalog WHERE id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, brand.getId());
            if (statement.executeQuery() != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
