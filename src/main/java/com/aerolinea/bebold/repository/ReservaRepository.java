package com.aerolinea.bebold.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.bebold.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query(value = "",nativeQuery=true)
    List<List<String>> listarReservas();

}
