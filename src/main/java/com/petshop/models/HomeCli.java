package com.petshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HomeCli
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "home_id")
	private Long id;
	
	@Column(name = "servico_agendado")
	private Integer servicoAgendado;
	
	@Column(name = "servico_concluido")
	private Integer servicoConcluido;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getServicoAgendado()
	{
		return servicoAgendado;
	}

	public void setServicoAgendado(Integer servicoAgendado)
	{
		this.servicoAgendado = servicoAgendado;
	}

	public Integer getServicoConcluido()
	{
		return servicoConcluido;
	}

	public void setServicoConcluido(Integer servicoConcluido)
	{
		this.servicoConcluido = servicoConcluido;
	}
}