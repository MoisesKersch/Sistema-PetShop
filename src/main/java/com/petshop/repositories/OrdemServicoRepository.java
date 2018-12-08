package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.petshop.models.Empresa;
import com.petshop.models.OrdemServico;
import com.petshop.models.Servico;
import com.petshop.models.Usuario;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>
{
	public List<OrdemServico> findByUsuarioAndEmpresa(Usuario usuario, Empresa empresa);
	
	public List<OrdemServico> findByEmpresa(Empresa empresa);
	
	public List<OrdemServico> findByUsuarioAndServico(Usuario usuario, Servico servico);
	
	@Query("SELECT os FROM OrdemServico os JOIN Servico s on s.id  = os.servico where os.empresa = :empresa and os.usuario = :usuario and os.status != 'Cancelado' ")
	public List<OrdemServico> findByUsuarioAndEmpresaAndNotCanceled(Usuario usuario, Empresa empresa);
}