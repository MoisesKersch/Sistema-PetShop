package com.petshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Users;
import com.petshop.services.UsersService;

@Controller
public class HomeController 
{
	@Autowired
	UsersService usersService;
	
	@RequestMapping(value = "/home/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users users = usersService.findUsersByEmail(auth.getName());
		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
}
