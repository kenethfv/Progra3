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

import com.application.proyecto.entity.Ciudad;
import com.application.proyecto.entity.Vuelo;
import com.application.proyecto.repository.CiudadRepository;
import com.application.proyecto.repository.VueloRepository;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin

public class CiudadService {

	@Autowired
	CiudadRepository ciudadRepository;

	@Autowired
	VueloRepository vueloRepository;

	// SERVICIO BUSCAR

	@GetMapping(path = "/buscar")
	public List<Ciudad> getAllCiudades() {
		return ciudadRepository.findAll();
	}

	// SERVICIO GUARDAR

	@PostMapping(path = "/guardar")
	public Ciudad saveCiudad(@RequestBody Ciudad ciudad) {

		List<Vuelo> ciudadSal = ciudad.getCiudadSalList();
		List<Vuelo> ciudadDes = ciudad.getCiudadDesList();

		ciudad.setCiudadSalList(null);
		ciudad.setCiudadDesList(null);

		ciudad = ciudadRepository.save(ciudad);

		ciudad.setCiudadSalList(new LinkedList<>());
		ciudad.setCiudadDesList(new LinkedList<>());

		if (ciudadSal != null) {
			for (Vuelo v : ciudadSal) {
				v.setIdSalCiudad(ciudad.getIdCiudad());
				vueloRepository.save(v);
				ciudad.getCiudadSalList().add(v);
			}
		}

		if (ciudadDes != null) {
			for (Vuelo vd : ciudadDes) {
				vd.setIdDesCiudad(ciudad.getIdCiudad());
				vueloRepository.save(vd);
				ciudad.getCiudadDesList().add(vd);
			}
		}

		Optional<Ciudad> ciudadR;
		ciudadR = ciudadRepository.findById(ciudad.getIdCiudad());
		if (ciudadR.isPresent()) {
			ciudad = ciudadR.get();

		}
		return ciudad;

	}

	// SERVICIO ELIMINAR

	@DeleteMapping(path = "/eliminar/{idCiudad}")
	public void deleteCiudad(@PathVariable("idCiudad") Integer idCiudad) {

		Optional<Ciudad> ciudad;
		ciudad = ciudadRepository.findById(idCiudad);
		if (ciudad.isPresent()) {
			Ciudad borrar = ciudad.get();

			
			for (Vuelo vueloDestino : borrar.getCiudadDesList()) {
				vueloRepository.delete(vueloDestino);
			}

			for (Vuelo vueloSalida : borrar.getCiudadSalList()) {
				vueloRepository.delete(vueloSalida);
			}

			ciudadRepository.delete(ciudad.get());
		}
	}

}
