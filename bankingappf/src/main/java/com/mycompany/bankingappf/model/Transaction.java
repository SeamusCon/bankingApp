
package com.mycompany.bankingappf.model;

import java.util.Date;


public class Transaction {
    private String description;
    private Date dateOfTransaction;
    private double amount;

    public Transaction() {
    }

    public Transaction(String description, Date dateOfTransaction, double amount) {
        this.description = description;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "description=" + description + ", dateOfTransaction=" + dateOfTransaction + ", amount=" + amount + '}';
    }
    
    
}
