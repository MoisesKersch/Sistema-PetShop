package com.petshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.models.Dica;
import com.petshop.models.Empresa;
import com.petshop.models.HomeAdm;
import com.petshop.models.HomeCli;
import com.petshop.models.Usuario;

@Service
public interface HomeService
{
	public HomeAdm getHomeAdm(Empresa empresa);
	public List<Dica> getDicas(Empresa empresa);
	public HomeCli getHomeCli(Empresa empresa, Usuario usuario);
}
