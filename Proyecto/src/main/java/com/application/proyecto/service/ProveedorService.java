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

import com.application.proyecto.entity.Proveedor;
import com.application.proyecto.repository.ProveedorRepository;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin
public class ProveedorService {

	@Autowired
	ProveedorRepository proveedorRepository;

	@GetMapping(path = "/buscar")
	public List<Proveedor> getAllProveedor() {
		return proveedorRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Proveedor saveProveedor(@RequestBody Proveedor proveedor) {
				
		return proveedorRepository.save(proveedor);
	}

	@DeleteMapping(path = "/eliminar/{idproveedor}")
	public void deleteProveedor(@PathVariable("idproveedor") Integer idproveedor) {

		Optional<Proveedor> proveedor;

		proveedor = proveedorRepository.findById(idproveedor);

		if (proveedor.isPresent()) {
			proveedorRepository.delete(proveedor.get());
		}
	}
}
