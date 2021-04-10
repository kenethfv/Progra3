package com.application.proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.Entity.DetallePedido;

@Repository("detallePedidoRepository")
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Serializable>{

	public List<DetallePedido> findBypedidoIdPedido(String pedidoIdPedido);
	
}
