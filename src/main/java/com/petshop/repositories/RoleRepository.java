package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Role;
import com.petshop.models.Users;

public interface RoleRepository extends JpaRepository<Role, Long>
{
	Role findByRole(String role);
}
