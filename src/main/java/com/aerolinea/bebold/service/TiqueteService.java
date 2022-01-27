package com.aerolinea.bebold.service;

import java.util.Date;

import com.aerolinea.bebold.entity.Tiquete;

public interface TiqueteService {

	public Tiquete crearTiquete(Tiquete tiquete);
	public int descontarPorVuelos(int idPasajero, Date fechaInicio, Date fechaFin);
}
