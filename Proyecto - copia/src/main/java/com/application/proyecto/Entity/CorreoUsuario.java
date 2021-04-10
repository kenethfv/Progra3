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
@Table(name = "correo_usuario")
public class CorreoUsuario implements Serializable{

	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcorreo")
	private Integer idCorreo;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "usuario_idusuario")
	private Integer usuarioIdUsuario;

	public Integer getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getUsuarioIdUsuario() {
		return usuarioIdUsuario;
	}

	public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}

}
