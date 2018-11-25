package com.petshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.models.OrdemServico;
import com.petshop.models.Usuario;
import com.petshop.pojo.ServicoAgendado;

@Service
public interface OrdemServicoService
{
	public OrdemServico salvar(OrdemServico ordemServico, Long animalId, Long servicoId, Usuario usuario);
	public List<ServicoAgendado> servicoCliente(Usuario usuario);
}
