package com.petshop.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ordem")
public class Ordem
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ordem_id")
	private Long id;

	@NotNull
	@Column(name = "data_reservada")
	private Date data = new Date();

	@Column(name = "data_finalizada")
	private Date dataFinalizada;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "ordem")
	private List<Ordem> ordens;

	@NotNull
	private String descricao;

	@NotNull
	private String status; 

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo", locale = "pt-BR")
	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo", locale = "pt-BR")
	public Date getDataFinalizada()
	{
		return dataFinalizada;
	}

	public void setDataFinalizada(Date dataFinalizada)
	{
		if (this.status.equals("Pago"))
			this.dataFinalizada = new Date();
		else
			this.dataFinalizada = dataFinalizada;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public List<Ordem> getOrdens()
	{
		return ordens;
	}

	public void setOrdens(List<Ordem> ordens)
	{
		this.ordens = ordens;
	}
}