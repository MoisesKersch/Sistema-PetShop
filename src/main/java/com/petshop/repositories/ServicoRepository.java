package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petshop.models.Empresa;
import com.petshop.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>
{
	public List<Servico> findByEmpresa(Empresa empresa);
	
	@Query(value = 	" select * from get_servico_agendado(:userId) ", nativeQuery = true)
	public List<Object[]> findByUsuario( @Param("userId")Long userId );
	
}