package com.nikobit.spring.jpa.postgres.repository;

import com.nikobit.spring.jpa.postgres.model.Order;
import com.nikobit.spring.jpa.postgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
