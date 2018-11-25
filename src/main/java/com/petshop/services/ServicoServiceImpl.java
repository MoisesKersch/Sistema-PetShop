package com.petshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.Servico;
import com.petshop.models.ServicoCategoria;
import com.petshop.models.Usuario;
import com.petshop.repositories.ServicoCategoriaRepository;
import com.petshop.repositories.ServicoRepository;

@Service
public class ServicoServiceImpl implements ServicoService
{
	@Autowired
	private ServicoCategoriaRepository servicoCategoriaRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Override
	public Servico salvar(Servico servico, Long categoriaId)
	{
		Optional<ServicoCategoria> servicoCategoriaFinder = servicoCategoriaRepository.findById(categoriaId);
		if (servicoCategoriaFinder.isPresent())
		{
			ServicoCategoria servicoCategoria = servicoCategoriaFinder.get();
			servico.setServicoCategoria(servicoCategoria);
		} else
		{
			// TODO tratar caso o serviço categoria não for encontrado no sistema
			return null;
		}
	
		try
		{
			servico = servicoRepository.save(servico);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		return servico;
	}
}
