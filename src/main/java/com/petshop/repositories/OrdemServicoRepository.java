package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>
{
}