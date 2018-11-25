package com.petshop.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Animal;
import com.petshop.models.OrdemServico;
import com.petshop.models.Usuario;
import com.petshop.repositories.ServicoRepository;
import com.petshop.services.OrdemServicoService;

@Controller
public class ServicoController extends SessaoInfo
{
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private OrdemServicoService ordemServicoService;

	@RequestMapping(value = "/servicos")
	public ModelAndView getServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("servicos");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");
		
		try
		{
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
		} catch (Exception e)
		{

		}
		
		modelAndView.addObject("page", "Serviços");
		modelAndView.addObject("mainTitle", "Serviços");
		modelAndView.addObject("secondTitle", "Serviços");
		modelAndView.addObject("caption", "Agende ou ou cancele serviços disponíveis na loja.");
		modelAndView.addObject("js", "servico.js");
		modelAndView.addObject("servicos", ordemServicoService.servicoCliente(getUsuarioCorrente()));
		return modelAndView;
	}

	@ResponseBody
 	@RequestMapping(value = "/getanimaisservico")
	public List<Animal> getCadastroAnimal()
	{
		try 
		{
			return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAnimais();
		} catch (Exception e) {
			return null;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/servicos", method = RequestMethod.POST)
	public OrdemServico postServicoPage(@Valid OrdemServico ordemServico, BindingResult bindingResult, Long servicoId, Long animalId, HttpServletRequest request,
			final RedirectAttributes redirectAttributes, HttpServletRequest response)
	{
		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}
	
		return ordemServicoService.salvar(ordemServico, animalId, servicoId, (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}
}
