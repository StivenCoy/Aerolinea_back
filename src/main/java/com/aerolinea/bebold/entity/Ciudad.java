package com.aerolinea.bebold.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, name= "idCiudad")
	private int idCiudad;
	
	@Column(nullable = false, name= "nombre")
	private String nombre;
	
	@Column(nullable = false, name= "visa")
	private String visa;
	
	@Column(nullable = false, name= "nacional")
	private String nacional;
	
	
	
	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public String isVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String isNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}
	
	
}
