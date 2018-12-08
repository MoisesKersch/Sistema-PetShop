package com.petshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ordem_servico_id")
	private Long id;

	@Column(name = "observacao")
	private String observacao;
	
	@ManyToOne
    @JoinColumn(name = "ordem_id")
    private Ordem ordem;
	
	@ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

	public Long getId()
	{
		return id;
	}
	

	public String getObservacao()
	{
		return observacao;
	}
	

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}
	

	public Ordem getOrdem()
	{
		return ordem;
	}
	

	public void setOrdem(Ordem ordem)
	{
		this.ordem = ordem;
	}
	

	public Animal getAnimal()
	{
		return animal;
	}
	

	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}
	

	public Empresa getEmpresa()
	{
		return empresa;
	}
	

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}
	

	public Servico getServico()
	{
		return servico;
	}
	

	public void setServico(Servico servico)
	{
		this.servico = servico;
	}
	

	public void setId(Long id)
	{
		this.id = id;
	}
}