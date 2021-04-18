package com.application.proyecto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")

public class Cliente implements Serializable {

	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcliente")
	private Integer idcliente;

	@Column(name = "nombrecliente")
	private String nombrecliente;

	@Column(name = "correocliente")
	private String correocliente;

	@Column(name = "passwordcliente")
	private String passwordcliente;

	@Column(name = "sexo")
	private String sexo;
	
	@OneToMany(mappedBy = "clienteIdCliente")
	private List<VueloCliente> vueloClienteList;

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getCorreocliente() {
		return correocliente;
	}

	public void setCorreocliente(String correocliente) {
		this.correocliente = correocliente;
	}

	public String getPasswordcliente() {
		return passwordcliente;
	}

	public void setPasswordcliente(String passwordcliente) {
		this.passwordcliente = passwordcliente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<VueloCliente> getVueloClienteList() {
		return vueloClienteList;
	}

	public void setVueloClienteList(List<VueloCliente> vueloClienteList) {
		this.vueloClienteList = vueloClienteList;
	}

	
	
}
