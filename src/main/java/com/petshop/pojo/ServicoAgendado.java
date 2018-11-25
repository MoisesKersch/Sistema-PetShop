package com.petshop.pojo;

import java.math.BigDecimal;

import com.petshop.models.Empresa;
import com.petshop.models.ServicoCategoria;

public class ServicoAgendado
{
	private Long id;
	
	private BigDecimal valor;
	
	private String nome;
	
	private String descricao;
	
	private String url;
	
    private ServicoCategoria servicoCategoria;
    
    private Empresa empresa;
    
    Boolean agendado = false;
    
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public BigDecimal getValor()
	{
		return valor;
	}
	
	public void setValor(BigDecimal valor)
	{
		this.valor = valor;
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
	
	public String getUrl()
	{
		return url;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public ServicoCategoria getServicoCategoria()
	{
		return servicoCategoria;
	}
	
	public void setServicoCategoria(ServicoCategoria servicoCategoria)
	{
		this.servicoCategoria = servicoCategoria;
	}
	
	public Empresa getEmpresa()
	{
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}
	
	public Boolean getAgendado()
	{
		return agendado;
	}
	
	public void setAgendado(Boolean agendado)
	{
		this.agendado = agendado;
	}
}