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
import com.petshop.models.Servico;
import com.petshop.models.Usuario;
import com.petshop.repositories.ServicoRepository;

@Controller
public class CadastroServicoController extends SessaoInfo
{
	@Autowired
	private ServicoRepository servicoRepository;

	@RequestMapping(value = "/cadastroservico")
	public ModelAndView getCadastroServicoPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastroservico");

		Usuario usuario = null;

		try {
			usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
		}

		if (usuario.getLogin() == null) {
			SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
			return null;
		}

		try {
			modelAndView.addObject("papel", usuario.getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", usuario.getNome());
		} catch (Exception e) {

		}

		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getservicos")
	public List<Servico> getCadastroServico()
	{
		try 
		{
			return servicoRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/cadastroservico", method = RequestMethod.POST)
	public Servico postCadastroServico(@Valid Servico servico, BindingResult bindingResult, HttpServletRequest request,
			final RedirectAttributes redirectAttributes)
	{
		
		if (bindingResult.hasErrors()) {
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}

		try {
		
			servico = servicoRepository.save(servico);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return servico;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removerservico", method = RequestMethod.POST)
	public Usuario removerUsuario(Long id)
	{
//		try 
//		{
//			usuarioRepository.deleteById(id);
//		} catch (Exception e) {
//			return null;
//		}
		return null;
	}
}
