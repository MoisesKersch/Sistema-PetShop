//package com.petshop.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.petshop.models.Usuario;
//import com.petshop.services.SecurityService;
//import com.petshop.services.UserService;
//
//@Controller
//public class LoginController
//{
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private SecurityService securityService;
//
//	@RequestMapping(value = "/registration", method = RequestMethod.GET)
//	public String registration(Model model)
//	{
//		model.addAttribute("usuario", new Usuario());
//		return "registration";
//	}
//
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public String registration(@ModelAttribute("userForm") Usuario usuario, BindingResult bindingResult, Model model)
//	{
//
//		if (bindingResult.hasErrors())
//		{
//			return "registration";
//		}
//
//		userService.save(usuario);
//
//		securityService.autologin(usuario.getLogin(), usuario.getPasswordConfirm());
//
//		return "redirect:/home";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Model model, String error, String logout)
//	{
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (logout != null)
//			model.addAttribute("message", "You have been logged out successfully.");
//
//		return "login";
//	}
//
//	@RequestMapping(value =
//	{ "/", "/welcome" }, method = RequestMethod.GET)
//	public String welcome(Model model)
//	{
//		return "welcome";
//	}
//}