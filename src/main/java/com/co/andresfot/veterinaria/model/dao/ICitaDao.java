package com.co.andresfot.veterinaria.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.andresfot.veterinaria.model.entity.Cita;

public interface ICitaDao extends CrudRepository<Cita, Long>{

	/*@Query("SELECT f FROM FacturaMedica f LEFT JOIN f.cita c WHERE f.cita.id=?1")
	public Cita fetchCitaByIdWithFacturas(Long id);*/
	
}
