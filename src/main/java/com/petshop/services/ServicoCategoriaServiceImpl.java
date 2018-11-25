package com.petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.ServicoCategoria;
import com.petshop.repositories.ServicoCategoriaRepository;

@Service
public class ServicoCategoriaServiceImpl implements ServicoCategoriaService
{
	@Autowired
	private ServicoCategoriaRepository servicoCategoriaRepository;
	
	@Override
	public ServicoCategoria salvar(ServicoCategoria servicoCategoria)
	{
		try {
			return servicoCategoriaRepository.save(servicoCategoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
