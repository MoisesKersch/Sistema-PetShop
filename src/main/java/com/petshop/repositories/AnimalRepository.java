package com.petshop.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petshop.models.Animal;
import com.petshop.models.Usuario;

public interface AnimalRepository extends JpaRepository<Animal, Long>
{
	public List<Animal> findByUsuario(Usuario usuario);
	
	@Transactional
	@Modifying
	@Query("delete from Animal a where a.id = :id")
	public void deleteById(@Param("id")Long id);
}