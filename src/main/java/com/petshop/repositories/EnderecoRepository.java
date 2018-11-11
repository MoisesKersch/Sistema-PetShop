package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Role;

public interface EnderecoRepository extends JpaRepository<Role, Long>
{
	
}
