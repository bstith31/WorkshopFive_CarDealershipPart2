package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {

    public static List<Contract> getAllContracts(String fileName) {
        List<Contract> contracts; contracts = new ArrayList<>();

        try (BufferedReader bufreader = new BufferedReader(new FileReader("contracts.txt"))) {
            String line;

            while ((line = bufreader.readLine()) != null) {
                String[] splitLine = line.split("\\|");
                String contractType = splitLine[0];
                String date = splitLine[1];
                String customerName = splitLine[2];
                String customerEmail = splitLine[3];
                String vehicleVin = splitLine[4];

                if (contractType.equals("SALE")) {
                    double price = Double.parseDouble(splitLine[5]);
                    double totalPrice = Double.parseDouble(splitLine[6]);
                    boolean finance = splitLine[7].equalsIgnoreCase("YES");
                    double monthlyPayment = Double.parseDouble(splitLine[8]);

                    SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicleVin, finance, price);
                    contracts.add(salesContract);
                } else if (contractType.equals("LEASE")) {
                    double price = Double.parseDouble(splitLine[5]);
                    double totalPrice = Double.parseDouble(splitLine[6]);
                    double monthlyPayment = Double.parseDouble(splitLine[7]);

                    LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicleVin, price);
                    contracts.add(leaseContract);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contracts;
    }

    public static void saveContract(Contract contract, String fileName) {
        try (BufferedWriter bufwriter = new BufferedWriter(new FileWriter("contracts.txt", true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                bufwriter.write(String.format("SALE|%s|%s|%s|%s|%.2f|%.2f|%s|%.2f\n",
                        salesContract.getDate(), salesContract.getCustomerName(), salesContract.getCustomerEmail(),
                        salesContract.getVehicleSold(), salesContract.getTotalPrice(), salesContract.getTotalPrice(),
                        salesContract.isFinance() ? "YES" : "NO", salesContract.getMonthlyPayment()));
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                bufwriter.write(String.format("LEASE|%s|%s|%s|%s|%.2f|%.2f|%.2f\n",
                        leaseContract.getDate(), leaseContract.getCustomerName(), leaseContract.getCustomerEmail(),
                        leaseContract.getVehicleSold(), leaseContract.getTotalPrice(), leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}