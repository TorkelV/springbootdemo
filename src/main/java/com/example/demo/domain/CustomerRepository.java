package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {

    private HashMap<Integer, Customer> customers;

    private static CustomerRepository instance;

    private CustomerRepository(){
        customers = new HashMap<>();
        customers.put(1, Customer.builder().firstName("Stian").lastName("Fagerli").id(1).isCorporate(true).build());
        customers.put(2, Customer.builder().firstName("Ragnhild").lastName("Sand").id(2).isCorporate(true).build());
        customers.put(3, Customer.builder().firstName("Helene").lastName("Sand").id(3).isCorporate(false).build());
        customers.put(4, Customer.builder().firstName("Emilie").lastName("Sand").id(4).isCorporate(true).build());
        customers.put(5, Customer.builder().firstName("Torkel").lastName("Velure").id(5).isCorporate(false).build());
    }

    public static CustomerRepository getInstance(){
        if(instance==null){
            instance = new CustomerRepository();
        }
        return instance;
    }

    public Customer getCustomer(int id){
        return customers.get(id);
    }

    public List<Customer> getCustomers(){
        return new ArrayList<>(customers.values());
    }




}
