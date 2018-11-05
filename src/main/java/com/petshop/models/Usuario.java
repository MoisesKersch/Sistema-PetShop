package com.petshop.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long usuarioId;
	
	@NotEmpty
	@Column(name="nome")
	private String nome;
	
	@NotEmpty
	@Column(name="cpf")
	private String cpf;
	
	@NotEmpty
	@OneToMany(mappedBy = "enderecoId")
	private List<Endereco> endereco;
	
	@Column(name="login")
	@NotEmpty
	private String login;
	
	@Column(name="senha")
	@NotEmpty
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Long getUsuarioId()
	{
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId)
	{
		this.usuarioId = usuarioId;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public List<Endereco> getEndereco()
	{
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco)
	{
		this.endereco = endereco;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
}	