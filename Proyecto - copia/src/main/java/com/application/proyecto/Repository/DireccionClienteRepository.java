package com.application.proyecto.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.Entity.DireccionCliente;

@Repository("direccionClienteRepository")
public interface DireccionClienteRepository extends JpaRepository<DireccionCliente, Serializable>{

}
