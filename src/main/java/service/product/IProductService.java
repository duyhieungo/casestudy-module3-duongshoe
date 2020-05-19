package main.java.service.product;

import main.java.model.Product;

import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IProductService {
    List<Product> getProductList();

    List<String> getImageLinks(Product product);
}
