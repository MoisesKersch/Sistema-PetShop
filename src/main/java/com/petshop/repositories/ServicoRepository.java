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
	
	@Query(value = 	" select s.servico_id, valor, s.nome, s.empresa_id, s.servico_categoria_id, descricao, imagem_url from ordem_servico os " + 
					" join usuario u on os.usuario_id = u.usuario_id " + 
					" join servico s on os.servico_id = s.servico_id " + 
					" where u.usuario_id = :userId", nativeQuery = true)          
	public List<Servico> findByUsuario( @Param("userId")Long userId );
}