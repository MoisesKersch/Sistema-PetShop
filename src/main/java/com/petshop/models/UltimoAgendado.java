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

@Entity
@Table(name = "ultimo_agendado")
public class UltimoAgendado
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ultimo_agendado_id")
	private Long id;

	@ManyToOne
    @JoinColumn(name = "ordem_servico_id")
	private OrdemServico ordemServico;
	
	@Column(name = "lancado_em")
	private Date lancadoEm;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public OrdemServico getOrdemServico()
	{
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico)
	{
		this.ordemServico = ordemServico;
	}

	public Date getLancadoEm()
	{
		return lancadoEm;
	}

	public void setLancadoEm(Date lancadoEm)
	{
		this.lancadoEm = lancadoEm;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}
}