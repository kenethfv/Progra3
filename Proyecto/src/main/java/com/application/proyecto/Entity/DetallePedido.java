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
@Table(name = "detalle_pedido")
public class DetallePedido implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "iddetallepedido")
	private Integer idDetallePedido;
	
	@Column(name = "pedido_idpedido")
	private Integer pedidoIdPedido;
	
	@Column(name = "producto_idproducto")
	private Integer productoIdProducto;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "total")
	private Double total;

	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public Integer getPedidoIdPedido() {
		return pedidoIdPedido;
	}

	public void setPedidoIdPedido(Integer pedidoIdPedido) {
		this.pedidoIdPedido = pedidoIdPedido;
	}

	public Integer getProductoIdProducto() {
		return productoIdProducto;
	}

	public void setProductoIdProducto(Integer productoIdProducto) {
		this.productoIdProducto = productoIdProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


}
