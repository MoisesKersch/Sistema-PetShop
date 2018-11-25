package com.petshop.services;

import org.springframework.stereotype.Service;

import com.petshop.models.Servico;
import com.petshop.models.Usuario;

@Service
public interface ServicoService
{
	public Servico salvar(Servico servico, Long categoriaId);
}
