// package com.example.els;

// import java.lang.reflect.Array;
// import java.util.Arrays;
// import java.util.List;

// import com.example.els.address.Address;
// import com.example.els.address.AddressRepository;
// import com.example.els.customer.Customer;
// import com.example.els.customer.CustomerRepository;
// import com.example.els.customer.CustomerService;
// import com.example.els.order.Order;
// import com.example.els.order.OrderDetailsDto;
// import com.example.els.order.OrderRepository;
// import com.example.els.order.OrderService;
// import com.example.els.shipment.Shipment;
// import com.example.els.shipment.ShipmentRepository;
// import com.example.els.shipmentpackage.Package;
// import com.example.els.shipmentpackage.PackageRepository;
// import com.example.els.user.*;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// import javax.persistence.EntityManager;
// import javax.transaction.Transactional;

// @Component
// @Transactional
// public class CustomerRepositoryCommandLineRunner implements CommandLineRunner {

//     private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryCommandLineRunner.class);

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Autowired
//     private CustomerService customerService;

//     @Autowired
//     private AddressRepository addressRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private OrderRepository orderRepository;

//     @Autowired
//     private OrderService orderService;

//     @Autowired
//     private ShipmentRepository shipmentRepository;

//     @Autowired
//     private PackageRepository packageRepository;

//     @Autowired
//     private UserService userService;


//     @Override
//     public void run(String... args) throws Exception {

//         // Customer sender = customerRepository.findById(30L).get();


//         // Customer receiver = customerRepository.findById(1L).get();



//         // log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         // log.info(receiver.getFirstName());
//         // log.info(receiver.getAddresses().get(0).getCity());

//         // List<OrderDetailsDto> orderDetailsDtos = orderRepository.findAllOrderDetails();
//         // log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         // log.info(orderDetailsDtos.get(0).getReceiverFirstName());
//         // log.info(orderDetailsDtos.get(0).getSenderFirstName());
//         // log.info("package count: "+orderDetailsDtos.get(0).getPackageCount().toString());
//         // log.info("shipment count: "+orderDetailsDtos.get(0).getShipmentsCount().toString());

//         List<OrderDetailsDto> orderDetailsDtos = orderService.getAllOrderDetails();
//         log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         log.info(orderDetailsDtos.get(0).getReceiverFirstName());
//         log.info(orderDetailsDtos.get(0).getSenderFirstName());
//         log.info("package count: "+orderDetailsDtos.get(0).getPackageCount().toString());
//         log.info("shipment count: "+orderDetailsDtos.get(0).getShipmentsCount().toString());
//         log.info("all count: "+orderDetailsDtos.size());


//         log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         log.info(orderDetailsDtos.get(1).getReceiverFirstName());
//         log.info(orderDetailsDtos.get(1).getSenderFirstName());
//         log.info("package count: "+orderDetailsDtos.get(1).getPackageCount().toString());
//         log.info("shipment count: "+orderDetailsDtos.get(1).getShipmentsCount().toString());
//         log.info("all count: "+orderDetailsDtos.size());


//         log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         log.info(orderDetailsDtos.get(2).getReceiverFirstName());
//         log.info(orderDetailsDtos.get(2).getSenderFirstName());
//         log.info("package count: "+orderDetailsDtos.get(2).getPackageCount().toString());
//         log.info("shipment count: "+orderDetailsDtos.get(2).getShipmentsCount().toString());
//         log.info("all count: "+orderDetailsDtos.size());


//         log.info("LLLLLLLOOOOOOAAAAAADDDDDDEEEEEEDDDDDD");
//         log.info(orderDetailsDtos.get(3).getReceiverFirstName());
//         log.info(orderDetailsDtos.get(3).getSenderFirstName());
//         log.info("package count: "+orderDetailsDtos.get(3).getPackageCount().toString());
//         log.info("shipment count: "+orderDetailsDtos.get(3).getShipmentsCount().toString());
//         log.info("all count: "+orderDetailsDtos.size());



