package com.aerolinea.bebold.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Reserva;
import com.aerolinea.bebold.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{

	private ReservaRepository reservaRepository;
	
	

	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}

	@Override
	public List<Reserva> listarReservas() {
		return reservaRepository.findAll();
	}

	@Override
	public Reserva crearRegistro(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	
}
