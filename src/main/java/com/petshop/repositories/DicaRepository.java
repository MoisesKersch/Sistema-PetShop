package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Dica;
import com.petshop.models.Empresa;

public interface DicaRepository extends JpaRepository<Dica, Long>
{
	public List<Dica> findByEmpresa(Empresa empresa);
}
