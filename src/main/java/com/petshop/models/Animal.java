package com.petshop.models;

import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "animal")
public class Animal
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "animal_id")
	private Long id;

	@NotNull
	@Column(name = "especie")
	private String especie;

	@Column(name = "peso")
	private BigDecimal peso;
	
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
	@NotNull
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "pedigree")
	private String pedigree;
	
	@Column(name = "raca")
	private String raca;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "observacao")
	private String observacao;
	
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

	public String getEspecie()
	{
		return especie;
	}

	public void setEspecie(String especie)
	{
		this.especie = especie;
	}

	public BigDecimal getPeso()
	{
		return peso;
	}

	public void setPeso(BigDecimal peso)
	{
		this.peso = peso;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getDataNascimento()
	{
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public String getPedigree()
	{
		return pedigree;
	}

	public void setPedigree(String pedigree)
	{
		this.pedigree = pedigree;
	}

	public String getRaca()
	{
		return raca;
	}

	public void setRaca(String raca)
	{
		this.raca = raca;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
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