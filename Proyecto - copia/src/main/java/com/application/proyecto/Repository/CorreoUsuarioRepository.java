package com.application.proyecto.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.proyecto.Entity.CorreoUsuario;

@Repository("correoUsuarioRepository")
public interface CorreoUsuarioRepository extends JpaRepository<CorreoUsuario, Serializable>{

}
