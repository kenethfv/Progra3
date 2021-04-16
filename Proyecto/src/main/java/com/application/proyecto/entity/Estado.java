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
@Table(name = "Estado")
public class Estado implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdEstado")
	private Integer idEstado;
	
	@Column(name = "Descripcion")
	private String descripcion;

	/*
	 * Uno a muchos
	 */
	
	@OneToMany(mappedBy = "estadoIdEstado")
	private List<Estado> estadoList;
	
	/*
	 * Mapeo GET AND SET
	 */

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}
	
	
	
	
	
	
	

	}

	
	
	
	

