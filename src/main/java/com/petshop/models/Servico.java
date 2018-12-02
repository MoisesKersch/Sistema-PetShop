package com.petshop.models;

import java.math.BigDecimal;

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
@Table(name = "servico")
public class Servico
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "servico_id")
	private Long id;
	
	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "imagem_url")
	private String url;
	
	@ManyToOne
    @JoinColumn(name = "servico_categoria_id")
    private ServicoCategoria servicoCategoria;

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

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

//	public List<OrdemServico> getOrdemServico()
//	{
//		return ordemServico;
//	}
//
//	public void setOrdemServico(List<OrdemServico> ordemServico)
//	{
//		this.ordemServico = ordemServico;
//	}
}