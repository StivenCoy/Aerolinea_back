package com.aerolinea.bebold.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Pasajero;
import com.aerolinea.bebold.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{
	
	private PasajeroRepository pasajeroRepository;
	

	public PasajeroServiceImpl(PasajeroRepository pasajeroRepository) {
		super();
		this.pasajeroRepository = pasajeroRepository;
	}

	@Override
	public Pasajero crearPasajero(Pasajero pasajero) {
		return pasajeroRepository.save(pasajero);
	}

	@Override
	public Pasajero buscarPasajero(Integer idpasajero) {
		return pasajeroRepository.findById(idpasajero).get();
	}

	@Override
	public Pasajero actualizarPasajero(int idPasajero, double millas) {
		Optional<Pasajero> pasajero = pasajeroRepository.findById(idPasajero);
		pasajero.get().setMillasViajadas(millas);
		pasajero.get().setCantidadViajes();
		return pasajeroRepository.save(pasajero.get());
	}

	
}
