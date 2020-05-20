package main.java.model;

import java.util.Date;

public class Bill {
    private int id;
    private int user_id;
    private double amount;
    private String message;
    private double discount;
    private double shipping_fee;
    private String payment;
    private Date date_of_payment;
    private int status;
    private Date create_date;
    private Date update_date;

    public Bill() {
    }
};


