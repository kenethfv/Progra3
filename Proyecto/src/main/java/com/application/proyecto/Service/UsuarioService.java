package com.application.proyecto.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.proyecto.Entity.CorreoUsuario;
import com.application.proyecto.Entity.DireccionUsuario;
import com.application.proyecto.Entity.TelefonoUsuario;
import com.application.proyecto.Entity.Usuario;
import com.application.proyecto.Repository.CorreoUsuarioRepository;
import com.application.proyecto.Repository.DireccionUsuarioRepository;
import com.application.proyecto.Repository.TelefonoUsuarioRepository;
import com.application.proyecto.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CorreoUsuarioRepository correoUsuarioRepository;
	
	@Autowired
	DireccionUsuarioRepository direccionUsuarioRepository;
	
	@Autowired
	TelefonoUsuarioRepository telefonoUsuarioRepository;
	
	@GetMapping( path = "/buscar")
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping( path = "/buscarUsuario/{usuario}")
	public List<Usuario> findByUsuario(@PathVariable("usuario") String usuario){
		return usuarioRepository.findByUsuario(usuario);
	}
	
	@PostMapping( path ="/login")
	public Usuario login(@RequestBody Usuario usuario) {
		
		List<Usuario> user = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword());
		if(!user.isEmpty()){
			return user.get(0);
		}
		return null;
	}
	
	@PostMapping( path = "/guardar")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		
		List<CorreoUsuario> correos = usuario.getCorreoUsuarioList();
		List<DireccionUsuario> direcciones = usuario.getDireccionUsuarioList();
		List<TelefonoUsuario> telefonos = usuario.getTelefonoUsuarioList();
		
		usuario.setCorreoUsuarioList(null);
		usuario.setDireccionUsuarioList(null);
		usuario.setTelefonoUsuarioList(null);
		
		usuario = usuarioRepository.save(usuario);
		
		usuario.setTelefonoUsuarioList(new LinkedList<>());
		usuario.setCorreoUsuarioList(new LinkedList<>());
		usuario.setDireccionUsuarioList(new LinkedList<>());
		
		if(correos != null) {
			for(CorreoUsuario c : correos) {
				c.setUsuarioIdUsuario(usuario.getIdUsuario());
				correoUsuarioRepository.save(c);
				usuario.getCorreoUsuarioList().add(c);
			}
		}
		if(direcciones != null) {
			for(DireccionUsuario d : direcciones) {
				d.setUsuarioIdUsuario(usuario.getIdUsuario());
				direccionUsuarioRepository.save(d);
				usuario.getDireccionUsuarioList().add(d);
			}
		}
		if(telefonos != null) {
			for(TelefonoUsuario t : telefonos) {
				t.setUsuarioIdUsuario(usuario.getIdUsuario());
				telefonoUsuarioRepository.save(t);
				usuario.getTelefonoUsuarioList().add(t);
			}
		}
		
		return usuario;
	}
	
	@DeleteMapping( path = "/eliminar/{idusuario}" )
	public void deleteUsuario(@PathVariable("idusuario") Integer idusuario) {
		Optional<Usuario> Usuariob;
		
		Usuariob = usuarioRepository.findById(idusuario);
		
		if(Usuariob.isPresent()) {
			Usuario borrar = Usuariob.get();
			
			for(TelefonoUsuario t : borrar.getTelefonoUsuarioList()) {
				telefonoUsuarioRepository.delete(t);
			}
			for(CorreoUsuario c : borrar.getCorreoUsuarioList()) {
				correoUsuarioRepository.delete(c);
			}
			for(DireccionUsuario d : borrar.getDireccionUsuarioList()) {
				direccionUsuarioRepository.delete(d);
			}
		}
		
		usuarioRepository.delete(Usuariob.get());
		
	}
	

}
