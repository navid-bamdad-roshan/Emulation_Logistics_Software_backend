package com.example.els.Customer;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer addNewCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public Customer getCustomerById(Long customerId) throws Exception{
        Optional<Customer> opCustomer = customerRepository.findById(customerId);
        Customer customer;
        try {
            if (opCustomer.isEmpty())
                throw new Exception("customerNotFound");
            customer = opCustomer.get();
        }
        catch(Exception e) {
            throw e;
        }
        return customer;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll(); 
        return customers;
    }
}
