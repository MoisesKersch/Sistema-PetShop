package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>
{
	Users findByEmail(String email);
}
