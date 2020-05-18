package main.java.model;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

public class Product {
    private int id;
    private int productCode;
    private String name;
    private Brand brand;
    private int size;
    private String imageLink;
    private String description;
    private String status;

    public Product() {
    }

    public Product(int id, int productCode, String name, int size, String imageLink, String description, String status, Brand brand) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLink = imageLink;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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

    @Override
    public String toString() {
        return "Import{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", status='" + status + '\'' +
                '}';
    }
}
