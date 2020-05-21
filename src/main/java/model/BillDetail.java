package main.java.model;

import java.io.Serializable;
import java.util.List;

public class BillDetail implements Serializable {
    private int id;
    private User customer;
    private List<Item> items;
    private int status;

    public BillDetail(){
        this.status = 0;
    }

    public BillDetail(int id, User customer, List<Item> items, int status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
