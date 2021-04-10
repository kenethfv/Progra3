package com.application.proyecto.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 13L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idusuario")
	private Integer idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "rol_idrol")
	private Integer rolIdRol;
	
	@OneToMany(mappedBy = "usuarioIdUsuario")
	private List<CorreoUsuario> correoUsuarioList;
	
	@OneToMany(mappedBy = "usuarioIdUsuario")
	private List<DireccionUsuario> direccionUsuarioList;
	
	@OneToMany(mappedBy = "usuarioIdUsuario")
	private List<TelefonoUsuario> telefonoUsuarioList;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRolIdRol() {
		return rolIdRol;
	}

	public void setRolIdRol(Integer rolIdRol) {
		this.rolIdRol = rolIdRol;
	}

	public List<CorreoUsuario> getCorreoUsuarioList() {
		return correoUsuarioList;
	}

	public void setCorreoUsuarioList(List<CorreoUsuario> correoUsuarioList) {
		this.correoUsuarioList = correoUsuarioList;
	}

	public List<DireccionUsuario> getDireccionUsuarioList() {
		return direccionUsuarioList;
	}

	public void setDireccionUsuarioList(List<DireccionUsuario> direccionUsuarioList) {
		this.direccionUsuarioList = direccionUsuarioList;
	}

	public List<TelefonoUsuario> getTelefonoUsuarioList() {
		return telefonoUsuarioList;
	}

	public void setTelefonoUsuarioList(List<TelefonoUsuario> telefonoUsuarioList) {
		this.telefonoUsuarioList = telefonoUsuarioList;
	}

}
