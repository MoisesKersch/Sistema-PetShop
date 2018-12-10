package com.petshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Home;
import com.petshop.services.HomeService;

@Controller
public class HomeController extends SessaoInfo
{ 
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/home",  method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("home");
		
		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");
		
		Home home = homeService.getHome(getUsuarioCorrente().getEmpresa());
		
		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
			modelAndView.addObject("nroClientes", home.getNroClientes());
			modelAndView.addObject("totalVendas", home.getTotalVendas());
			modelAndView.addObject("lucro", home.getLucro());
			modelAndView.addObject("dicas", homeService.getDicas(getUsuarioCorrente().getEmpresa()));
		} catch (Exception e) {
			
		}
		
		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
}
