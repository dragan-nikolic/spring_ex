package com.nikobit.spring.jpa.postgres.controller;

import com.nikobit.spring.jpa.postgres.model.Order;
import com.nikobit.spring.jpa.postgres.model.User;
import com.nikobit.spring.jpa.postgres.repository.OrderRepository;
import com.nikobit.spring.jpa.postgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestBody String userEmail) {
        try {
            User user = userRepository.findByEmail(userEmail);
            Order order = new Order(user, System.currentTimeMillis());
            //TODO: find cart by user and add all line items to order
            
            Order _order = orderRepository.save(order);
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
