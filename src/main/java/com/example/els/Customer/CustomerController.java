package com.example.els.Customer;

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

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    // @Autowired
    // private CustomerService customerService;


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    // @PutMapping("/add-customer")
    // public void addCustomer(){

    // }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("")
    public @ResponseBody String addCustomer(@RequestBody Customer s){
        System.out.println(s);

        Long insertedCustomerId = 400L;
        // return inserted customer id
        return (insertedCustomerId.toString());
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
    public String getCustomer(@RequestParam(defaultValue = "all") String id){
        
        Customer customer = new Customer("navid", "bamdad roshan", "nbamdadroshan@yahoo.com", "+95874663", List.of());

        Address address = new Address("Estonia", "Tartumaa", "Tartu", "987654", "fdsasdg", customer);

        customer.setAddresses(List.of(address,  new Address("Estonia", "Tartumaa", "Tartu", "987654", "fdsasdg", customer)));
        customerRepository.save(customer);
        //addressRepository.save(address);
        System.out.println("New customer is created "+ customer);
        return customer.toString();
        
        //return ("customer "+id.toString()+" from spring");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/update/{id}")
    public String getCustomerUpdate(@PathVariable("id") Long id){
        
        Customer customer = customerRepository.findById(id).get();

        Address address = new Address("Estonia", "Tartumaa", "Tartu", "987654", "fdsasdg", customer);


        customer.getAddresses().add(address);
        customerRepository.save(customer);
        //addressRepository.save(address);
        System.out.println("New customer is updated "+ customer);
        return customer.toString();
        
        //return ("customer "+id.toString()+" from spring");
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/address/{id}")
    public String getAddress(@PathVariable("id") Long id){

        Address address = addressRepository.findById(id).get();

        address.setAddress("A good address");
        addressRepository.save(address);

        //addressRepository.save(address);
        System.out.println("New customer is updated "+ address);
        return address.toString();
        
        //return ("customer "+id.toString()+" from spring");
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public String getCustomerOne(@PathVariable("id") Long id){
        //Customer customer = new Customer("navid", "bamdad roshan", "nbamdadroshan@yahoo.com", "+95874663", List.of());
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println("Customer is retrieved "+ customer);
        return customer.toString();
        // return new Customer(id, "navid", "bamdadroshan", "nbamdadroshan@yahoo.com", "123456789", List.of()).toString();
    }
}
