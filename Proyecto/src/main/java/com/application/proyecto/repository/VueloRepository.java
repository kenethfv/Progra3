package com.application.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.entity.Vuelo;

@Repository("VueloRepository")

public interface VueloRepository extends JpaRepository<Vuelo, Serializable> {

	
	
}
