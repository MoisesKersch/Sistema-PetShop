package com.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.component.SessaoInfo;
import com.petshop.models.UltimoAgendado;
import com.petshop.repositories.UltimoAgendadoRepository;
import com.petshop.repositories.UsuarioRepository;


// nesta classe escrever codigos que precisam ser validado
@RestController
@RequestMapping(value = "/admin")
public class AdminController extends SessaoInfo
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UltimoAgendadoRepository ultimoAgendadoRepository;
	

	@RequestMapping(value = "/ultimoagendado", method = RequestMethod.POST)
	public List<UltimoAgendado> getUltimoAgendado()
	{
		return ultimoAgendadoRepository.findByEmpresa(getUsuarioCorrente().getEmpresa());
	}
	
	
	
}

