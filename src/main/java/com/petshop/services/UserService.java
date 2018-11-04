package com.petshop.services;

import com.petshop.models.User;

// Prove um serviço para registrar uma conta
public interface UserService
{
	public void save(User user);
	public User findByUsername(String username);
}
