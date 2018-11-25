package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.OrdemServico;
import com.petshop.models.Usuario;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>
{
	public List<OrdemServico> findByUsuario(Usuario usuario);
}