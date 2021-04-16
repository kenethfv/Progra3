package com.application.proyecto.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Vuelo")

public class Vuelo implements Serializable{
	
	private static final long serialVersionUID = 6L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column (name = "idVuelo")
	private Integer idvuelo;
	
	@Column (name = "CantPasajeros")
	private Integer cantpasajeros;
	
	@Column (name = "FechaSalida")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fechasalida;
	
	@Column (name = "FechaLlegada")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fechallegada;
	
	@Column (name = "Precio")
	private DecimalFormat precio;
	
	@Column (name = "IdSalPais")
	private Integer IdSalPais;
	
	@Column (name = "IdDesPais")
	private Integer IdDesPais;
	
	@Column (name = "IdSalCiudad")
	private Integer IdSalCiudad;
	
	@Column (name = "IdDesCiudad")
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

	public Timestamp getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Timestamp fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Timestamp getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(Timestamp fechallegada) {
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
