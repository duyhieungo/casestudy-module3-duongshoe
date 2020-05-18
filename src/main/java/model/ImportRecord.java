package main.java.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public class ImportRecord {
    private int id;
    private Product product;
    private int quantity;
    private double unitPrice;
    private LocalDateTime importDateTime;
    private String status;

    public ImportRecord() {
    }

    public ImportRecord(int id, Product product, int quantity, double unitPrice, LocalDateTime importDateTime, String status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.importDateTime = importDateTime;
        this.status = status;
    }

    public ImportRecord(Product product, int quantity, double unitPrice, LocalDateTime importDateTime, String status) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.importDateTime = importDateTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getImportDateTime() {
        return importDateTime;
    }

    public void setImportDateTime(LocalDateTime importDateTime) {
        this.importDateTime = importDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getImportTime() {
        return importDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getImportDate() {
        return importDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return "Import{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", importTime=" + importDateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
