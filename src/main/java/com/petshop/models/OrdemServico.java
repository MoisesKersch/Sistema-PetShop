package com.petshop.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ordem_servico_id")
	private Long id;
	
	@NotNull
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	@Column(name = "data_pagamento")
	private Date datapagamento;
	
	@NotNull
	@Column(name = "status")
	private String status = "aberto";
	
	@NotNull
	@Column(name = "observacao")
	private String observacao;
	
	@NotNull
	@Column(name = "cod_animal")
	private Long codAnimal;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDataVencimento()
	{
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento)
	{
		this.dataVencimento = dataVencimento;
	}

	public Date getDatapagamento()
	{
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento)
	{
		this.datapagamento = datapagamento;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public Long getCodAnimal()
	{
		return codAnimal;
	}

	public void setCodAnimal(Long codAnimal)
	{
		this.codAnimal = codAnimal;
	}
}