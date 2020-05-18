package main.java.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private int size;
    private int quantity;
    private LocalDateTime importTime;
    private String status;

    public Product() {
    }

    public Product(int id, String name, Brand brand, int size, int quantity, LocalDateTime importTime, String status) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.importTime = importTime;
        this.status = status;
    }

    public Product(String name, Brand brand, int size, int quantity, LocalDateTime importTime, String status) {
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.importTime = importTime;
        this.status = status;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getImportDateTime() {
        return importTime;
    }

    public String getImportDate() {
        return importTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getImportTime() {
        return importTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setImportTime(LocalDateTime importTime) {
        this.importTime = importTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Import{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", importTime=" + importTime +
                ", status='" + status + '\'' +
                '}';
    }
}
