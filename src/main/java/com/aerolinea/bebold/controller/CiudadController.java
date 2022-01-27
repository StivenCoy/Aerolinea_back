package com.aerolinea.bebold.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.service.CiudadService;

@RestController
@RequestMapping("/Api/Ciudad")
@CrossOrigin({"*"})
public class CiudadController {

	private CiudadService ciudadService;

	public CiudadController(CiudadService ciudadService) {
		super();
		this.ciudadService = ciudadService;
	}
	
	@GetMapping("/Visa/{nombre}")
	public ResponseEntity<Boolean> buscar(@PathVariable(value ="nombre") String nombre){
		boolean isVisa= ciudadService.isVisa(nombre);
		return ResponseEntity.ok(isVisa);
	}
}
