package com.petshop.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empresa")
public class Empresa
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empresa_id")
	private Long id;
	
	@NotNull
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@NotNull
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual;
	
	@NotNull
	@Column(name = "representante_legal")
	private String representanteLegal;
	
	@NotNull
	@Column(name = "cnpj")
	private String cnpj;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf_representante_legal")
	private String cpfRepresentanteLegal;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "empresa_endereco", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfRepresentanteLegal() {
		return cpfRepresentanteLegal;
	}

	public void setCpfRepresentanteLegal(String cpfRepresentanteLegal) {
		this.cpfRepresentanteLegal = cpfRepresentanteLegal;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}