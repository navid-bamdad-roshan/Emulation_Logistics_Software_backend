package com.example.els.Customer;


import com.example.els.Address.Address;
import com.example.els.Address.AddressRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    // @PutMapping("/add-customer")
    // public void addCustomer(){

    // }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("")
    public @ResponseBody String addCustomer(@RequestBody String jsonCustomer) throws Exception, JsonMappingException, JsonProcessingException{
        
        System.out.println(jsonCustomer.toString());
        
        try{
            Customer customer = objectMapper.readValue(jsonCustomer, Customer.class);
            List <Address> addresses = customer.getAddresses();
            for (int i=0; i<addresses.size(); i++){
                addresses.get(i).setCustomer(customer);
            }
            customer.setAddresses(addresses);
            //System.out.println(customer.toString());
            customer = customerService.addNewCustomer(customer);
            // return inserted customer id
            return (customer.getId().toString());
        //}catch(JsonMappingException e){
        //    throw e;
            //return "-1";
        //}catch(JsonProcessingException e){
        //    throw e;
            //return "-1";
        }catch(Exception e){
            throw e;
            //return "-1";
        }
    }

    // {
    //     "firstName": "Navid",
    //      "lastName": "Bamdad Roshan",
    //          "email": "nbamdadroshan@yahoo.com",
    //          "phone": "963852741",
    //      "addresses": [
    //          {
    //            "country": "Estonia",
    //            "state": "Tartumaa",
    //            "city": "Tartu",
    //            "postalCode": "123456",
    //            "address": "lkkjhgffdsa"
    //          },
    //          {
    //            "country": "New",
    //            "state": "Harjumaa",
    //            "city": "Tallinn",
    //            "postalCode": "123456",
    //            "address": "lkkjhgffdsa"
    //          },
    //          {
    //            "country": "New",
    //            "state": "CreateNewDoc",
    //            "city": "Tartu",
    //            "postalCode": "123456",
    //            "address": "lkkjhgffdsa"
    //          }
    //        ]
    //  }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public String getCustomer(){
        List<Customer> customers = customerService.getAllCustomers();
        return customers.toString();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    // @GetMapping("/update/{id}")
    // public String getCustomerUpdate(@PathVariable("id") Long id){
        
    //     Customer customer = customerRepository.findById(id).get();

    //     Address address = new Address("Estonia", "Tartumaa", "Tartu", "987654", "fdsasdg", customer);


    //     customer.getAddresses().add(address);
    //     customerRepository.save(customer);
    //     //addressRepository.save(address);
    //     System.out.println("New customer is updated "+ customer);
    //     return customer.toString();
        
    //     //return ("customer "+id.toString()+" from spring");
    // }


    // @CrossOrigin(origins = "http://localhost:3000")
    // @GetMapping("/address/{id}")
    // public String getAddress(@PathVariable("id") Long id){

    //     Address address = addressRepository.findById(id).get();

    //     address.setAddress("A good address");
    //     addressRepository.save(address);

    //     //addressRepository.save(address);
    //     System.out.println("New customer is updated "+ address);
    //     return address.toString();
        
    //     //return ("customer "+id.toString()+" from spring");
    // }


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
