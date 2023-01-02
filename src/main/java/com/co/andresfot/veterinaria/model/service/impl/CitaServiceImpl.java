package com.co.andresfot.veterinaria.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresfot.veterinaria.model.dao.ICitaDao;
import com.co.andresfot.veterinaria.model.entity.Cita;
import com.co.andresfot.veterinaria.model.service.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService{
	
	@Autowired
	private ICitaDao citaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findAllCitas() {
		return (List<Cita>) citaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cita findCitaById(Long id) {
		return citaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveCita(Cita cita) {
		citaDao.save(cita);
	}

	@Override
	@Transactional
	public void deleteCitaById(Long id) {
		citaDao.deleteById(id);
	}

	
}
