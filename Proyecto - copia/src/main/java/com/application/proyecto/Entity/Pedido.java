package com.application.proyecto.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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
@Table(name = "pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 8L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idpedido")
	private Integer idPedido;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaingreso")
	private Calendar fechaIngreso;
	
	@Column(name = "total")
	private Double total;
	
	@Temporal(TemporalType.DATE)	
	@Column(name = "fechaentrega")
	private Calendar fechaEntrega;
	
	@Column(name = "estado_idestado")
	private Integer estadoIdEstado;
	
	@Column(name = "cliente_idcliente")
	private Integer clienteIdCliente;
	
	@OneToMany(mappedBy = "pedidoIdPedido")
	private List<DetallePedido> detallePedidoList;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Calendar getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Calendar fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Integer getEstadoIdEstado() {
		return estadoIdEstado;
	}

	public void setEstadoIdEstado(Integer estadoIdEstado) {
		this.estadoIdEstado = estadoIdEstado;
	}

	public Integer getClienteIdCliente() {
		return clienteIdCliente;
	}

	public void setClienteIdCliente(Integer clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}

	public List<DetallePedido> getDetallePedidoList() {
		return detallePedidoList;
	}

	public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
		this.detallePedidoList = detallePedidoList;
	}	

}
