package main.java.service.product;

import main.java.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IProductService {
    List<Product> getProductList() throws SQLException;

    List<String> getImageLinks(Product product) throws SQLException;

    Product getProductByID(int id) throws SQLException;

    List<Integer> getSizeList() throws SQLException;

    boolean addToDB(Product product) throws SQLException;
}
