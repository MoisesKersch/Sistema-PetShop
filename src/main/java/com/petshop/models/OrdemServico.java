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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ordem_servico_id")
	private Long id;

	@NotNull
	@Column(name = "data_reservada")
	private Date dataReservada = new Date();
	
	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name = "observacao")
	private String observacao;
	
	@ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	@Column(name = "data_finalizada")
	private Date dataFinalizada;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "America/Sao_Paulo", locale = "pt-BR")
	public Date getDataReservada()
	{
		return dataReservada;
	}

	public void setDataReservada(Date dataReservada)
	{
		this.dataReservada = dataReservada;
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

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	public Animal getAnimal()
	{
		return animal;
	}

	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}

	public Servico getServico()
	{
		return servico;
	}

	public void setServico(Servico servico)
	{
		this.servico = servico;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "America/Sao_Paulo", locale = "pt-BR")
	public Date getDataFinalizada()
	{
		return dataFinalizada;
	}

	public void setDataFinalizada(Date dataFinalizada)
	{
		this.dataFinalizada = dataFinalizada;
	}
}