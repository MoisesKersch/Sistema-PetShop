package com.petshop.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import com.petshop.models.Endereco;
import com.petshop.models.Role;
import com.petshop.models.Usuario;
import com.petshop.repositories.UsuarioRepository;

@Controller
public class CadastroController extends SessaoInfo
{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/cadastro")
	public ModelAndView getRegistroPage()
	{
		ModelAndView modelAndView = new ModelAndView("cadastro");

		if (getUsuarioCorrente() == null)
			return new ModelAndView("/login");

		try {
			modelAndView.addObject("papel", getUsuarioCorrente().getRoles().iterator().next().getRole());
			modelAndView.addObject("nome", getUsuarioCorrente().getNome());
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
			final RedirectAttributes redirectAttributes, String bairro, String uf, String complemento, String cidade, String rua, Long numero)
	{
		
		if (bindingResult.hasErrors()) 
		{
			// tratar com uma growl mensagem?
			redirectAttributes.addFlashAttribute("mensagemErro", bindingResult.getAllErrors());
			return null;
		}

		// set Empresa
		usuario.setEmpresa(getEmpresa());
		
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setRole("Cliente");
		roles.add(role);

		// seleciona um papel
		usuario.setRoles(roles);

		// salva o usuario
		try {
			Endereco endereco = new Endereco();
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setComplemento(complemento);
			endereco.setUf(uf);
			endereco.setNumero(numero);
			endereco.setRua(rua);
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
