package main.java.model;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public class Catalog {
    private int catalogID;
    private int catalogCode;
    private String catalogName;
    private String description;
    private int status;

    public Catalog() {
    }

    public Catalog(int catalogID, int catalogCode, String catalogName, String description, int status) {
        this.catalogID = catalogID;
        this.catalogCode = catalogCode;
        this.catalogName = catalogName;
        this.description = description;
        this.status = status;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public int getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(int catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogID=" + catalogID +
                ", catalogCode=" + catalogCode +
                ", catalogName='" + catalogName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
