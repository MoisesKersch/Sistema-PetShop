package com.petshop.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.petshop.models.Empresa;
import com.petshop.models.Endereco;
import com.petshop.models.Role;
import com.petshop.models.Usuario;
import com.petshop.repositories.EmpresaRepository;
import com.petshop.repositories.UsuarioRepository;

@Controller
public class CadastroController extends SessaoInfo
{
	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/cadastro")
	public ModelAndView getRegistroPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastro");

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

		modelAndView.addObject("page", "Home");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/getcadastro")
	public List<Usuario> getCadastro()
	{
		try 
		{
			return usuarioRepository.findByEmpresaIdRoleAdminNot(1L);
		} catch (Exception e) {
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public Usuario postRegistroPage(@Valid Usuario usuario, BindingResult bindingResult, HttpServletRequest request,
			final RedirectAttributes redirectAttributes, String bairro, String uf, String complemento, String cidade)
	{
		
		if (bindingResult.hasErrors()) {
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}

		// carrega empresa do petshop
		Optional<Empresa> empresaFinder = empresaRepository.findById(1L);

		if (empresaFinder.isPresent()) {
			Empresa empresa = empresaFinder.get();
			usuario.getEmpresas().add(empresa);
		} else {
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
		try {
			Endereco endereco = new Endereco();
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setComplemento(complemento);
			endereco.setUf(uf);
			usuario.getEnderecos().add(endereco);
			
			usuario = usuarioRepository.save(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removercadastro", method = RequestMethod.POST)
	public Usuario removerUsuario(Long id)
	{
		try 
		{
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}
