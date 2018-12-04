package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Empresa;
import com.petshop.models.OrdemServico;
import com.petshop.models.Servico;
import com.petshop.models.Usuario;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>
{
	public List<OrdemServico> findByUsuario(Usuario usuario);
	public List<OrdemServico> findByEmpresa(Empresa empresa);
	public List<OrdemServico> findByUsuarioAndServico(Usuario usuario, Servico servico);
}