package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>
{
}