//         // Package p1 = new Package(null, 45D, 20D, 10D, 70D, "fragile", null);
//         // Package p2 = new Package(null, 100D, 50D, 40D, 150D, "no tag", null);
//         // Package p3 = new Package(null, 65D, 20D, 10D, 90D, "fragile", null);
//         // Package p4 = new Package(null, 10D, 10D, 10D, 20D, "no tag", null);

//         // Package p5 = new Package(null, 50D, 20D, 10D, 70D, "no tag", null);
//         // Package p6 = new Package(null, 150D, 70D, 40D, 250D, "no tag", null);
//         // Package p7 = new Package(null, 165D, 20D, 10D, 390D, "no tag", null);
//         // Package p8 = new Package(null, 50D, 50D, 10D, 70D, "no tag", null);

//         // Package p9 = new Package(null, 500D, 200D, 100D, 1000D, "no tag", null);
//         // Package p10 = new Package(null, 500D, 300D, 100D, 1300D, "no tag", null);


//         // Shipment sh1 = new Shipment(Arrays.asList() ,null);
//         // Shipment sh2 = new Shipment(Arrays.asList() ,null);
//         // Shipment sh3 = new Shipment(Arrays.asList() ,null);


        
//         // Customer sender = customerRepository.findById(5L).get();
//         // Customer receiver = customerRepository.findById(6L).get();
//         // Order o1 = new Order(sender, receiver, "Description one", Arrays.asList(p9, p10), Arrays.asList(sh2, sh3));
//         // p9.setOrder(o1);
//         // p10.setOrder(o1);
//         // sh2.setOrders(Arrays.asList(o1));
//         // sh3.setOrders(Arrays.asList(o1));
//         // packageRepository.save(p9);
//         // packageRepository.save(p10);
//         // //shipmentRepository.save(sh2);
//         // shipmentRepository.save(sh3);
//         // orderRepository.save(o1);


//         // Customer sender2 = customerRepository.findById(44L).get();
//         // Customer receiver2 = customerRepository.findById(46L).get();
//         // Order o2 = new Order(sender2, receiver2, "Description two", Arrays.asList(p1, p2, p3, p4, p5), Arrays.asList(sh1));
//         // p1.setOrder(o2);
//         // p2.setOrder(o2);
//         // p3.setOrder(o2);
//         // p4.setOrder(o2);
//         // p5.setOrder(o2);
//         // sh1.setOrders(Arrays.asList(o2));
//         // packageRepository.save(p1);
//         // packageRepository.save(p2);
//         // packageRepository.save(p3);
//         // packageRepository.save(p4);
//         // packageRepository.save(p5);
//         // // shipmentRepository.save(sh1);
//         // orderRepository.save(o2);



//         // Customer sender3 = customerRepository.findById(35L).get();
//         // Customer receiver3 = customerRepository.findById(48L).get();
//         // Order o3 = new Order(sender3, receiver3, "Description two", Arrays.asList(p6, p7, p8), Arrays.asList(sh1, sh2));
//         // p6.setOrder(o3);
//         // p7.setOrder(o3);
//         // p8.setOrder(o3);
//         // sh1.setOrders(Arrays.asList(o2, o3));
//         // sh2.setOrders(Arrays.asList(o1, o3));
//         // packageRepository.save(p6);
//         // packageRepository.save(p7);
//         // packageRepository.save(p8);
//         // shipmentRepository.save(sh1);
//         // shipmentRepository.save(sh2);
//         // orderRepository.save(o3);














//         List<Shipment> shipments = Arrays.asList();
//         //Order o = new Order(sender, receiver, "lllkkk", Arrays.asList(), shipments);

//         // Package p = packageRepository.findById(56L).get();
//         // Order o = orderRepository.findById(57L).get();
//         // p.setOrder(o);


//         //p.setOrder(o);
//         //packageRepository.save(p);
//         //orderRepository.save(o);

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
