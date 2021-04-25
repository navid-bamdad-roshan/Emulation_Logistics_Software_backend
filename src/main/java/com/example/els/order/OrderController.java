package com.example.els.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/orders")
public class OrderController {
    

    @Autowired
    private OrderService orderService;


    @GetMapping("")
    public List<OrderDetailsDto> getOrders(){
        List<OrderDetailsDto> orderDetailsDto = orderService.getAllOrderDetails();
        return orderDetailsDto;
    }



}
