package com.petshop.services;

import org.springframework.stereotype.Service;

import com.petshop.models.ServicoCategoria;

@Service
public interface ServicoCategoriaService
{
	public ServicoCategoria salvar(ServicoCategoria servicoCategoria);
}
