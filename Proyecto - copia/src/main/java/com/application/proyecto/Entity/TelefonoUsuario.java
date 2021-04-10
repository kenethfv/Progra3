package com.application.proyecto.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefono_usuario")
public class TelefonoUsuario implements Serializable{

	private static final long serialVersionUID = 12L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idtelefono")
	private Integer idTelefono;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdUsuario;

	public Integer getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getUsuarioIdUsuario() {
		return usuarioIdUsuario;
	}

	public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}

}
