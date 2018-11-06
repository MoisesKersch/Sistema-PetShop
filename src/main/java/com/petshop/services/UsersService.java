package com.petshop.services;

import com.petshop.models.Users;

public interface UsersService
{
	public Users findUsersByEmail(String email);
	public void saveUsers(Users users);
}
