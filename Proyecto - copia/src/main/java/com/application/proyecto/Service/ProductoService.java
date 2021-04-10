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

import com.application.proyecto.Entity.Producto;
import com.application.proyecto.Repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping( path = "/buscar")
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	
	@PostMapping( path = "/guardar" )
	public Producto saveProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	@DeleteMapping( path = "/eliminar/{idproducto}")
	public void deleteRol(@PathVariable("idproducto") Integer idproducto) {
		Optional<Producto> producto;
		
		producto = productoRepository.findById(idproducto);
		
		if	(producto.isPresent()) {
			productoRepository.delete(producto.get());
		}
	}
	
}
