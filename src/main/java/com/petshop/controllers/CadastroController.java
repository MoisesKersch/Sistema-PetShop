package com.petshop.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.component.SessaoInfo;
import com.petshop.models.Empresa;
import com.petshop.models.Role;
import com.petshop.models.Usuario;
import com.petshop.repositories.EmpresaRepository;
import com.petshop.repositories.UsuarioRepository;
import com.petshop.services.UsuarioService;

@Controller
public class CadastroController extends SessaoInfo
{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/cadastro")
	public ModelAndView getRegistroPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastro");
		
		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
		} catch (Exception e) {
			
		}
		
		modelAndView.addObject("page", "Home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
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
		
		// carrega empresa do petshop
		Optional<Empresa> empresaFinder =  empresaRepository.findById(1L);
		
		if (empresaFinder.isPresent())
		{
			Empresa empresa = empresaFinder.get();
			usuario.getEmpresas().add(empresa);
		}
		else
		{
			// falha no sistema empresa não configurada
			return null;
		}
		
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setRole("Cliente");
		roles.add(role);
		
		// selecion um papel
		usuario.setRoles(roles);
		
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
		return "redirect:cadastro";
	}
}
