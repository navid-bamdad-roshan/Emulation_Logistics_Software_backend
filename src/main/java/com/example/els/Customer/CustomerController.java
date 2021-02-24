package com.example.els.Customer;


import com.example.els.Address.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    // @Autowired
    // private CustomerRepository customerRepository;

    // @Autowired
    // private AddressRepository addressRepository;

    ObjectMapper objectMapper = new ObjectMapper();


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("")
    public @ResponseBody String addCustomer(@RequestBody String jsonCustomer) throws Exception, JsonMappingException, JsonProcessingException{
        
        System.out.println(jsonCustomer.toString());
        
        try{
            Customer customer = objectMapper.readValue(jsonCustomer, Customer.class);
            List <Address> addresses = customer.getAddresses();
            for (int i=0; i<addresses.size(); i++){
                addresses.get(i).setCustomer(customer);
            }
            customer.setAddresses(addresses);
            customer = customerService.addNewCustomer(customer);
            // return inserted customer id
            return (customer.getId().toString());
        }catch(Exception e){
            throw e;
            //return "-1";
        }
    }





    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public @ResponseBody String updateCustomer(@PathVariable("id") Long id, @RequestBody String jsonCustomer) throws Exception, JsonMappingException, JsonProcessingException{
        
        try{
            Customer customer = objectMapper.readValue(jsonCustomer, Customer.class);
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return (updatedCustomer.toString());
        }catch(Exception e){
            return "-1";
        }
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{customerId}/address")
    public @ResponseBody String addNewAddress(@PathVariable("customerId") Long customerId, @RequestBody String jsonAddress) throws Exception, JsonMappingException, JsonProcessingException{
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        try{
            Address address = objectMapper.readValue(jsonAddress, Address.class);
            Address createdAddress = customerService.addNewAddress(customerId, address);
            return (createdAddress.toString());
        }catch(Exception e){
            return "-1";
        }
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{customerId}/address/{addressId}")
    public @ResponseBody String updateAddress(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId, @RequestBody String jsonAddress) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            Address address = objectMapper.readValue(jsonAddress, Address.class);
            Address updatedAddress = customerService.updateAddress(customerId, addressId, address);
            return (updatedAddress.toString());
        }catch(Exception e){
            return "-1";
        }
    }




    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public String getCustomer(){
        List<Customer> customers = customerService.getAllCustomers();
        return customers.toString();
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public String getCustomerOne(@PathVariable("id") Long id){
        Customer customer;
        try{
            customer = customerService.getCustomerById(id);
        }catch(Exception e){
            return e.getMessage().toString();
        }
        return customer.toString();
    }
}
