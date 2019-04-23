package com.example.demo.api;

import com.example.demo.domain.Customer;
import com.example.demo.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    private CustomerController(){
        this.customerRepository = CustomerRepository.getInstance();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerid){
        return customerRepository.getCustomer(customerid);
    }

    @GetMapping("/corporate")
    public List<Customer> getCorporateCustomers(){
        return customerRepository.getCustomers().stream().filter(customer->customer.isCorporate()).collect(Collectors.toList());
    }


    @GetMapping("/corporateNames")
    public List<String> getCorporateCustomersFirstNames(){
        return customerRepository.getCustomers().stream()
                .filter(Customer::isCorporate)
                .map(customer->{
                    String lastName = customer.getLastName();
                    if(lastName.equals("Fagerli")){
                        return "something";
                    }
                    return customer.getFirstName();
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/corporateNames")
    public String getCustomersFirstNamesReduced(){
        return customerRepository.getCustomers().stream()
                .map(Customer::getFirstName)
                .reduce("",(accumalator,firstName)-> accumalator+ " " + firstName.length());
    }

}
