package com.example.els.Customer;


import com.example.els.Address.Address;
import com.example.els.Address.AddressDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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


    // @Autowired
    // private CustomerRepository customerRepository;

    // @Autowired
    // private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;



    @PostMapping("")
    public @ResponseBody String addCustomer(@RequestBody CustomerDto customerDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            Customer customer = convertToEntity(customerDto);
            customer = customerService.addNewCustomer(customer);
            // return inserted customer id
            return (customer.getId().toString());
        }catch(Exception e){
            throw e;
        }
    }


    @PutMapping("/{id}")
    public @ResponseBody CustomerDto updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) throws Exception, JsonMappingException, JsonProcessingException{
        
        try{
            Customer customer = convertToEntity(customerDto);
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return (convertToDto(updatedCustomer));
        }catch(Exception e){
            throw e;
        }
    }



    @PostMapping("/{customerId}/address")
    public @ResponseBody AddressDto addNewAddress(@PathVariable("customerId") Long customerId, @RequestBody AddressDto addressDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            Address address = convertToEntity(addressDto);
            Address createdAddress = customerService.addNewAddress(customerId, address);
            return (convertToDto(createdAddress));
        }catch(Exception e){
            throw e;
        }
    }



    @PutMapping("/{customerId}/address/{addressId}")
    public @ResponseBody AddressDto updateAddress(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId, @RequestBody AddressDto addressDto) throws Exception, JsonMappingException, JsonProcessingException{
        try{
            Address address = convertToEntity(addressDto);
            Address updatedAddress = customerService.updateAddress(customerId, addressId, address);
            return (convertToDto(updatedAddress));
        }catch(Exception e){
            throw e;
        }
    }



    @GetMapping("")
    public List<CustomerDto> getCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return convertToDto(customers);
    }



    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable("id") Long id) throws Exception{
        Customer customer;
        try{
            customer = customerService.getCustomerById(id);
            return convertToDto(customer);
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



    private CustomerDto convertToDto(Customer customer){
        return (modelMapper.map(customer, CustomerDto.class));
    }

    private Customer convertToEntity(CustomerDto customerDto){
        return (modelMapper.map(customerDto, Customer.class));
    }

    private AddressDto convertToDto(Address address){
        return (modelMapper.map(address, AddressDto.class));
    }

    private Address convertToEntity(AddressDto addressDto){
        return (modelMapper.map(addressDto, Address.class));
    }

    private List<CustomerDto> convertToDto(List<Customer> customers){
        List<CustomerDto> customerDtos = customers.stream().map(customer -> convertToDto(customer)).collect(Collectors.toList());
        return (customerDtos);
    }

    // private List<Customer> convertToEntity(List<CustomerDto> customerDtos){
    //     List<Customer> customers = customerDtos.stream().map(customerDto -> convertToEntity(customerDto)).collect(Collectors.toList());
    //     return (customers);
    // }

    



}


