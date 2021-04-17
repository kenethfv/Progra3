package com.application.proyecto.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Vuelo_Cliente")
public class VueloCliente implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idvueloCliente")
	private Integer idVuelo_Cliente;
	
	@Column(name = "Idvuelo")
	private Integer idVuelo;
	
	@Column(name = "noboletos")
	private Integer NoBoletos;
	
	@Column(name = "total")
	private double Total;
	
<<<<<<< HEAD
	@Column(name = "Cliente_idCliente")
	private Integer clienteIdCliente;
	
	@Column(name = "Estado_IdEstado")
	private Integer estadoIdEstado;
=======
	@Column(name = "clienteIdcliente")
	private double clienteIdCliente;
	
	@Column(name = "estadoIdestado")
	private double estadoIdEstado;
>>>>>>> bd0c3cd58653ac97eb0d3a0876966882e02b8d5d
	
	/*
	 * Get and Set
	 */

	public Integer getIdVuelo_Cliente() {
		return idVuelo_Cliente;
	}

	public void setIdVuelo_Cliente(Integer idVuelo_Cliente) {
		this.idVuelo_Cliente = idVuelo_Cliente;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getNoBoletos() {
		return NoBoletos;
	}

	public void setNoBoletos(Integer noBoletos) {
		NoBoletos = noBoletos;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public Integer getClienteIdCliente() {
		return clienteIdCliente;
	}

	public void setClienteIdCliente(Integer clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}

	public Integer getEstadoIdEstado() {
		return estadoIdEstado;
	}

	public void setEstadoIdEstado(Integer estadoIdEstado) {
		this.estadoIdEstado = estadoIdEstado;
	}
	
		
	
	
}
