package com.petshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petshop.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	Optional<Usuario> findByLogin(String login);
	
	@Query(value = " select u.usuario_id, ativo, cpf, email, login, nome, senha, complemento from usuario u " + 
			       " join usuario_empresa eu " + 
			       " on u.usuario_id = eu.usuario_id " + 
			       " where u.login = :login"+ 
			       " and eu.empresa_id = :empresaId ", nativeQuery = true)          
	public Optional<Usuario> findByLoginAndEmpresaId( @Param("login")String login, @Param("empresaId") Long empresaId );
}