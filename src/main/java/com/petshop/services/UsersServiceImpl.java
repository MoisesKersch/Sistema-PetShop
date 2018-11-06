package com.petshop.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petshop.models.Role;
import com.petshop.models.Users;
import com.petshop.repositories.RoleRepository;
import com.petshop.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService
{
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Users findUsersByEmail(String email)
	{
		return usersRepository.findUsersByEmail(email);
	}

	@Override
	public void saveUsers(Users users)
	{
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setActive(1);
		Role role = roleRepository.findByRole("ADMIN");	
		users.setRoles(new HashSet<Role>(Arrays.asList(role)));
		
		usersRepository.save(users);
	}
}
