
package com.mycompany.bankingappf.model;

import java.util.ArrayList;
import java.util.List;


public class Account {
    private String accountName;
    private int accountNumber;
    private int sortCode;
    private double currentBalance;
    private List<Transaction> listOfTransactions = new ArrayList<>();

    public Account() {
    }

    public Account(String accountName, int accountNumber, int sortCode, double currentBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.currentBalance = currentBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }
    
    

    
    
    
    
}
