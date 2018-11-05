package com.petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petshop.models.Usuario;
import com.petshop.repositories.RoleRepository;
import com.petshop.repositories.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Usuario usuario)
	{
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuario.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(usuario);
	}

	@Override
	public Usuario findByLogin(String login)
	{
		return userRepository.findByLogin(login);
	}
}