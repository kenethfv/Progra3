package com.application.proyecto.service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
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

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteService {
	
	

	@Autowired
	ClienteRepository clienteRepository;


	@GetMapping(path = "/buscar")
	public List<Cliente> getAllCliente() {
		
		
		
		return clienteRepository.findAll();
	}
	
	
	/*@GetMapping(path = "/buscar")
	public List<Cliente> getAllCliente() {
		
		return clienteRepository.findAll();
	}*/

	@PostMapping(path = "/guardar")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		
		notificationProcessor.onNext(cliente);
		
		return clienteRepository.save(cliente);
		
		
	}
	
	/*@PostMapping(path = "/guardar")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}*/

	@DeleteMapping(path = "/eliminar/{idcliente}")
	public void deleteCliente(@PathVariable("idcliente") Integer idcliente) {

		Optional<Cliente> cliente;

		cliente = clienteRepository.findById(idcliente);

		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	
	private EmitterProcessor<Cliente> notificationProcessor;
	
	@PostConstruct
	private void createProcessor() {
		notificationProcessor = EmitterProcessor.<Cliente>create();
	}
	
	
	
	private Flux<ServerSentEvent<Cliente>> getClienteSSE() {
		
		return notificationProcessor
				.log()
				.map(
						(cliente) -> {
							System.out.println("Sending cliente:"+ cliente.getNombrecliente());
							return ServerSentEvent.<Cliente>builder()
									.id(UUID.randomUUID().toString())
									.event("cliente-result")
									.data(cliente)
									.build();
						}
					)
					.concatWith(Flux.never());
		
	}
	
	
	private Flux<ServerSentEvent<Cliente>> getNotificationHeartbeat() {
        return Flux.interval(Duration.ofSeconds(15))
                .map(i -> {
                    System.out.println(String.format("sending heartbeat [%s] ...", i.toString()));
                    return ServerSentEvent.<Cliente>builder()
                            .id(String.valueOf(i))
                            .event("heartbeat-result")
                            .data(null)
                            .build();
                });
    }
	
	@GetMapping(path = "/notification")
	public Flux<ServerSentEvent<Cliente>> getResultNotification() {
		return Flux.merge(
				getClienteSSE(),
				getNotificationHeartbeat()
		);
	}
	
	
	@PostMapping(path="/login")
	public Cliente login (@RequestBody Cliente cliente) {
		
		List<Cliente> clientes = clienteRepository.findByNombreclienteAndPasswordcliente(cliente.getNombrecliente(), cliente.getPasswordcliente());
		
		if(!clientes.isEmpty()) {
			return clientes.get(0);
		}
			return null;
	}
	
	
}
