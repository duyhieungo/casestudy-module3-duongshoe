package main.java.model;

import java.time.LocalDateTime;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class Import {
    private int importID;
    private int productDetailID;
    private String productCode;
    private String productName;
    private String catalogName;
    private int size;
    private int price;
    private int status;
    private LocalDateTime localDateTime;

    public Import() {
    }

    public Import(int importID, int productDetailID, String productCode, String productName, String catalogName, int size, int price, int status, LocalDateTime localDateTime) {
        this.importID = importID;
        this.productDetailID = productDetailID;
        this.productCode = productCode;
        this.productName = productName;
        this.catalogName = catalogName;
        this.size = size;
        this.price = price;
        this.status = status;
        this.localDateTime = localDateTime;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
