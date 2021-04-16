package com.application.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.entity.VueloCliente;

@Repository("VueloClienteRepository")
public interface VueloClienteRepository extends JpaRepository<VueloCliente, Serializable>{

	public List<VueloCliente> findByNoBoletos(Integer NoBoletos);
	
}
