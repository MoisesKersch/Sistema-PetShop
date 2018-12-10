package com.petshop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.Dica;
import com.petshop.models.Empresa;
import com.petshop.models.HomeAdm;
import com.petshop.models.HomeCli;
import com.petshop.models.Usuario;
import com.petshop.repositories.DicaRepository;

@Service
public class HomeServiceImpl implements HomeService
{
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	private DicaRepository dicaRepository;

	@Override
	public HomeAdm getHomeAdm(Empresa empresa)
	{
		EntityManager em =  emf.createEntityManager();
		String sql = "select * from home_admin("+empresa.getId()+")";
		return (HomeAdm) em.createNativeQuery(sql, HomeAdm.class).getSingleResult();
	}
	
	@Override
	public List<Dica> getDicas(Empresa empresa)
	{
		try {
			return dicaRepository.findByEmpresa(empresa);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HomeCli getHomeCli(Empresa empresa, Usuario usuario)
	{
		EntityManager em =  emf.createEntityManager();
		String sql = "select * from home_cliente("+empresa.getId()+","+usuario.getId()+")";
		return (HomeCli) em.createNativeQuery(sql, HomeCli.class).getSingleResult();
	}
}
