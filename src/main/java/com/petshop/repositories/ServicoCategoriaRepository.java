package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Empresa;
import com.petshop.models.ServicoCategoria;

public interface ServicoCategoriaRepository extends JpaRepository<ServicoCategoria, Long>
{
	public List<ServicoCategoria> findByEmpresa(Empresa empresa);
}