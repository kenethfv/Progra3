package com.Programacion.Proyecto.Services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
@CrossOrigin

public class Serv {
	@GetMapping("/HelloWorld")
	public String HelloWorld() { return "Hola Mmundo"; }
}
