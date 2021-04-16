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
@Table(name = "Estado")
public class Estado implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdEstado")
	private Integer IdEstado;
	
	@Column(name = "Descripcion")
	private String Descripcion;

	/*
	 * Mapeo GET AND SET
	 */
	
	public Integer getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(Integer idEstado) {
		IdEstado = idEstado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
	
	
}
