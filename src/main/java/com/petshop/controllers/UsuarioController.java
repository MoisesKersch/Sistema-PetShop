package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Users;
import com.petshop.repositories.UsersRepository;
import com.petshop.services.UsersService;

@Controller
public class UsuarioController
{
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value = "registrar", method = RequestMethod.GET)
	public ModelAndView getRegistrar()
	{
		ModelAndView modelAndView = new ModelAndView("registrar");
		Users users = new Users();
		
		if (usersRepository.findUsersByEmail("lightspeedoff@gmail.com") == null)
		{
			users.setActive(1);
			users.setEmail("lightspeedoff@gmail.com");
			users.setFirstname("Moises");
			users.setLastname("Kerschner");
			users.setPassword("orthonn123");
			usersService.saveUsers(users);
		}
		
		modelAndView.addObject("users", users);
		return modelAndView;
	}
}
