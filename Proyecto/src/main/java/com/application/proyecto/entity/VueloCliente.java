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
@Table(name = "Vuelo_Cliente")
public class VueloCliente implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idVuelo_Cliente")
	private Integer idVuelo_Cliente;
	
	@Column(name = "IdVuelo")
	private Integer idVuelo;
	
	@Column(name = "NoBoletos")
	private Integer NoBoletos;
	
	@Column(name = "Total")
	private double Total;
	
	@Column(name = "Cliente_idCliente")
	private double clienteIdCliente;
	
	@Column(name = "Estado_IdEstado")
	private double estadoIdEstado;
	
	
	@OneToMany(mappedBy = "usuarioIdusuario")
	private List<Estado> estadoList;
	
}
