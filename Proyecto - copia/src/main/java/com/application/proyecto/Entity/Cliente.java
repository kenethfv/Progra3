package com.application.proyecto.Entity;

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
@Table(name = "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcliente")
	private Integer idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "clienteIdCliente")
	private List<DireccionCliente> direccionClienteList;
	
	@OneToMany(mappedBy = "clienteIdCliente")
	private List<TelefonoCliente> telefonoClienteList;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DireccionCliente> getDireccionClienteList() {
		return direccionClienteList;
	}

	public void setDireccionClienteList(List<DireccionCliente> direccionClienteList) {
		this.direccionClienteList = direccionClienteList;
	}

	public List<TelefonoCliente> getTelefonoClienteList() {
		return telefonoClienteList;
	}

	public void setTelefonoClienteList(List<TelefonoCliente> telefonoClienteList) {
		this.telefonoClienteList = telefonoClienteList;
	}



}
