package com.co.andresfot.veterinaria.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.andresfot.veterinaria.model.entity.FacturaMedica;

public interface IFacturaMedicaDao extends CrudRepository<FacturaMedica, Long>{

	@Query("SELECT f FROM FacturaMedica f LEFT JOIN f.cita c WHERE f.cita.id=?1")
	public List<FacturaMedica> fetchCitaByIdWithFacturas(Long id);
	
}
