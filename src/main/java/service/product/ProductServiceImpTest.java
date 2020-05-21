package main.java.service.product;

import main.java.model.Catalog;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Duc on 5/21/2020
 * @project casestudy-module3-duongshoe
 **/

class ProductServiceImpTest {

    @Test
    void getProductList() throws SQLException {
        ProductServiceImp serviceImp = new ProductServiceImp();
        Catalog catalog = new Catalog();
        catalog.setCatalogID(2);
        System.out.println(serviceImp.getProductList(catalog));
    }
}