package com.petshop.services;

import com.petshop.models.Usuario;

// Prove um serviço para registrar uma conta
public interface UserService
{
	public void save(Usuario user);
	public Usuario findByLogin(String login);
}
