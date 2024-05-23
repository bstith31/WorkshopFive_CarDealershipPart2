package com.ps;

abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private String vehicleSold;
    private double price; // Added price field

    public Contract(String date, String customerName, String customerEmail, String vehicleSold, double price) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.price = price; // Initialize price
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}