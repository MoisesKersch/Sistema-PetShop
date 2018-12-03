package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Empresa;
import com.petshop.models.UltimoAgendado;

public interface UltimoAgendadoRepository extends JpaRepository<UltimoAgendado, Long>
{
	public List<UltimoAgendado> findByEmpresa(Empresa empresa);
}