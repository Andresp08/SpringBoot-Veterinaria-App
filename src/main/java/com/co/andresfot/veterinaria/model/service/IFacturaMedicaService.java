package com.co.andresfot.veterinaria.model.service;

import java.util.List;

import com.co.andresfot.veterinaria.model.entity.FacturaMedica;

public interface IFacturaMedicaService {

	public List<FacturaMedica> findCitaByIdWithFacturas(Long id);
	
}
