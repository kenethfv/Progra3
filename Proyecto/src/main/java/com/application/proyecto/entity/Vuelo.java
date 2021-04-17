package com.application.proyecto.entity;

import java.io.Serializable;
import java.util.Date;
import java.text.DecimalFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Vuelo")

public class Vuelo implements Serializable{
	
	private static final long serialVersionUID = 7L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column (name = "idvuelo")
	private Integer idvuelo;
	
	@Column (name = "cantpasajeros")
	private Integer cantpasajeros;
	
	@Column (name = "fechasalida")
	@Temporal(TemporalType.DATE)
	private Date fechasalida;
	
	@Column (name = "fechallegada")
	@Temporal(TemporalType.DATE)
	private Date fechallegada;
	
	@Column (name = "precio")
	private DecimalFormat precio;
	
	@Column (name = "idsalpais")
	private Integer IdSalPais;
	
	@Column (name = "Iddespais")
	private Integer IdDesPais;
	
	@Column (name = "idsalciudad")
	private Integer IdSalCiudad;
	
	@Column (name = "iddesciudad")
	private Integer IdDesCiudad;
	
	
	
	public Integer getIdvuelo() {
		return idvuelo;
	}

	public void setIdvuelo(Integer idvuelo) {
		this.idvuelo = idvuelo;
	}

	public Integer getCantpasajeros() {
		return cantpasajeros;
	}

	public void setCantpasajeros(Integer cantpasajeros) {
		this.cantpasajeros = cantpasajeros;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Date getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(Date fechallegada) {
		this.fechallegada = fechallegada;
	}

	public DecimalFormat getPrecio() {
		return precio;
	}

	public void setPrecio(DecimalFormat precio) {
		this.precio = precio;
	}

	public Integer getIdSalPais() {
		return IdSalPais;
	}

	public void setIdSalPais(Integer idSalPais) {
		IdSalPais = idSalPais;
	}

	public Integer getIdDesPais() {
		return IdDesPais;
	}

	public void setIdDesPais(Integer idDesPais) {
		IdDesPais = idDesPais;
	}

	public Integer getIdSalCiudad() {
		return IdSalCiudad;
	}

	public void setIdSalCiudad(Integer idSalCiudad) {
		IdSalCiudad = idSalCiudad;
	}

	public Integer getIdDesCiudad() {
		return IdDesCiudad;
	}

	public void setIdDesCiudad(Integer idDesCiudad) {
		IdDesCiudad = idDesCiudad;
	}


		
	
	
	

}
