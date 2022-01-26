package com.aerolinea.bebold.service;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Tiquete;
import com.aerolinea.bebold.repository.TiqueteRepository;

@Service
public class TiqueteServiceImpl implements TiqueteService{

	private TiqueteRepository tiqueteRepository;
	
	public TiqueteServiceImpl(TiqueteRepository tiqueteRepository) {
		super();
		this.tiqueteRepository = tiqueteRepository;
	}

	@Override
	public Tiquete crearTiquete(Tiquete tiquete) {
		return tiqueteRepository.save(tiquete);
	}

}
