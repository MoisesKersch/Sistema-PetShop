package com.petshop.component;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.petshop.models.Usuario;

public abstract class SessaoInfo
{
	protected Usuario getUsuarioCorrente()
	{
		try 
		{
			Optional<Usuario> usuario = (Optional) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			usuario.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
			
			return usuario.map(Usuario::new).get();
		} catch (Exception e) {
			SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
			return null;
		}
	}
}