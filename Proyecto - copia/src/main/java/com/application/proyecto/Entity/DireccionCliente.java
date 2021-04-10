package com.application.proyecto.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "direccion_cliente")
public class DireccionCliente implements Serializable{

	private static final long serialVersionUID = 5L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "iddireccioncliente")
	private Integer idDireccionCliente;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "cliente_idcliente")
	private Integer clienteIdCliente;

	public Integer getIdDireccionCliente() {
		return idDireccionCliente;
	}

	public void setIdDireccionCliente(Integer idDireccionCliente) {
		this.idDireccionCliente = idDireccionCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getClienteIdCliente() {
		return clienteIdCliente;
	}

	public void setClienteIdCliente(Integer clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}


}
