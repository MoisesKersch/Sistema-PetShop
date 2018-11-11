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

import com.petshop.models.Usuario;
import com.petshop.services.UsuarioDetailsServiceImpl;

@Controller
public class HomeController 
{
	@Autowired
	UsuarioDetailsServiceImpl usuarioDetailsServiceImpl;
	
	@RequestMapping(value = "/home",  method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = (Usuario) usuarioDetailsServiceImpl.loadUserByUsername(auth.getName());
		
		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
}
