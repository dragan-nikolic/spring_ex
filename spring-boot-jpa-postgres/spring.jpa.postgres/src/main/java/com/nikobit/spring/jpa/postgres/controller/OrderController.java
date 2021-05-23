package com.nikobit.spring.jpa.postgres.controller;

import com.nikobit.spring.jpa.postgres.model.*;
import com.nikobit.spring.jpa.postgres.repository.OrderRepository;
import com.nikobit.spring.jpa.postgres.repository.ProductRepository;
import com.nikobit.spring.jpa.postgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    /**
     *
     * @param requestBody
     *              {
     *                  "userEmail": String,
     *                  "itemOrdinal": Integer,
     *                  "itemProductId": Long,
     *                  "itemQuantity": Integer
     *                  }
     *              }
     * @return Order
     */
    @PostMapping("")
    public ResponseEntity<Order> addItemToCart(@RequestBody Map<String, Object> requestBody) {
        String userEmail = (String)requestBody.get("userEmail");
        Optional<Product> optionalProduct = productRepository.findById((Long)requestBody.get("itemProductId"));
        Product product = optionalProduct.get();
        Integer itemOrdinal = (Integer)requestBody.get("itemOrdinal");
        Integer itemQuantity = (Integer)requestBody.get("itemQuantity");
        LineItem lineItem = new LineItem(itemOrdinal, product, itemQuantity);

        try {
            User user = userRepository.findByEmail(userEmail);

            Order cart = findCartByUser(user);

            if (cart == null) {
                cart = new Order(user, System.currentTimeMillis());
            }

            cart.add(lineItem);
            Order _cart = orderRepository.save(cart);
            return new ResponseEntity<>(_cart, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Order findCartByUser(User user) {
        List<Order> userOrders = orderRepository.findByUser(user);

        for (Order order: userOrders) {
            if (order.getState() == OrderState.CART) {
                return order;
            }
        }

        return null;
    }
}
