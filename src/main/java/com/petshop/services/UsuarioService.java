package com.petshop.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petshop.models.Usuario;

@Service
public interface UsuarioService 
{
	public void salvar(Usuario usuario);
	public void remover(String id);
	public void logarAposRegistro(HttpServletRequest request, String login, String senha);
}