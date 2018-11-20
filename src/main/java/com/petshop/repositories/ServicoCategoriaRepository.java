package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.ServicoCategoria;

public interface ServicoCategoriaRepository extends JpaRepository<ServicoCategoria, Long>
{
}