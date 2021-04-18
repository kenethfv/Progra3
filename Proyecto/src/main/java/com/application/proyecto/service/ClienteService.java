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

import com.application.proyecto.entity.Cliente;
import com.application.proyecto.repository.ClienteRepository;
import com.application.proyecto.repository.VueloClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	VueloClienteRepository vueloClienteRepository;

	@GetMapping(path = "/buscar")
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping(path = "/eliminar/{idcliente}")
	public void deleteCliente(@PathVariable("idcliente") Integer idcliente) {

		Optional<Cliente> cliente;

		cliente = clienteRepository.findById(idcliente);

		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
}
