package com.ps;

public class SalesContract extends Contract {
    private double salesTaxRate;
    private double recordingFee;
    private double processingFee;
    private boolean finance;
    private double financeRateOver10000;
    private double financeRateUnder10000;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, boolean finance, double price) {
        super(date, customerName, customerEmail, vehicleSold, price);
        this.salesTaxRate = 0.05;
        this.recordingFee = 100;
        this.processingFee = price < 10000 ? 295 : 495;
        this.finance = finance;
        this.financeRateOver10000 = 0.0425;
        this.financeRateUnder10000 = 0.0525;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() + (getPrice() * salesTaxRate) + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }
        double rate = getTotalPrice() >= 10000 ? financeRateOver10000 : financeRateUnder10000;
        int months = getTotalPrice() >= 10000 ? 48 : 24;
        return getTotalPrice() * (1 + rate) / months; // Fixed getPrice() to getTotalPrice()
    }

    public boolean isFinance() {
        return finance;
    }
}