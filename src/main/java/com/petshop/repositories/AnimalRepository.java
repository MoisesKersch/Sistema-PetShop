package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>
{
}