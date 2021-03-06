package com.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Dica;
import com.petshop.repositories.DicaRepository;

@Controller
public class DicaController extends SessaoInfo
{ 

	@Autowired
	private DicaRepository dicaRepository;
	
	@RequestMapping(value = "/dica",  method = RequestMethod.GET)
	public ModelAndView dica(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView("dica");
		
		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");
		
		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e) {

		}
		
		modelAndView.addObject("page", "Cadastro Dicas");
		modelAndView.addObject("mainTitle", "Cadastro Dicas");
		modelAndView.addObject("secondTitle", "Cadastro Dicas");
		modelAndView.addObject("caption", "Cadastro Dicas");
		modelAndView.addObject("js", "dica.js");
		modelAndView.addObject("jsEditor", "dica-editor.js");
		modelAndView.addObject("tableId", "dica-table");
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "getdicas")
	public List<Dica> getDicas()
	{
		try {
			return dicaRepository.findByEmpresa(getUsuarioCorrente().getEmpresa());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@ResponseBody
	@RequestMapping(value = "/dica", method = RequestMethod.POST)
	public Dica postCadastroAnimalPage(@Valid Dica dica, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes)
	{
		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}
		
		try
		{
			dica.setEmpresa(getUsuarioCorrente().getEmpresa());
			dica = dicaRepository.save(dica);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		return dica;
	}

	@ResponseBody
	@RequestMapping(value = "/dicaremove", method = RequestMethod.POST)
	public Boolean removerDica(Long id)
	{
		try 
		{
			dicaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
