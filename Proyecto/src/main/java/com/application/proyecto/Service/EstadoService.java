package com.application.proyecto.Service;

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

import com.application.proyecto.Entity.Estado;
import com.application.proyecto.Repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Estado> getAllEstado(){
		return estadoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar" )
	public Estado saveEstado(@RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@DeleteMapping( path = "/eliminar/{idestado}")
	public void deleteRol(@PathVariable("idestado") Integer idestado) {
		Optional<Estado> estado;
		
		estado = estadoRepository.findById(idestado);
		
		if	(estado.isPresent()) {
			estadoRepository.delete(estado.get());
		}
	}
	
}
