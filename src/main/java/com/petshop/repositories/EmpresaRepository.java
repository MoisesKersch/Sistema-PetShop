package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>
{
	
}