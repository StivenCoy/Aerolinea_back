package com.aerolinea.bebold.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.entity.Tiquete;
import com.aerolinea.bebold.service.TiqueteService;

@RestController
@RequestMapping("/Api/Tiquete")
@CrossOrigin({"*"})
public class TiqueteController {
	
	public TiqueteService tiqueteService;

	public TiqueteController(TiqueteService tiqueteService) {
		super();
		this.tiqueteService = tiqueteService;
	}

	/**
	 * Metodo que crea un tiquete 
	 * @param tiquete tiquete que se va a crear 
	 * @return retorna el tiquete creado
	 */
	@PostMapping("/Crear")
	public ResponseEntity<?> create(@RequestBody Tiquete tiquete)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(tiqueteService.crearTiquete(tiquete));
	}
}
