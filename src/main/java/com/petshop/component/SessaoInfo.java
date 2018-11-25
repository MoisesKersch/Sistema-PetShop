package com.petshop.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.petshop.models.Empresa;
import com.petshop.models.Usuario;
import com.petshop.repositories.EmpresaRepository;

public abstract class SessaoInfo
{
	@Autowired
	private EmpresaRepository empresaRepository;

	protected Usuario getUsuarioCorrente()
	{
		try {
			Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if (usuario != null)
				if (usuario.getLogin() == null) 
					return null;
			return usuario;
		} catch (Exception e) 
		{
			return null;
		}
	}
	
	public Empresa getEmpresa()
	{
		Optional<Empresa> empresa = empresaRepository.findById(1L);
		empresa.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
		return empresa.get();
	}
}