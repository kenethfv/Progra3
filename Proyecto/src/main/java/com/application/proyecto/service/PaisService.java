package com.application.proyecto.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.proyecto.entity.Ciudad;
import com.application.proyecto.entity.Pais;
import com.application.proyecto.entity.Vuelo;
import com.application.proyecto.repository.CiudadRepository;
import com.application.proyecto.repository.PaisRepository;
import com.application.proyecto.repository.VueloRepository;

@RestController
@RequestMapping("/Pais")
@CrossOrigin

public class PaisService {
	
	@Autowired
	PaisRepository paisRepository;
	
	@Autowired
	CiudadRepository ciudadRepository;
	
	@Autowired
	VueloRepository vueloRepository;
	
	// SERVICIO BUSCAR

		@GetMapping(path = "/buscar")
		public List<Pais> getAllPaises() {
			return paisRepository.findAll();
		}
		
	//	SERVICIO GUARDAR

		@PostMapping(path = "/guardar")
		public Pais saveCliente(@RequestBody Pais pais) {

			List<Ciudad> ciudades = pais.getCiudadList();
			List<Vuelo> vueloDestino = pais.getVueloDesList();
			List<Vuelo> vueloSalida = pais.getVueloSalList();

			pais.setCiudadList(null);
			pais.setVueloDesList(null);
			pais.setVueloSalList(null);

			pais = paisRepository.save(pais);

			pais.setCiudadList(new LinkedList<>());
			pais.setVueloDesList(new LinkedList<>());
			pais.setVueloSalList(new LinkedList<>());

			if (ciudades != null) {
				for (Ciudad c : ciudades) {
					c.setPaisIdPais(pais.getIdPais());
					ciudadRepository.save(c);
					pais.getCiudadList().add(c);
				}
			}

			if (vueloDestino != null) {
				for (Vuelo vd : vueloDestino) {
					vd.setIdDesPais(pais.getIdPais());
					vueloRepository.save(vd);
					pais.getVueloDesList().add(vd);
				}
			}

			if (vueloSalida != null) {
				for (Vuelo vs : vueloSalida) {
					vs.setIdSalPais(pais.getIdPais());
					vueloRepository.save(vs);
					pais.getVueloSalList().add(vs);
				}
			}

			Optional<Pais> paisR;
			paisR = paisRepository.findById(pais.getIdPais());
			if (paisR.isPresent()) {
				pais = paisR.get();

			}
			return pais;

		}

}
