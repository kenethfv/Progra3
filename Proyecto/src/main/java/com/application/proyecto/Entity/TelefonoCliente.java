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
@Table(name = "telefono_cliente")
public class TelefonoCliente implements Serializable{

	private static final long serialVersionUID = 11L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idtelefonocliente")
	private Integer idTelefonoCliente;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "cliente_idcliente")
	private Integer clienteIdCliente;

	public Integer getIdTelefonoCliente() {
		return idTelefonoCliente;
	}

	public void setIdTelefonoCliente(Integer idTelefonoCliente) {
		this.idTelefonoCliente = idTelefonoCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getClienteIdCliente() {
		return clienteIdCliente;
	}

	public void setClienteIdCliente(Integer clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}

}
