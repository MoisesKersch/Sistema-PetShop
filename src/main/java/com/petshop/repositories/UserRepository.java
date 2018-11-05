package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}