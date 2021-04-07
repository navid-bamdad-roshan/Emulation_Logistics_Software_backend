package com.example.els.customer;


import com.example.els.address.AddressDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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


    @PostMapping("")
    public @ResponseBody String addCustomer(@RequestBody CustomerDto customerDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            Customer customer = customerService.addNewCustomer(customerDto);
            // return inserted customer id
            return (customer.getId().toString());
        }catch(Exception e){
            throw e;
        }
    }


    @PutMapping("/{id}")
    public @ResponseBody CustomerDto updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) throws Exception, JsonMappingException, JsonProcessingException{
        
        try{
            CustomerDto updatedCustomerDto = customerService.updateCustomer(id, customerDto);
            return (updatedCustomerDto);
        }catch(Exception e){
            throw e;
        }
    }



    @PostMapping("/{customerId}/address")
    public @ResponseBody AddressDto addNewAddress(@PathVariable("customerId") Long customerId, @RequestBody AddressDto addressDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            AddressDto createdAddressDto = customerService.addNewAddress(customerId, addressDto);
            return (createdAddressDto);
        }catch(Exception e){
            throw e;
        }
    }



    @PutMapping("/{customerId}/address/{addressId}")
    public @ResponseBody AddressDto updateAddress(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId, @RequestBody AddressDto addressDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            AddressDto updatedAddressDto = customerService.updateAddress(customerId, addressId, addressDto);
            return (updatedAddressDto);
        }catch(Exception e){
            throw e;
        }
    }



    @GetMapping("")
    public List<CustomerDto> getCustomers(){
        List<CustomerDto> customersDto = customerService.getAllCustomers();
        return customersDto;
    }



    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable("id") Long id) throws Exception{
        try{
            return customerService.getCustomerById(id);
        }catch(Exception e){
            throw e;
        }
        
    }



    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        boolean result = customerService.deleteCustomer(id);
        if (result == true){
            return "ok";
        }else{
            return "error";
        }
    }



    @DeleteMapping("/{customerId}/address/{addressId}")
    public String deleteAddress(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId){
        boolean result = customerService.deleteAddress(customerId, addressId);
        if (result == true){
            return "ok";
        }else{
            return "error";
        }
    }
}


