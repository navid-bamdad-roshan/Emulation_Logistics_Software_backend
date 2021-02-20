package com.example.els.Customer;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.els.Address.Address;

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

    public Customer updateCustomer(Long id, Customer updatedCustomer){
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
        return customer;
    }


    public Address updateAddress(Long customerId, Long addressId, Address updatedAddress) throws Exception{
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
                return address;
            }
        }
        throw new Exception("such address does not exist!");
    }
}
