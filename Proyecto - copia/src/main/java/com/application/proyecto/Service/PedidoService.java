package com.application.proyecto.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.proyecto.Entity.DetallePedido;
import com.application.proyecto.Entity.Pedido;
import com.application.proyecto.Repository.DetallePedidoRepository;
import com.application.proyecto.Repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
@CrossOrigin
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Pedido> getAllPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping( path = "/buscarPedido/{idpedido}")
	public Optional<Pedido> findByIdPedido(@PathVariable("idpedido") Integer idpedido){
		
		return pedidoRepository.findById(idpedido);
	
	}
	
	@PostMapping( path = "/guardar")
	public Pedido savePedido(@RequestBody Pedido pedido) {
		
		List<DetallePedido> detalles = pedido.getDetallePedidoList();
		
		pedido.setDetallePedidoList(null);
		
		pedido = pedidoRepository.save(pedido);
		
		pedido.setDetallePedidoList(new LinkedList<>());
		
		if(detalles != null) {
			for(DetallePedido dp : detalles) {
				dp.setPedidoIdPedido(pedido.getIdPedido());
				detallePedidoRepository.save(dp);
				pedido.getDetallePedidoList().add(dp);
			}
		}
		
		return pedido;
	}
	
	@DeleteMapping( path = "/eliminar/{idpedido}" )
	public void deletePedido(@PathVariable("idpedido") Integer idpedido) {
		Optional<Pedido> Pedidob;
		
		Pedidob = pedidoRepository.findById(idpedido);
		
		if(Pedidob.isPresent()) {
			Pedido borrar = Pedidob.get();
			
			for(DetallePedido dp : borrar.getDetallePedidoList()) {
				detallePedidoRepository.delete(dp);
			}
		}
		
		pedidoRepository.delete(Pedidob.get());
		
	}
	
}
