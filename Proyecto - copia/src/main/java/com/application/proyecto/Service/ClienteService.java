package com.application.proyecto.Service;

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

import com.application.proyecto.Entity.Cliente;
import com.application.proyecto.Entity.DireccionCliente;
import com.application.proyecto.Entity.TelefonoCliente;
import com.application.proyecto.Repository.ClienteRepository;
import com.application.proyecto.Repository.DireccionClienteRepository;
import com.application.proyecto.Repository.TelefonoClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	DireccionClienteRepository direccionClienteRepository;
	
	@Autowired
	TelefonoClienteRepository telefonoClienteRepository;
	
	@GetMapping( path = "/buscar")
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping( path = "/buscarCliente/{correo}")
	public List<Cliente> findByCliente(@PathVariable("correo") String correo){
		return clienteRepository.findByCorreo(correo);
	}
	
	@PostMapping( path ="/login")
	public Cliente login(@RequestBody Cliente cliente) {
		List<Cliente> user = clienteRepository.findByCorreoAndPassword(cliente.getCorreo(), cliente.getPassword());
		if(!user.isEmpty()){
			return user.get(0);
		}
		return null;

	}
	
	@PostMapping( path = "/guardar")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		
		List<DireccionCliente> direcciones = cliente.getDireccionClienteList();
		List<TelefonoCliente> telefonos = cliente.getTelefonoClienteList();
		
		cliente.setDireccionClienteList(null);
		cliente.setTelefonoClienteList(null);
		
		cliente = clienteRepository.save(cliente);
		
		cliente.setTelefonoClienteList(new LinkedList<>());
		cliente.setDireccionClienteList(new LinkedList<>());
		
		if(direcciones != null) {
			for(DireccionCliente d : direcciones) {
				d.setClienteIdCliente(cliente.getIdCliente());
				direccionClienteRepository.save(d);
				cliente.getDireccionClienteList().add(d);
			}
		}
		if(telefonos != null) {
			for(TelefonoCliente t : telefonos) {
				t.setClienteIdCliente(cliente.getIdCliente());
				telefonoClienteRepository.save(t);
				cliente.getTelefonoClienteList().add(t);
			}
		}
		
		return cliente;
	}
	
	@DeleteMapping( path = "/eliminar/{idcliente}" )
	public void deleteUsuario(@PathVariable("idcliente") Integer idcliente) {
		Optional<Cliente> Clienteb;
		
		Clienteb = clienteRepository.findById(idcliente);
		
		if(Clienteb.isPresent()) {
			Cliente borrar = Clienteb.get();
			
			for(TelefonoCliente t : borrar.getTelefonoClienteList()) {
				telefonoClienteRepository.delete(t);
			}
			for(DireccionCliente d : borrar.getDireccionClienteList()) {
				direccionClienteRepository.delete(d);
			}
		}
		
		clienteRepository.delete(Clienteb.get());
		
	}
	
}
