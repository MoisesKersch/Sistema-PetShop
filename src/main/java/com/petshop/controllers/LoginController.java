package com.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{
	@RequestMapping(value = {"/login", "/", "public/login"})
	public String getLoginPage(RedirectAttributes redirectAttributes)
	{
		return "login";
	}
}