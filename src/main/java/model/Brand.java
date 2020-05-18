package main.java.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public class Brand {
    private int id;
    private String name;
    private String description;
    private String status;
    private List<Product> productList;

    public Brand() {
        productList = new LinkedList<>();
    }

    public Brand(int id, String name, String description, String status) {
        productList = new LinkedList<>();
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Brand(String name, String description, String status) {
        productList = new LinkedList<>();
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public Brand(String name, String description, String status, Product product) {
        productList = new LinkedList<>();
        this.name = name;
        this.description = description;
        this.status = status;
        productList.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToBrand(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
