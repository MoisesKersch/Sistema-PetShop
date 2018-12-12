package com.petshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Suporte;
import com.petshop.repositories.SuporteRepository;

@Controller
public class SuporteController extends SessaoInfo
{
	@Autowired
	SuporteRepository suporteRepository;
	
	@RequestMapping(value = "/suporte"	)
	public ModelAndView suporte()
	{
		ModelAndView modelAndView = new ModelAndView("suporte");
		
		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");
			
		modelAndView.addObject("page", "Suporte");
		modelAndView.addObject("mainTitle", "Suporte");
		modelAndView.addObject("secondTitle", "Serviços");
		modelAndView.addObject("caption", "Está com alguma problema? Não hesite em enviar para nós uma mensagem.");
		
		modelAndView.addObject("formId", "suporte-form");
		modelAndView.addObject("js", "suporte.js");

		
		modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
		modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/suporte", method = RequestMethod.POST)
	public Suporte suportePost(@Valid Suporte suporte, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return null;
		}
		try {
			suporte.setEmpresa(getUsuarioCorrente().getEmpresa());
			return suporteRepository.save(suporte);
		} catch (Exception e) {
			return null;
		}
	}
}
