package com.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.services.MessageService;

@Controller
public class MessageController 
{
	private final MessageService messageService;
	
	public MessageController(MessageService messageService)
	{
		this.messageService = messageService;
	}

	@RequestMapping({"/", ""})
	public ModelAndView getMessage(ModelAndView modelAndView)
	{
		modelAndView = new ModelAndView("message");
		modelAndView.addObject("message", messageService.getMessage().get(0).getMessage());
		return modelAndView;
	}
	
	@RequestMapping("foo2")
	public String getMessage()
	{
		return "index";
	}
}
