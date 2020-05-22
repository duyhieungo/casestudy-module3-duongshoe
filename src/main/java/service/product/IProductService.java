package main.java.service.product;

import main.java.model.Catalog;
import main.java.model.Item;
import main.java.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IProductService {
    List<Product> getProductList() throws SQLException;

    List<Product> getProductList(Catalog catalog) throws SQLException;

    List<String> getImageLinks(Product product) throws SQLException;

    Product getProductByDetailID(int id) throws SQLException;

    Product getProductByProductID(int id) throws SQLException;

    List<Integer> getSizeList() throws SQLException;

    boolean addNewProduct(Product product) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    List<Item> getProductForHomePage() throws SQLException;

    List<Integer> getSizeListByProductID(int id) throws SQLException;

    List<Product> getProductListPagination(int offset) throws SQLException;

    int getProductSize() throws SQLException;

  int price(int id) throws SQLException;
}
