package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}