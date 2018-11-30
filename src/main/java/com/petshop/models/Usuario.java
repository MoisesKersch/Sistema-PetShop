package com.petshop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
public class Usuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long id;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "login", unique = true)
	private String login;
	
	@NotNull
	@Column(name = "senha")
	private String senha;
	
	@NotNull
	@Column(name = "cpf")
	private Long cpf;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "ativo")
	private int ativo;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "usuario_endereco", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<OrdemServico> ordemServico = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Animal> animais = new ArrayList<>();
     
	public Usuario()
	{
		
	}

	public Usuario(Usuario usuario)
	{
		this.ativo = usuario.getAtivo();
		this.email = usuario.getEmail();
		this.roles = usuario.getRoles();
		this.nome = usuario.getNome();
		this.id = usuario.getId();
		this.senha = usuario.getSenha();
		this.login = usuario.getLogin();
		this.empresa = usuario.getEmpresa();
		this.enderecos = usuario.getEnderecos();
		this.animais = usuario.getAnimais();
		this.ordemServico = usuario.getOrdemServico();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCpf()
	{
		return cpf;
	}

	public void setCpf(Long cpf)
	{
		this.cpf = cpf;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getAtivo()
	{
		return ativo;
	}

	public void setAtivo(int ativo)
	{
		this.ativo = ativo;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public List<Endereco> getEnderecos()
	{
		return enderecos;
	}

	public void setEndereco(List<Endereco> enderecos)
	{
		this.enderecos = enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos)
	{
		this.enderecos = enderecos;
	}

	public List<Animal> getAnimais()
	{
		return animais;
	}

	public void setAnimais(List<Animal> animais)
	{
		this.animais = animais;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	public List<OrdemServico> getOrdemServico()
	{
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServico> ordemServico)
	{
		this.ordemServico = ordemServico;
	}
}