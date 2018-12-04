package com.petshop.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.Animal;
import com.petshop.models.OrdemServico;
import com.petshop.models.Usuario;
import com.petshop.pojo.ServicoAgendado;
import com.petshop.repositories.AnimalRepository;
import com.petshop.repositories.OrdemServicoRepository;
import com.petshop.repositories.ServicoRepository;

import javassist.NotFoundException;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService
{

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public OrdemServico salvar(OrdemServico ordemServico, Long animalId, Long servicoId, Usuario usuario)
	{
		try {
			ordemServico.setEmpresa(usuario.getEmpresa());
			ordemServico.setUsuario(usuario);
			ordemServico.setServico(servicoRepository.findById(servicoId)
					.orElseThrow(() -> new NotFoundException("Servico nao encontrado")));
			
			Optional<Animal> animal = animalRepository.findById(animalId);
			ordemServico.setAnimal(animal.get());
		
			if (ordemServico.getAnimal() == null)
				throw new NotFoundException("Animal não encontrado!");
			
			for (OrdemServico x : ordemServicoRepository.findByUsuarioAndServico(usuario, ordemServico.getServico())) 
			{
				if (x.getStatus().equals("Aberto"))
					return null;
			}

			return ordemServicoRepository.save(ordemServico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ServicoAgendado> getServicoCliente(Long usuarioId)
	{
		EntityManager em =  emf.createEntityManager();
		String sql = "select * from servicos_usuario("+usuarioId+")";
		Query query = em.createNativeQuery(sql, ServicoAgendado.class);
		@SuppressWarnings("unchecked")
		List<ServicoAgendado> servicoAgendado = query.getResultList();	
		return servicoAgendado;
	}
}
