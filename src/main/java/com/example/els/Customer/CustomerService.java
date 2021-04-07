package com.example.els.customer;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.els.address.Address;
import com.example.els.address.AddressDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Customer addNewCustomer(CustomerDto customerDto){
        Customer customer = modelMapper.map(customerDto, Customer.class);
        List <Address> addresses = customer.getAddresses();
        for (int i=0; i<addresses.size(); i++){
            addresses.get(i).setCustomer(customer);
        }
        customer.setAddresses(addresses);
        customerRepository.save(customer);
        return customer;
    }

    public CustomerDto getCustomerById(Long customerId) throws Exception{
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
        return modelMapper.map(customer, CustomerDto.class);
    }

    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customersDto = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return customersDto;
    }

    public CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto){
        Customer updatedCustomer = modelMapper.map(updatedCustomerDto, Customer.class);
        Customer customer = customerRepository.findById(id).get();
        if (customer.getFirstName() != updatedCustomer.getFirstName()){
            customer.setFirstName(updatedCustomer.getFirstName());
        }
        if (customer.getLastName() != updatedCustomer.getLastName()){
            customer.setLastName(updatedCustomer.getLastName());
        }
        if (customer.getEmail() != updatedCustomer.getEmail()){
            customer.setEmail(updatedCustomer.getEmail());
        }
        if (customer.getPhone() != updatedCustomer.getPhone()){
            customer.setPhone(updatedCustomer.getPhone());
        }
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }


    public AddressDto updateAddress(Long customerId, Long addressId, AddressDto updatedAddressDto) throws Exception{

        Address updatedAddress = modelMapper.map(updatedAddressDto, Address.class);
        Customer customer = customerRepository.findById(customerId).get();

        List<Address> addresses = customer.getAddresses();

        Address address;

        for (int i=0; i<addresses.size(); i++){
            if (addresses.get(i).getId() == addressId){
                address = addresses.get(i);
                if (address.getCountry() != updatedAddress.getCountry()){
                    address.setCountry(updatedAddress.getCountry());
                }
                if (address.getCity() != updatedAddress.getCity()){
                    address.setCity(updatedAddress.getCity());
                }
                if (address.getState() != updatedAddress.getState()){
                    address.setState(updatedAddress.getState());
                }
                if (address.getPostalCode() != updatedAddress.getPostalCode()){
                    address.setPostalCode(updatedAddress.getPostalCode());
                }
                if (address.getAddress() != updatedAddress.getAddress()){
                    address.setAddress(updatedAddress.getAddress());
                }
                customerRepository.save(customer);
                return modelMapper.map(address, AddressDto.class);
            }
        }
        throw new Exception("such address does not exist!");
    }


    public AddressDto addNewAddress(Long customerId, AddressDto newAddressDto) throws Exception{
        try{
            Address newAddress = modelMapper.map(newAddressDto, Address.class);
            Customer customer = customerRepository.findById(customerId).get();

            List<Address> addresses = customer.getAddresses();
            newAddress.setCustomer(customer);
            addresses.add(newAddress);

            customer.setAddresses(addresses);
            
            customerRepository.save(customer);

            addresses = customer.getAddresses();
            return modelMapper.map(addresses.get(addresses.size()-1), AddressDto.class);
        }catch(Exception e){
            throw e;
        }
        
    }


    public boolean deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
        if (customerRepository.findById(customerId).isPresent()){
            return false;
        }else{
            return true;
        }
    }


    public boolean deleteAddress(Long customerId, Long addressId){

        try{
            Customer customer = customerRepository.findById(customerId).get();
            List<Address> addresses = customer.getAddresses();
            for (int i=0; i<addresses.size(); i++){
                if (addresses.get(i).getId() == addressId){
                    addresses.remove(i);
                }
            }
            customer.setAddresses(addresses);
            customerRepository.save(customer);

            customer = customerRepository.findById(customerId).get();
            addresses = customer.getAddresses();
            for (int i=0; i<addresses.size(); i++){
                if (addresses.get(i).getId() == addressId){
                    return false;
                }
            }
            return true;

        }catch(Exception e){
            return false;
        }
    }
}
