package com.aerolinea.bebold.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.entity.Pasajero;
import com.aerolinea.bebold.service.PasajeroService;

@RestController
@RequestMapping("/Api/Pasajero")
@CrossOrigin({"*"})
public class PasajeroController {
	
	
	public PasajeroService pasajeroService;
	
	 
	public PasajeroController(PasajeroService pasajeroService) {
		super();
		this.pasajeroService = pasajeroService;
	}

	/**
	 * Metodo que crea un pasajero 
	 * @param pasajero Pasajero que va hacer creado
	 * @return retorna el pasajero creado
	 */
	@PostMapping("/Crear")
	public ResponseEntity<?> create(@RequestBody Pasajero pasajero)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.crearPasajero(pasajero));
	}
	
	/**
	 * Metodo que busca un pasajero con su id
	 * @param idpasajero id del pasajero a ser buscado
	 * @return retorna el pasajero 
	 */
	@GetMapping("/Buscar/{idpasajero}")
	public ResponseEntity<Pasajero> buscar(@PathVariable(value ="idpasajero") Integer idpasajero){
		Pasajero pasajero= pasajeroService.buscarPasajero(idpasajero);
		if(pasajero == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pasajero);
	}
	
	/**
	 * Metodo que actualiza un viaje para aumentar las millas y la cantidad de viajes
	 * @param pasajero pasajero que se va a actualizar
	 * @return retorna pasajero
	 */
	@PostMapping("/Viaje")
	public ResponseEntity<Pasajero> agregarViaje(
			@RequestParam(value="idPasajero", required = false) int idPasajero,
			@RequestParam(value="millas",required = false) double millas){
		Pasajero pasajero= pasajeroService.actualizarPasajero(idPasajero,millas);
		if(pasajero != null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pasajero);
	}
	
}