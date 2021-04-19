package com.application.proyecto.service;

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

import com.application.proyecto.entity.VueloCliente;
import com.application.proyecto.repository.EstadoRepository;
import com.application.proyecto.repository.VueloClienteRepository;

@RestController
@RequestMapping("/vuelocliente")
@CrossOrigin
public class VueloClienteService {

	@Autowired
	VueloClienteRepository vueloClienteRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@DeleteMapping(path = "/eliminar/{noBoletos}")
	public void deleteVueloCliente(@PathVariable("noBoletos") Integer noBoletos) {
		
		Optional<VueloCliente> vueloCliente;
		vueloCliente = vueloClienteRepository.findById(noBoletos);
		if(vueloCliente.isPresent()) {
			vueloClienteRepository.delete(vueloCliente.get());
		}
	}
	
	@GetMapping(path = "/buscar")
	public List<VueloCliente> getAllVueloClientes(){
		return vueloClienteRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public VueloCliente saveVueloCliente(@RequestBody VueloCliente vueloCliente) {
		
		vueloCliente = vueloClienteRepository.save(vueloCliente);
		
		Optional<VueloCliente> vueloClienteR;
		vueloClienteR = vueloClienteRepository.findById(vueloCliente.getIdvueloCliente());
		if(vueloClienteR.isPresent()) {
			vueloCliente = vueloClienteR.get();
		}
		
		return vueloCliente;
	}
	
	
	
	
	
	
	
	
	
}
