package com.petshop.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "servico_categoria")
public class ServicoCategoria
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "servico_catetoria_id")
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "servicoCategoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Servico> servico = new HashSet<Servico>();

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Set<Servico> getServico()
	{
		return servico;
	}

	public void setServico(Set<Servico> servico)
	{
		this.servico = servico;
	}
}