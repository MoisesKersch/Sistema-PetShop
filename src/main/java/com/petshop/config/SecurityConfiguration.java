package com.petshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	private final String USERS_QUERY = "select email, password, active from users where email=?";
	private final String ROLES_QUERY = "select u.email, r.role from users u inner join users_role ur on (u.id = ur.users_id) inner join r on (ur.role_id = r.role_id) where u.email=?";

	// configurações do banco de dados aonde esta os dados da autentificação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// seleciona a opção e configura suas propiedades, query que busca por username,
		// query que busca por autoridades, fonte de dados (database), configuração de
		// encriptografia.
		auth.jdbcAuthentication().usersByUsernameQuery(USERS_QUERY).authoritiesByUsernameQuery(ROLES_QUERY)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	// configuração de permissão para urls no sistema, padrão todas estão
	// bloqueadas, mais abaixo estaremos liberando algumas
	protected void configure(HttpSecurity httpSecurity)
	{
		// abrimos a opção autorizar requesições
		try
		{
			httpSecurity.authorizeRequests().antMatchers("/").permitAll() // acesso total a url "/"
					.antMatchers("/login").permitAll() // acesso total a url "login"
					.antMatchers("/registrar").permitAll() // acesso total a url "registrar"
					.antMatchers("/home/**").hasAuthority("ADMIN").anyRequest() // acesso total a url "home" caso a role
																				// seja "ADMIN"
					.authenticated().and().csrf().disable().formLogin().loginPage("/login")
					.failureUrl("/login?error=true").defaultSuccessUrl("/home/home").usernameParameter("email")
					.passwordParameter("password").and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/login")).logoutSuccessUrl("/").and().rememberMe()
					.tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60 * 60).and()
					.exceptionHandling().accessDeniedPage("/access_denied");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository()
	{
		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		jdbcTokenRepositoryImpl.setDataSource(dataSource);

		return jdbcTokenRepositoryImpl;
	}
}
