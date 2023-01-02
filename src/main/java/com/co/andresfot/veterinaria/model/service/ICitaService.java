package com.co.andresfot.veterinaria.model.service;

import java.util.List;

import com.co.andresfot.veterinaria.model.entity.Cita;

public interface ICitaService {
	
	public List<Cita> findAllCitas();

	public Cita findCitaById(Long id);

	public void saveCita(Cita cita);

	public void deleteCitaById(Long id);

}
