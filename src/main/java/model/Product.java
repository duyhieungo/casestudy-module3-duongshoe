package main.java.model;

import java.util.LinkedList;
import java.util.List;

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
    private List<String> imageLinks;
    private String description;
    private String status;
    private List<ImportRecord> importRecords;
    private List<SaleRecord> saleRecords;
    private List<BillRecord> billRecords;

    public Product() {
        imageLinks = new LinkedList<>();
        importRecords = new LinkedList<>();
        saleRecords = new LinkedList<>();
        billRecords = new LinkedList<>();
    }

    public Product(int id, int productCode, String name, Brand brand, int size, List<String> imageLinks, String description, String status, List<ImportRecord> importRecords, List<SaleRecord> saleRecords, List<BillRecord> billRecords) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = imageLinks;
        this.description = description;
        this.status = status;
        this.importRecords = importRecords;
        this.saleRecords = saleRecords;
        this.billRecords = billRecords;
    }

    public Product(int id, int productCode, String name, Brand brand, int size, List<String> imageLinks) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = imageLinks;
    }

    public Product(int id, int productCode, String name, Brand brand, int size, String imageLink) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = new LinkedList<>();
        imageLinks.add(imageLink);
    }


    public Product(int id, int productCode, String name, Brand brand, int size, String description, String status, ImportRecord importRecord) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = new LinkedList<>();
        this.description = description;
        this.status = status;
        this.importRecords = new LinkedList<>();
        this.importRecords.add(importRecord);
    }

    public Product(int id, int productCode, String name, Brand brand, int size, String description, String status, SaleRecord saleRecord) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = new LinkedList<>();
        this.description = description;
        this.status = status;
        this.saleRecords = new LinkedList<>();
        this.saleRecords.add(saleRecord);
    }

    public Product(int id, int productCode, String name, Brand brand, int size, String description, String status, BillRecord billRecord) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.imageLinks = new LinkedList<>();
        this.description = description;
        this.status = status;
        this.billRecords = new LinkedList<>();
        this.billRecords.add(billRecord);
    }

    public Product(int id, int productCode, String name, int size, String description, String status, Brand brand) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.description = description;
        this.status = status;
    }

    public Product(int id, int productCode, String name, int size, String description, String status) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.size = size;
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

    public String getBrandName() {
        return brand.getName();
    }

    public void setBrandName(String name) {
        brand.setName(name);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<String> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public boolean addImageLink(String imageLink) {
        return imageLinks.add(imageLink);
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

    public List<ImportRecord> getImportRecords() {
        return importRecords;
    }

    public void setImportRecords(List<ImportRecord> importRecords) {
        this.importRecords = importRecords;
    }

    public List<SaleRecord> getSaleRecords() {
        return saleRecords;
    }

    public void setSaleRecords(List<SaleRecord> saleRecords) {
        this.saleRecords = saleRecords;
    }

    public boolean addSaleRecords(SaleRecord saleRecord) {
        return saleRecords.add(saleRecord);
    }

    public List<BillRecord> getBillRecords() {
        return billRecords;
    }

    public void setBillRecords(List<BillRecord> billRecords) {
        this.billRecords = billRecords;
    }

    public boolean addBillRecord(BillRecord billRecord) {
        return billRecords.add(billRecord);
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
