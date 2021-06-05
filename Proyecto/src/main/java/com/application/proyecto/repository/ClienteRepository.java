package com.application.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.entity.Cliente;

@Repository("ClienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{

	public List<Cliente> findByNombreclienteAndPasswordcliente(String nombrecliente, String passwordcliente);
	public List<Cliente> findByNombrecliente(String nombrecliente);
}
