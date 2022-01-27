package com.aerolinea.bebold.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	//falta postman
	@GetMapping("/ContarVuelos")
	public ResponseEntity<?> contarVuelos(
			@RequestParam(value="fechaInicio") @DateTimeFormat( pattern ="yyyy-MM-dd" ) Date fechaInicio,
			@RequestParam(value="fechaFin") @DateTimeFormat( pattern ="yyyy-MM-dd" ) Date fechaFin,
			@RequestParam(value="idPasajero", required = false) int idPasajero){
		int totalVuelos = tiqueteService.descontarPorVuelos(idPasajero, fechaInicio, fechaFin);
		return ResponseEntity.ok(totalVuelos);
	}
}
