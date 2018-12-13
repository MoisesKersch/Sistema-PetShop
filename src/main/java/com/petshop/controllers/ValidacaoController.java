package com.petshop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.models.Usuario;
import com.petshop.repositories.UsuarioRepository;
import com.petshop.utils.documentosPessoais.CNP;

// nesta classe escrever codigos que precisam ser validado
@RestController
@RequestMapping(value = "/public")
public class ValidacaoController
{
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/iscpfcnpjvalido", method = RequestMethod.POST)
	public Boolean isCpfCnpjValido(String entrada)
	{
		try {
			return CNP.validaCPF(entrada);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	@RequestMapping(value = "/isusuarioexiste", method = RequestMethod.POST)
	public Boolean isUsuarioExiste(String login, Long usuarioId)
	{
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(usuarioId);
		if (usuarioExiste.isPresent())
		{
			if (usuarioExiste.get().getLogin().equals(login))
				return false;
		}
		
		usuarioExiste = usuarioRepository.findByLogin(login);
		return usuarioExiste.isPresent();
	}
}
