package com.petshop.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.models.Usuario;
import com.petshop.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService
{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void salvar(Usuario usuario)
	{
		try
		{
			usuarioRepository.save(usuario);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void remover(String id)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logarAposRegistro(HttpServletRequest request, String login, String senha)
	{
		 try {
		        request.login(login, senha);
		    } catch (ServletException e) {
		    	e.getMessage();
		    }
	}
}
