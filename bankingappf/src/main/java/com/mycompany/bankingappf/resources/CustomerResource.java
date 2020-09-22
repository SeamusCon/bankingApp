package com.mycompany.bankingappf.resources;

import com.google.gson.Gson;
import com.mycompany.bankingappf.model.Account;
import com.mycompany.bankingappf.model.Customer;
import com.mycompany.bankingappf.services.CustomerService;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/banking")
public class CustomerResource {

    CustomerService cs = new CustomerService();

    //http://localhost:49000/api/banking/createJSON
    @GET
    @Path("/createJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomers() throws ParseException {
        Gson gson = new Gson();

        List<Customer> list = cs.createCustomers();

        return Response.status(Response.Status.CREATED).entity(gson.toJson(list)).build();
    }

    //http://localhost:49000/api/banking/create
    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> createCustomersXML() throws ParseException {
        return cs.createCustomers();
    }

    //http://localhost:49000/api/banking/retrieveJSON
    @GET
    @Path("/retrieveJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() throws ParseException {
        Gson gson = new Gson();

        List<Customer> list = cs.getListOfCustomers();

        return Response.status(Response.Status.CREATED).entity(gson.toJson(list)).build();
    }

    //http://localhost:49000/api/banking/retrieveXML
    @GET
    @Path("/retrieveXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomersXML() throws ParseException {
        return cs.getListOfCustomers();
    }

