package com.example.els.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    
    public List<OrderDetailsDto> getAllOrderDetails(){
        return orderRepository.findAllOrderDetails();
    }

}
