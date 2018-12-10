package com.petshop.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HomeAdm
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "home_id")
	private Long id;
	
	@Column(name = "nro_cliente")
	private Integer nroClientes;
	
	@Column(name = "total_vendas")
	private Integer totalVendas;
	
	@Column(name = "lucro")
	private BigDecimal lucro;
	
	@Column(name = "servicos_aberto")
	private Integer servicosAberto;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getNroClientes()
	{
		return nroClientes;
	}

	public void setNroClientes(Integer nroClientes)
	{
		this.nroClientes = nroClientes;
	}

	public Integer getTotalVendas()
	{
		return totalVendas;
	}

	public void setTotalVendas(Integer totalVendas)
	{
		this.totalVendas = totalVendas;
	}

	public String getLucro()
	{
		NumberFormat brlCostFormat = NumberFormat.getCurrencyInstance( new Locale("pt", "BR") );
		brlCostFormat.setMinimumFractionDigits( 2 );
		brlCostFormat.setMaximumFractionDigits( 2 );
		return  brlCostFormat.format(lucro.doubleValue());
	}

	public void setLucro(BigDecimal lucro)
	{
		this.lucro = lucro;
	}

	public Integer getServicosAberto()
	{
		return servicosAberto;
	}

	public void setServicosAberto(Integer servicosAberto)
	{
		this.servicosAberto = servicosAberto;
	}
}