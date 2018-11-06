package com.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Users;

@Controller
public class UsuarioController
{
	@RequestMapping(value = "registrar", method = RequestMethod.GET)
	public ModelAndView getRegistrar()
	{
		ModelAndView modelAndView = new ModelAndView("registrar");
		Users users = new Users();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
}
