package com.petshop.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.Animal;
import com.petshop.models.OrdemServico;
import com.petshop.models.Servico;
import com.petshop.models.Usuario;
import com.petshop.pojo.ServicoAgendado;
import com.petshop.repositories.OrdemServicoRepository;
import com.petshop.repositories.ServicoRepository;

import javassist.NotFoundException;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService
{
	
	@Autowired
	private OrdemServicoRepository orderServicoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Override
	public OrdemServico salvar(OrdemServico ordemServico, Long animalId, Long servicoId, Usuario usuario)
	{
		try {
			ordemServico.setEmpresa(usuario.getEmpresa());
			ordemServico.setUsuario(usuario);
			ordemServico.setServico(servicoRepository.findById(servicoId).orElseThrow(() -> new NotFoundException("Servico nao encontrado")));
			
			for (Animal x : usuario.getAnimais()) 
			{
				if (animalId.equals( x.getId() ))
				{
					ordemServico.setAnimal(x);
					break;
				}
			}
			if (ordemServico.getAnimal() == null)
				throw new NotFoundException("Animal não encontrado!");
			
			return orderServicoRepository.save(ordemServico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ServicoAgendado> servicoCliente(Usuario usuario)
	{
		// lista todos os serviços
		List<Servico> servicos = servicoRepository.findByEmpresa(usuario.getEmpresa());
		
		// lista todos os agendados do cliente
		List<Object[]> obj = servicoRepository.findByUsuario(usuario.getId());
		
		
		for(Object x : obj)
		{
		    Class<?> clazz = x.getClass();

		    Field field = org.springframework.util.ReflectionUtils.findField(clazz, "value");
		    org.springframework.util.ReflectionUtils.makeAccessible(field);

		    try {
				System.out.println("value=" + field.get(obj));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		List<ServicoAgendado> agendados = new ArrayList<>();
		
		for (Object x : obj) 
		{
			agendados.add((ServicoAgendado)x);
		}
	
		List<ServicoAgendado> servicoAgendados = new ArrayList<>();
		
		for (Servico x : servicos) 
		{
			ServicoAgendado servicoAgendado = new ServicoAgendado();
			servicoAgendado.setServicoId(x.getId());
			servicoAgendado.setDescricao(x.getDescricao());
			servicoAgendado.setNome(x.getNome());
			servicoAgendado.setServicoCategoria(x.getServicoCategoria());
			servicoAgendado.setUrl(x.getUrl());
			servicoAgendado.setValor(x.getValor());
			servicoAgendados.add(servicoAgendado);
		}
		
		for (ServicoAgendado x : servicoAgendados) 
		{
			for (ServicoAgendado y : agendados)
			{
				if (x.getId()  == y.getServicoId())
				{
					x.setAgendado(true);
				}
			}
		}	
		
		return servicoAgendados;
	}
}
