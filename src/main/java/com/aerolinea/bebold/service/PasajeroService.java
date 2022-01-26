package com.aerolinea.bebold.service;


import com.aerolinea.bebold.entity.Pasajero;

public interface PasajeroService {
	
	public Pasajero crearPasajero(Pasajero pasajero);
	public Pasajero buscarPasajero(Integer idpasajero);
	public Pasajero actualizarPasajero(int idPasajero, double millas);

}
