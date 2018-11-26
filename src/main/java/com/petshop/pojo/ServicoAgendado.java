package com.petshop.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.petshop.models.ServicoCategoria;

@Entity
public class ServicoAgendado
{
	@Id
	private Long id;
	
	@Column(name = "servico_id")
	private Long servicoId;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "imagem_url")
	private String url;
	
	@ManyToOne
    @JoinColumn(name = "servico_categoria_id")
    private ServicoCategoria servicoCategoria;
    
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

	public Long getServicoId()
	{
		return servicoId;
	}

	public void setServicoId(Long servicoId)
	{
		this.servicoId = servicoId;
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
