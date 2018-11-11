package com.petshop.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.models.Usuario;
import com.petshop.repositories.UsuarioRepository;
import com.petshop.services.UsuarioService;

@Controller
public class RegistroController
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/registro")
	public ModelAndView getRegistroPage()
	{
		ModelAndView modelAndView = new ModelAndView("registro");
		Usuario usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String postRegistroPage(@Valid Usuario usuario, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes)
	{
		if (bindingResult.hasErrors())
		{
			// tratar com uma growl mensagem? 
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return "redirect:registro";
		}

		// confere se o usuario existe
		Optional<Usuario> usuarioExiste = usuarioRepository.findByLogin(usuario.getLogin());
		
		if (usuarioExiste.isPresent())
		{
			redirectAttributes.addFlashAttribute("mensagemErro", "Login existente!");
			return "redirect:registro";
		}
		
		// salva o usuario
		try
		{
			usuarioRepository.save(usuario);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		// logar apos o registro
		usuarioService.logarAposRegistro(request, usuario.getLogin(), usuario.getSenha());
		return "redirect:home";
	}
}
