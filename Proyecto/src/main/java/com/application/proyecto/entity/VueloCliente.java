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
	private Integer idvueloCliente;
	
	@Column(name = "Idvuelo")
	private Integer idVuelo;
	
	@Column(name = "noboletos")
	private Integer noBoletos;
	
	@Column(name = "total")
	private double total;

	@Column(name = "clienteIdcliente")
	private Integer clienteIdCliente;
	
	@Column(name = "estadoIdestado")
	private Integer estadoIdEstado;
	
	/*
	 * Get and Set
	 */



	public Integer getIdVuelo() {
		return idVuelo;
	}
	
	public Integer getIdvueloCliente() {
		return idvueloCliente;
	}



	public void setIdvueloCliente(Integer idvueloCliente) {
		this.idvueloCliente = idvueloCliente;
	}



	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getNoBoletos() {
		return noBoletos;
	}

	public void setNoBoletos(Integer noBoletos) {
		this.noBoletos = noBoletos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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
