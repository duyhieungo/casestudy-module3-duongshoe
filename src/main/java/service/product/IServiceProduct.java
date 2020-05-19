package main.java.service.product;

import main.java.model.Brand;
import main.java.model.Product;

import java.util.List;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IServiceProduct {
    List<Product> getProductList();

    Product getProductById(int id);

    boolean addProductToDB(Product product);

    boolean updateProduct(Product product);

    boolean isExist(int id);

}
