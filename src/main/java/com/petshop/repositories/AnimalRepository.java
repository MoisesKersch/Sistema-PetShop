package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Animal;
import com.petshop.models.Usuario;

public interface AnimalRepository extends JpaRepository<Animal, Long>
{
	public List<Animal> findByUsuario(Usuario usuario);
}