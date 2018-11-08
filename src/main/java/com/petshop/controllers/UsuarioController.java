package com.petshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value = "registrar", method = RequestMethod.POST)
	public ModelAndView postRegistrar(@Valid Users usuario, BindingResult bindingResult)
	{
		ModelAndView modelAndView = new ModelAndView();
		Users usuarioExiste = usersService.findUsersByEmail(usuario.getEmail());

		usuario.setFirstname("firstname");
		usuario.setLastname("lastname");
		usuario.setActive(1);
		usuario.setPassword("orthonn123");

		if (usuarioExiste != null)
		{
			return null;
		}

		if (bindingResult.hasErrors())
		{
			modelAndView.setViewName("users/registrar");
		} else
		{
			usersService.saveUsers(usuario);
			modelAndView.addObject("msg", "Usuario cadastrado com sucesso!");
			modelAndView.addObject("users", new Users());
			modelAndView.setViewName("users/registrar");
		}
		return modelAndView;
	}

	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

}
