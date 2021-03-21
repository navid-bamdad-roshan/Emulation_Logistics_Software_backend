// package com.example.els;

// import java.lang.reflect.Array;
// import java.util.Arrays;
// import java.util.List;

// import com.example.els.Address.Address;
// import com.example.els.Address.AddressRepository;
// import com.example.els.Customer.Customer;
// import com.example.els.Customer.CustomerRepository;

// import com.example.els.User.*;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// import javax.persistence.EntityManager;

// @Component
// public class CustomerRepositoryCommandLineRunner implements CommandLineRunner {

//     private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryCommandLineRunner.class);

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Autowired
//     private AddressRepository addressRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private UserService userService;



//     @Override
//     public void run(String... args) throws Exception {

//         // User newUser = new User("employee", "one", "employeeOne", "employeeOne", "963852741", "employee1@els.com", "employee");
//         // log.info("New user is created "+newUser);
//         // userRepository.save(newUser);
//         // userService.addNewUser(newUser);

//         // log.info(userRepository.findAll().get(0).toString());


//         // newUser = new User("employee", "two", "employeeTwo", "employeeTwo", "963852741", "employee2@els.com", "employee");
//         // userService.addNewUser(newUser);

//         // newUser = new User("manager", "one", "managerOne", "managerOne", "963852741", "manager1@els.com", "manager");
//         // userService.addNewUser(newUser);


//         // Customer customer = new Customer("navid", "bamdad roshan", "nbamdadroshan@yahoo.com", "+95874663", Arrays.asList());
//         // customerRepository.save(customer);
//         // log.info("New customer is created "+ customer);

//         // Customer customer = new Customer("navid2", "bamdad roshan2", "nbamdadroshan@yahoo.com2", "+958746632", Arrays.asList());
//         // Address address = new Address("Estonia", "Tartumaa", "Tartu", "12345", "asdfghjkl", customer);
//         // customer.setAddresses(Arrays.asList(address));
//         // // addressRepository.save(address);
//         // customerRepository.save(customer);
        
        
//         // log.info("New customer is created "+ customer);


//         //Optional<Customer> customer2 = customerRepository.findById(1L);

//         //log.info("List customers: " + customer2);
    
//     }

    
// }
