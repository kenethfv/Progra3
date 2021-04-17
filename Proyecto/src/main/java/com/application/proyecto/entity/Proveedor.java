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
@Table(name = "proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 5L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idproveedor")
	private Integer idproveedor;

	@Column(name = "nombreproveedor")
	private String nombreproveedor;

	@Column(name = "correoproveedor")
	private String correoproveedor;

	@Column(name = "passwordproveedor")
	private String passwordproveedor;

	@Column(name = "sexo")
	private String sexo;

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombreproveedor() {
		return nombreproveedor;
	}

	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}

	public String getCorreoproveedor() {
		return correoproveedor;
	}

	public void setCorreoproveedor(String correoproveedor) {
		this.correoproveedor = correoproveedor;
	}

	public String getPasswordproveedor() {
		return passwordproveedor;
	}

	public void setPasswordproveedor(String passwordproveedor) {
		this.passwordproveedor = passwordproveedor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
