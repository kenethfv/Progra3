package com.application.proyecto.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.entity.Estado;

@Repository("estadoRepository")
public interface EstadoRepository extends JpaRepository<Estado, Serializable>{
	
	public List<Estado> findByDescripcion(String descripcion);

}
