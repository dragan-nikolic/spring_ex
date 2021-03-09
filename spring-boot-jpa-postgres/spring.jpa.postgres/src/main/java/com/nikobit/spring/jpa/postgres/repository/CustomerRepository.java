package com.nikobit.spring.jpa.postgres.repository;

import com.nikobit.spring.jpa.postgres.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
