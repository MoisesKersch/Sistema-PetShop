package com.petshop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.models.Usuario;
import com.petshop.repositories.UsuarioRepository;
import com.petshop.utils.documentosPessoais.CNP;


// nesta classe escrever codigos que precisam ser validado no lado do servidor
@RestController
@RequestMapping(value = "/public")
public class ValidacaoController
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	private CNP cpn;

	@RequestMapping(value = "/iscpfcnpjvalido", method = RequestMethod.POST)
	public Boolean isCpfCnpjValido(String entrada)
	{
		try
		{
			return CNP.validaCPF(entrada);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/isusuarioexiste", method = RequestMethod.POST)
	public Boolean isUsuarioExiste(String login)
	{
		Optional<Usuario> usuarioExiste = usuarioRepository.findByLogin(login);
		return usuarioExiste.isPresent();
	}
}
