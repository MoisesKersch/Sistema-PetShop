package com.petshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.petshop.repositories.UsuarioRepository;
import com.petshop.services.UsuarioDetailsServiceImpl;

// configuração referente ao repositorio do usuario
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UsuarioDetailsServiceImpl usuarioDetailsServiceImpl;

	// sobreresscrevendo o metodo de construtor de autentificação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// uma instancia dessa classe possui varios metodos de autentificação, como "em
		// memoria", "direto do banco"...
		// vamos utilizar o metodo de autentificação via "serviço" esse serviço vai se
		// conectar com a base de dados e obter data
		auth.userDetailsService(usuarioDetailsServiceImpl).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/secure/**").authenticated().antMatchers("/resources/**", "/public")
				.permitAll()
//			.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home", true).passwordParameter("senha")
				.usernameParameter("login").permitAll()
				.and().logout();
	}


	
	private PasswordEncoder getPasswordEncoder()
	{
		return new PasswordEncoder()
		{
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword)
			{
					return rawPassword.toString().equals(encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword)
			{
				return rawPassword.toString();
			}
		};
	}
}
