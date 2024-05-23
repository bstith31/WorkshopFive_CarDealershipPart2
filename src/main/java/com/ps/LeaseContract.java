package com.ps;

public class LeaseContract extends Contract {
    private double leaseFeeRate;
    private double financeRate;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double price) {
        super(date, customerName, customerEmail, vehicleSold, price);
        this.leaseFeeRate = 0.07;
        this.financeRate = 0.04;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() + (getPrice() * leaseFeeRate);
    }

    @Override
    public double getMonthlyPayment() {
        int months = 36;
        return getTotalPrice() * (1 + financeRate) / months; // Fixed getPrice() to getTotalPrice()
    }
}