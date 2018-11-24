package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Empresa;
import com.petshop.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>
{
	public List<Servico> findByEmpresa(Empresa empresa);
}