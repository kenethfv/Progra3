package com.application.proyecto.service;

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


import com.application.proyecto.entity.Estado;
import com.application.proyecto.entity.VueloCliente;
import com.application.proyecto.repository.EstadoRepository;
import com.application.proyecto.repository.VueloClienteRepository;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	VueloClienteRepository vueloClienteRepository;
	
	@GetMapping(path = "/buscar")
	public List<Estado> getEstado() {
		return estadoRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Estado saveEstado(@RequestBody Estado estado) {
		
		List<VueloCliente> vueloClientes = estado.getVueloClienteList();
		
		estado.setVueloClienteList(null);
		
		estado = estadoRepository.save(estado);
		
		estado.setVueloClienteList(new LinkedList<>());
		
		
		if (vueloClientes != null) {
			for (VueloCliente t : vueloClientes) {
				t.setNoBoletos(estado.getIdEstado());
				vueloClienteRepository.save(t);
				estado.getVueloClienteList().add(t);
			}
		}
		Optional<Estado> estadoE;
		estadoE = estadoRepository.findById(estado.getIdEstado());
		if(estadoE.isPresent()) {
			estado = estadoE.get();
		}
				
		return estado;
	}
	
	@GetMapping(path="/buscar/estado/{descripcion}")
	public List<Estado> getEstado(@PathVariable("descripcion") String descripcion){
		
		List<Estado> estados = estadoRepository.findByDescripcion(descripcion);
		
		return estados;
	}
	
	
	/*
	 * No se usar?? el eliminar estado debido a que en la base de datos
	 * se ha colocado NOT NULL.
	 */
	
	@DeleteMapping(path="/eliminar/{idEstado}")
	public void deleteEstado(@PathVariable ("idEstado") String idEstado) {
		Optional<Estado> estado;
		estado= estadoRepository.findById(idEstado);
		if(estado.isPresent()) {
			Estado borrar = estado.get();
			
			for(VueloCliente e : borrar.getVueloClienteList()) {
				vueloClienteRepository.delete(e);
			}
		}
		
		
	}
	
	
	
	
	
	
}
