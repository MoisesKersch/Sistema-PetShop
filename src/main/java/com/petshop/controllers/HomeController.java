package com.petshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Usuario;

@Controller
public class HomeController
{
	
	@RequestMapping(value = "/home",  method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("home");
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		if (usuario.getLogin() == null)
//		{
//			SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
//		}
//	
		
		
		try {
			modelAndView.addObject("papel", usuario.getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", usuario.getNome());
		} catch (Exception e) {
			
		}
		
		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/test",  method = RequestMethod.GET)
	public String adminTeste(HttpServletRequest request, HttpServletResponse response)
	{
		return "it worked?";
	}
}
