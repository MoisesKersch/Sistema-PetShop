package com.petshop.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comprovante")
public class Comprovante
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comprovante_id")
	private Long id;

	@NotNull
	@Column(name = "data_pagamento")
	private Date dataPagamento = new Date();
	
	@Column(name = "observacao")
	private String observacao;
	
	@ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDataPagamento()
	{
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento)
	{
		this.dataPagamento = dataPagamento;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public Animal getAnimal()
	{
		return animal;
	}

	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	public Servico getServico()
	{
		return servico;
	}

	public void setServico(Servico servico)
	{
		this.servico = servico;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}