    //only data of one user can be modified at time
    //http://localhost:49000/api/banking/login/bd/12345
    @GET
    @Path("/login/{customerID}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginCustomer(@PathParam("customerID") String customerID, @PathParam("customerPassword") int customerPassword) throws ParseException {
        Gson gson = new Gson();

        String loginSuccess = cs.login(customerID, customerPassword);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(loginSuccess)).build();
    }

    //only data of one user can be modified at time
    //http://localhost:49000/api/banking/login/bd/12345
    @GET
    @Path("/login/{customerID}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Response loginCustomerXML(@PathParam("customerID") String customerID, @PathParam("customerPassword") int customerPassword) throws ParseException {
        Gson gson = new Gson();

        String loginSuccess = cs.login(customerID, customerPassword);
        System.out.println("Inlog in XML" + loginSuccess);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(loginSuccess)).build();
        
    }

    //http://localhost:49000/api/banking/createAccount/testAccount
    @POST
    @Path("/createAccount/{accountName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomerAccount(@PathParam("accountName") String accountName) throws ParseException {
        Gson gson = new Gson();

        Account newAccount = cs.createNewCustomerAccount(accountName);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(newAccount)).build();
    }

    //http://localhost:49000/api/banking/createAccount/testAccount
    @POST
    @Path("/createAccount/{accountName}")
    @Produces(MediaType.APPLICATION_XML)
    public Account createCustomerAccountXML(@PathParam("accountName") String accountName) throws ParseException {

        Account newAccount = cs.createNewCustomerAccount(accountName);

        return newAccount;
    }

    //http://localhost:49000/api/banking/showBalance/current
    @GET
    @Path("/showBalance/{accountName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayCustomerAccountBalance(@PathParam("accountName") String accountName) throws ParseException {
        Gson gson = new Gson();
        String balance = new String();
        Double balanceOnAccount = cs.displayBalance(accountName);
        if (balanceOnAccount >= 0) {
            balance = "Balance on " + accountName + " is: " + balanceOnAccount;
            return Response.status(Response.Status.CREATED).entity(gson.toJson(balance)).build();
        } else {
            balance = "No such account or user is not logged in!";
            return Response.status(Response.Status.CREATED).entity(gson.toJson(balance)).build();
        }
    }

    //http://localhost:49000/api/banking/showBalanceXML/current
    @GET
    @Path("/showBalanceXML/{accountName}")
    @Produces(MediaType.APPLICATION_XML)
    public Response displayCustomerAccountBalanceXML(@PathParam("accountName") String accountName) throws ParseException {
        Gson gson = new Gson();
        String balance = new String();
        Double balanceOnAccount = cs.displayBalance(accountName);
        if (balanceOnAccount >= 0) {
            balance = "Balance on " + accountName + " is: " + balanceOnAccount;
            return Response.status(Response.Status.CREATED).entity(gson.toJson(balance)).build();
        } else {
            balance = "No such account or user is not logged in!";
            return Response.status(Response.Status.CREATED).entity(gson.toJson(balance)).build();
        }
    }

    //http://localhost:49000/api/banking/withdraw/12345678/50
    @PUT
    @Path("/withdraw/{accountNumber}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withdrawal(@PathParam("accountNumber") int accountNumber, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String with = cs.withdrawFromAccount(accountNumber, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(with)).build();
    }

    //http://localhost:49000/api/banking/withdraw/12345678/50
    @PUT
    @Path("/withdrawXML/{accountNumber}/{amount}")
    @Produces(MediaType.APPLICATION_XML)
    public Response withdrawalXML(@PathParam("accountNumber") int accountNumber, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String with = cs.withdrawFromAccount(accountNumber, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(with)).build();
    }

    //http://localhost:49000/api/banking/12345678/12868833/50
    @PUT
    @Path("/{accountNumber}/{accountNumber2}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response transfer(@PathParam("accountNumber") int accountNumber, @PathParam("accountNumber2") int accountNumber2, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String transf = cs.transferBetweenAccount(accountNumber, accountNumber2, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(transf)).build();
    }

    //http://localhost:49000/api/banking/12345678/12868833/50
    @PUT
    @Path("/transferXML/{accountNumber}/{accountNumber2}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferXML(@PathParam("accountNumber") int accountNumber, @PathParam("accountNumber2") int accountNumber2, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String transf = cs.transferBetweenAccount(accountNumber, accountNumber2, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(transf)).build();
    }

    //http://localhost:49000/api/banking/lodgment/12345678/50
    @PUT
    @Path("/lodgment/{accountNumber}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lodgment(@PathParam("accountNumber") int accountNumber, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String lodge = cs.lodgementToAccount(accountNumber, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(lodge)).build();
    }

    //http://localhost:49000/api/banking/lodgment/12345678/50
    @PUT
    @Path("/lodgmentXML/{accountNumber}/{amount}")
    @Produces(MediaType.APPLICATION_XML)
    public Response lodgmentXML(@PathParam("accountNumber") int accountNumber, @PathParam("amount") double amount) throws ParseException {
        Gson gson = new Gson();

        String lodge = cs.lodgementToAccount(accountNumber, amount);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(lodge)).build();
    }
    //http://localhost:49000/api/banking/newCustomer/shayC/123 fake street/bd@gmail.com/12345
    //(String name, String address, String email, int password)

    @GET
    @Path("/newCustomer/{name}/{address}/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newCustomer(@PathParam("name") String name, @PathParam("address") String address, @PathParam("email") String email, @PathParam("password") int password) throws ParseException {
        Gson gson = new Gson();

        String newCustomer = cs.createNewCustomer(email, address, email, password);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(newCustomer)).build();
    }

    @GET
    @Path("/newCustomerXML/{name}/{address}/{email}/{password}")
    @Produces(MediaType.APPLICATION_XML)
    public Response newCustomerXML(@PathParam("name") String name, @PathParam("address") String address, @PathParam("email") String email, @PathParam("password") int password) throws ParseException {
        Gson gson = new Gson();

        String newCustomer = cs.createNewCustomer(email, address, email, password);

        return Response.status(Response.Status.CREATED).entity(gson.toJson(newCustomer)).build();
    }


    @GET
    @Path("/guiLogIn")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guiLogIn(@Context UriInfo info) {
       // Gson gson = new Gson();
      
      String test = "One of the inputs is incorrect";
      String loginSuccess = new String(); 
       
      String email = info.getQueryParameters().getFirst("email");
      String passwordS = info.getQueryParameters().getFirst("password");
      
      String account1 = info.getQueryParameters().getFirst("account1");
      String account2 = info.getQueryParameters().getFirst("account2");
      String amount = info.getQueryParameters().getFirst("amount");
      
      
      String accountOfWithdrawal = info.getQueryParameters().getFirst("withdrawalAccount");
      String amountOfWithdrawal = info.getQueryParameters().getFirst("withdrawalAmount");
      //String with = cs.withdrawFromAccount(accountNumber, amount);
      
      if (!accountOfWithdrawal.isEmpty() && !amountOfWithdrawal.isEmpty()) {
        String withdrawal = cs.withdrawFromAccount(Integer.parseInt(accountOfWithdrawal), Integer.parseInt(amountOfWithdrawal));
        return Response.status(200).entity(withdrawal).build();
      }
      
      if  (!account1.isEmpty() && !account2.isEmpty() && !amount.isEmpty()) {
        String transferSuccess = cs.transferBetweenAccount(Integer.parseInt(account1), Integer.parseInt(account2), Integer.parseInt(amount));
        return Response.status(200).entity(transferSuccess).build();
      }

      if (!email.isEmpty() && !passwordS.isEmpty()) {
        loginSuccess = cs.login(email, Integer.parseInt(passwordS));
        return Response.status(200).entity(loginSuccess).build();
      }
      
    
     return Response.status(200).entity(test).build();

     
    }
    
    
    @GET
    @Path("/guiTransfer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guiTransfer(@Context UriInfo info) {
       // Gson gson = new Gson();
      
      
      String account1 = info.getQueryParameters().getFirst("account1");
      String account2 = info.getQueryParameters().getFirst("account2");
      String amount = info.getQueryParameters().getFirst("amount");
      
      
      

     String transferSuccess = cs.transferBetweenAccount(Integer.parseInt(account1), Integer.parseInt(account2), Integer.parseInt(amount));
        //System.out.println("AAAAAA");
            
     return Response.status(200).entity(transferSuccess).build();
    }
    
@GET
@Path("/echo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response post(String entity){
return Response.status(200).entity(entity).build();
}

}
