package com.petshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "endereco")
public class Endereco
{
	@Id
	@Column(name = "endereco_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long enderecoId;
	
	@NotEmpty
	@Column(name="bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name="cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name="uf")
	private String uf;

	public Long getEnderecoId()
	{
		return enderecoId;
	}

	public void setEnderecoId(Long enderecoId)
	{
		this.enderecoId = enderecoId;
	}

	public String getBairro()
	{
		return bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	public String getUf()
	{
		return uf;
	}

	public void setUf(String uf)
	{
		this.uf = uf;
	}
}
