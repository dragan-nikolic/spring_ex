package com.nikobit.spring.jpa.postgres.repository;

import com.nikobit.spring.jpa.postgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}