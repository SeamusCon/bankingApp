
package com.mycompany.bankingappf.services;

import com.mycompany.bankingappf.model.Account;
import com.mycompany.bankingappf.model.Customer;
import com.mycompany.bankingappf.model.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CustomerService {
    public static List<Customer> listOfCustomers = new ArrayList<>();
    
    public List<Customer> createCustomers() throws ParseException {
        
        //Customer(String name, String address, String email, int password)
        Customer c1 = new Customer("Bartomiej Drozd", "72 NCR", "bd", 12345);
        Customer c2 = new Customer("Seamus Conway", "5 Drumcondra", "sc", 54321);
        Customer c3 = new Customer("Tiger Woods", "Kildare", "tw", 76543);
        Customer c4 = new Customer("Shay Given", "80 SCR", "sg", 12644);
        
        //Account(int accountNumber, int sortCode, double currentBalance)
        Account a1c1 = new Account("current", 12345678, 654321, 66.6);
        Account a1c2 = new Account("current", 13291245, 655331, 100.0);
        Account a1c3 = new Account("current", 14236812, 656533, 500.0);
        Account a1c4 = new Account("saving", 15182379, 651001, 900.0);
        Account a1c5 = new Account("saving", 16127946, 654020, 10.0);
        
        //Transaction(String description, Date dateOfTransaction, int amount)
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date firstDate = sdf.parse("2020-07-15");
        java.util.Date secondDate = sdf.parse("2020-06-12");
        java.util.Date thirdDate = sdf.parse("2020-08-12");
        java.util.Date fourthDate = sdf.parse("2020-10-12");
        
        Transaction t1a1c1 = new Transaction("Tesco", firstDate, 37.60);
        Transaction t2a1c1 = new Transaction("Lidl", secondDate, 77.19);
        Transaction t3a1c1 = new Transaction("Nike", thirdDate, 37.60);
        Transaction t4a1c1 = new Transaction("Mace", secondDate, 77.19);
        Transaction t5a1c1 = new Transaction("Saving", fourthDate, 37.60);
        Transaction t6a1c1 = new Transaction("Online purchase", secondDate, 77.19);
        
        List<Transaction> listOfTransactions1 = new ArrayList<>();
        List<Transaction> listOfTransactions2 = new ArrayList<>();
        List<Transaction> listOfTransactions3 = new ArrayList<>();
        List<Transaction> listOfTransactions4 = new ArrayList<>();
        listOfTransactions1.add(t1a1c1);
        listOfTransactions1.add(t2a1c1);
        listOfTransactions2.add(t3a1c1);
        listOfTransactions2.add(t4a1c1);
        listOfTransactions3.add(t5a1c1);
        listOfTransactions4.add(t6a1c1);
        
        a1c1.setListOfTransactions(listOfTransactions1);
        a1c2.setListOfTransactions(listOfTransactions2);
        a1c3.setListOfTransactions(listOfTransactions3);
        a1c4.setListOfTransactions(listOfTransactions4);
        
        List<Account> listOfAccounts1 = new ArrayList<>();
        List<Account> listOfAccounts2 = new ArrayList<>();
        List<Account> listOfAccounts3 = new ArrayList<>();
        List<Account> listOfAccounts4 = new ArrayList<>();
        
        listOfAccounts1.add(a1c1);
        listOfAccounts2.add(a1c2);
        listOfAccounts3.add(a1c3);
        listOfAccounts4.add(a1c4);
        listOfAccounts1.add(a1c5);
        c1.setCustomerAccounts(listOfAccounts1);
        c2.setCustomerAccounts(listOfAccounts2);
        c3.setCustomerAccounts(listOfAccounts3);
        c4.setCustomerAccounts(listOfAccounts4);
        
        listOfCustomers.add(c1);
        listOfCustomers.add(c2);
        listOfCustomers.add(c3);
        listOfCustomers.add(c4);
        
        return listOfCustomers;
    }

    public static List<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public static void setListOfCustomers(List<Customer> listOfCustomers) {
        CustomerService.listOfCustomers = listOfCustomers;
    }
    
    public String login(String login, int password) {
        Customer aCustomer;
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            aCustomer.setCorrectCredentials(false);
        }
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if (login.equals(aCustomer.getUserName()) && password == aCustomer.getPassword()) {
                aCustomer.setCorrectCredentials(true);
                return "Customer: " + aCustomer.getName() + " has successfully logged-in."; 
            }
        }
        return "Your login or password is inccorect, please try again.";
    }
    
    public Account createNewCustomerAccount(String accountName) {
        
        List<Account>listOfAccounts;
        Random rand = new Random();
        int accountNumberGenerator = rand.nextInt(100000000) + 1;
        int sortCodeNumberGenerator = rand.nextInt(1000000) + 1;
        Customer aCustomer;
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.isCorrectCredentials() == true) {
                listOfAccounts = aCustomer.getCustomerAccounts();
                //Account(String accountName, int accountNumber, int sortCode, double currentBalance)
                Account newAccount = new Account(accountName, accountNumberGenerator, sortCodeNumberGenerator, 0.0);
                listOfAccounts.add(newAccount);
                return newAccount;
            }
        }
        return null;
        
    }
    
    public double displayBalance(String accountName) {
        Customer aCustomer;
        List<Account>listOfAccounts;
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.isCorrectCredentials() == true) {
                listOfAccounts = aCustomer.getCustomerAccounts();
                for (int j = 0; j < listOfAccounts.size(); j++) {
                    if(listOfAccounts.get(j).getAccountName().equals(accountName)) {
                        return listOfAccounts.get(j).getCurrentBalance();
                    }
                }
            }
        }
        return -1.0;
    }
    
    public String withdrawFromAccount(int account, double amount) {
      Customer aCustomer;
        List<Account>listOfAccounts;
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.isCorrectCredentials() == true) {
                listOfAccounts = aCustomer.getCustomerAccounts();
                for (int j = 0; j < listOfAccounts.size(); j++) {
                    if(listOfAccounts.get(j).getAccountNumber() == account && (listOfAccounts.get(j).getCurrentBalance()) - amount >= 0) {
                        return "You withdrew EUR " + amount + " from account number: " + account + ". Balance on the account is: " + (listOfAccounts.get(j).getCurrentBalance() - amount);
                    }
                    else
                        return "You have insuficcient balance";
                }
            }
        }
        return "Incorrect login";
    }
    
 public String transferBetweenAccount(int accountNumber, int accountNumber2, double amount) {
        Customer aCustomer;
        List<Account>listOfAccounts;
        Account firstAccount = new Account();
        Account secondAccount = new Account();;
        double firstAccountBalance = 0.0;
        double secondAccountBalance = 0.0;
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.isCorrectCredentials() == true && aCustomer.getCustomerAccounts().size() > 1) {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + aCustomer.getCustomerAccounts().size());
                listOfAccounts = aCustomer.getCustomerAccounts();
                for (int j = 0; j < listOfAccounts.size(); j++) {
                    if(listOfAccounts.get(j).getAccountNumber() == accountNumber) {
                        firstAccount = listOfAccounts.get(j);
                        System.out.println("firstAccount: " + firstAccount);
                        firstAccountBalance = listOfAccounts.get(j).getCurrentBalance();
                    }
                }
                for (int k = listOfAccounts.size() - 1; k >= 0; k--) {
                     if(listOfAccounts.get(k).getAccountNumber() == accountNumber2) {
                        secondAccount = listOfAccounts.get(k);
                        System.out.println("secondAccount: " + secondAccount);
                        secondAccountBalance = listOfAccounts.get(k).getCurrentBalance();
                    }
                }
                if (firstAccountBalance >= amount) {
                    firstAccount.setCurrentBalance(firstAccountBalance - amount);
                    secondAccount.setCurrentBalance(secondAccountBalance + amount);
                    return "EUR " + amount + " was transferred from " + accountNumber + " to account number: " + accountNumber2 + "; balance of accounts is " + firstAccount.getCurrentBalance() + " and " + secondAccount.getCurrentBalance();
                    }
                else if (firstAccount.getAccountNumber() != accountNumber || secondAccount.getAccountNumber() != accountNumber2) {
                    return "One of the accounts provided is inccorect.";
                }
                else {
                    return "Not enough money to transfer from account: " + accountNumber;
                    }
            }
        }
           return "You only have one account or you entered incorrect account number(s) or you did not log in.";
    }
    
       public String lodgementToAccount(int account, double amount) {
      Customer aCustomer;
        List<Account>listOfAccounts;
        
        for (int i = 0; i < listOfCustomers.size(); i++) {
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.isCorrectCredentials() == true) {
                listOfAccounts = aCustomer.getCustomerAccounts();
                for (int j = 0; j < listOfAccounts.size(); j++) {
                    if(listOfAccounts.get(j).getAccountNumber() == account) {
                        return "You lodged EUR " + amount + " to account number: " + account + ". Balance on the account is: " + (listOfAccounts.get(j).getCurrentBalance() + amount);
                    }
                    else
                        return "You have insuficcient balance";
                }
            }
        }
        return "Incorrect login";
    }
       
   public String createNewCustomer(String name, String address, String email, int password){
       // need to generatea new account
        
        List<Account>listOfAccounts = null;
        Random rand = new Random();
        int accountNumberGenerator = rand.nextInt(100000000) + 1;
        int sortCodeNumberGenerator = rand.nextInt(1000000) + 1;
        Customer aCustomer;
        
        for (int i = 0; i < listOfCustomers.size(); i++) { // loop through customers
            aCustomer = listOfCustomers.get(i);
            if(aCustomer.getUserName().equals(email)) {
            aCustomer.getUserName();
            return "Accounts all ready exist on that email address";
            }
            else{
                aCustomer.setName(name);
                aCustomer.setUserName(email);
                aCustomer.setAddress(address);
                aCustomer.setPassword(password);
                Customer Customer = new Customer(name, email,address,password);
                Account a1c1 = new Account("current", accountNumberGenerator, sortCodeNumberGenerator, 66.6);
               return "Congrats " + name + "we have created a new account @" + accountNumberGenerator +  "using the email address " + email + " please be sure to take place your password in a safe place!";
            
            }
        }
        return null;
        
    }
      
    
}
