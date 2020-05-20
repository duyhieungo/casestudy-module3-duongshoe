package main.java.service.dao;

import main.java.model.Product;

import java.util.List;

public interface IProductDAO {
    public Product selectProduct (int id);
    public List<Product> selectAllUsers();
}
