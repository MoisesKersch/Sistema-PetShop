package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}