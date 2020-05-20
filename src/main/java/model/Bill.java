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
    public Bill(double amount,
                String message,
                double discount,
                double shipping_fee,
                String payment,
                Date date_of_payment,
                int status,
                Date create_date,
                Date update_date){
        this.amount=amount;
        this.message=message;
        this.discount=discount;
        this.shipping_fee=shipping_fee;
        this.payment=payment;
        this.date_of_payment=date_of_payment;
        this.status=status;
        this.create_date=create_date;
        this.update_date=update_date;
    }


    public Bill(int id,
                int user_id,
                double amount,
                String message,
                double discount,
                double shipping_fee,
                String payment,
                Date date_of_payment,
                int status,
                Date create_date,
                Date update_date){
        this.id=id;
        this.user_id=user_id;
        this.amount=amount;
        this.message=message;
        this.discount=discount;
        this.shipping_fee=shipping_fee;
        this.payment=payment;
        this.date_of_payment=date_of_payment;
        this.status=status;
        this.create_date=create_date;
        this.update_date=update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getDate_of_payment() {
        return date_of_payment;
    }

    public void setDate_of_payment(Date date_of_payment) {
        this.date_of_payment = date_of_payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
};


