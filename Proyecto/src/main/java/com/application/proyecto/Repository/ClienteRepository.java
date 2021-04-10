package com.application.proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.Entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{

	public List<Cliente> findByCorreoAndPassword(String correo, String password);
	
	public List<Cliente> findByCorreo(String correo);
}
