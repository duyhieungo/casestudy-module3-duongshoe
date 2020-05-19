package main.java.model;

import java.time.LocalDateTime;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class ImportRecord {
    private int importID;
    private int productDetailID;
    private Product product;
    private String productCode;
    private int size;
    private int price;
    private int status;
    private LocalDateTime importDateTime;

    public ImportRecord() {
    }

    public ImportRecord(int importID, int productDetailID, Product product, int size, int price, int status, LocalDateTime importDateTime) {
        this.importID = importID;
        this.productDetailID = productDetailID;
        this.product = product;
        this.size = size;
        this.price = price;
        this.status = status;
        this.importDateTime = importDateTime;
    }

    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return product.getProductName();
    }

    public String getCatalogName() {
        return product.getCatalogName();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getImportDateTime() {
        return importDateTime;
    }

    public void setImportDateTime(LocalDateTime localDateTime) {
        this.importDateTime = localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
