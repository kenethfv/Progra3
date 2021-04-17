package com.application.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.proyecto.entity.Vuelo;
import com.application.proyecto.repository.VueloRepository;

@RestController
@RequestMapping ("/vuelo")
@CrossOrigin

public class VueloService {
	
	@Autowired
	VueloRepository vueloRepository;
	
	@GetMapping( path = "/buscar" )
	public List<Vuelo> getAllVuelo(){
		return vueloRepository.findAll();
	}
	
	@PostMapping( path = "/guardar")
	public Vuelo saveVuelo(@RequestBody Vuelo vuelo) {
		return vueloRepository.save(vuelo);
	}
	
	

}
