package com.example.els;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.example.els.Customer.Address;
import com.example.els.Customer.AddressRepository;
import com.example.els.Customer.Customer;
import com.example.els.Customer.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.persistence.EntityManager;

@Component
public class CustomerRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryCommandLineRunner.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;



    @Override
    public void run(String... args) throws Exception {


        // Customer customer = new Customer("navid", "bamdad roshan", "nbamdadroshan@yahoo.com", "+95874663", Arrays.asList());
        // customerRepository.save(customer);
        // log.info("New customer is created "+ customer);

        // Customer customer = new Customer("navid2", "bamdad roshan2", "nbamdadroshan@yahoo.com2", "+958746632", Arrays.asList());
        // Address address = new Address("Estonia", "Tartumaa", "Tartu", "12345", "asdfghjkl", customer);
        // customer.setAddresses(Arrays.asList(address));
        // // addressRepository.save(address);
        // customerRepository.save(customer);
        
        
        // log.info("New customer is created "+ customer);


        //Optional<Customer> customer2 = customerRepository.findById(1L);

        //log.info("List customers: " + customer2);
    
    }

    
}
