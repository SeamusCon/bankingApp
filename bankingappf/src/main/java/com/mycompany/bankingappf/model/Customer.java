
package com.mycompany.bankingappf.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private String name;
    private String address;
    private String userName;
    protected int password;
    private boolean correctCredentials = false;
    private List<Account> customerAccounts = new ArrayList<>();

    public Customer() {
    }
    
    

    public Customer(String name, String address, String userName, int password) {
        this.name = name;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isCorrectCredentials() {
        return correctCredentials;
    }

    public void setCorrectCredentials(boolean correctCredentials) {
        this.correctCredentials = correctCredentials;
    }

    public List<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<Account> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }
    
    

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", user name=" + userName + ", password=" + password + ", correctCredentials=" + correctCredentials + '}';
    }
    
    
}
