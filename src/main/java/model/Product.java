package main.java.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class Product {
    private int detailID;
    private int productID;
    private int catalogID;
    private String productName;
    private String description;
    private int status;
    private Catalog catalog;
    private int size;
    private List<String> images;

    public Product() {
        images = new LinkedList<>();
        catalog = new Catalog();
    }

    public Product(int detailID, int productID, int catalogID, String productName, String description, int status, Catalog catalog, int size, List<String> images) {
        this.detailID = detailID;
        this.productID = productID;
        this.catalogID = catalogID;
        this.productName = productName;
        this.description = description;
        this.status = status;
        this.catalog = catalog;
        this.size = size;
        this.images = images;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getCatalogName() {
        return catalog.getCatalogName();
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void addImages(String imageLink) {
        images.add(imageLink);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + detailID +
                ", catalogId=" + catalogID +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}