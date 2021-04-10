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

import com.application.proyecto.Entity.Anuncio;
import com.application.proyecto.Repository.AnuncioRepository;

@RestController
@RequestMapping("/anuncio")
@CrossOrigin
public class AnuncioService {
	
	@Autowired
	AnuncioRepository anuncioRepository;
	
	@GetMapping( path = "/buscar")
	public List<Anuncio> getAllAnuncio(){
		return anuncioRepository.findAll();
	}
	
	@PostMapping( path = "/guardar" )
	public Anuncio saveAnuncio(@RequestBody Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}
	
	@DeleteMapping( path = "/eliminar/{idanuncio}")
	public void deleteAnuncio(@PathVariable("idanuncio") Integer idanuncio) {
		Optional<Anuncio> anuncio;
		
		anuncio = anuncioRepository.findById(idanuncio);
		
		if	(anuncio.isPresent()) {
			anuncioRepository.delete(anuncio.get());
		}
	}


	
}
