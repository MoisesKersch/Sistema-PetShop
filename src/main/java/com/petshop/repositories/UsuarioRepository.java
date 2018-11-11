package com.petshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	Optional<Usuario> findByLogin(String login);
}