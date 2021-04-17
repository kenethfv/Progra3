package com.application.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.entity.Proveedor;

@Repository("proveedorRepository")
public interface ProveedorRepository extends JpaRepository<Proveedor, Serializable>{

}
