package com.co.andresfot.veterinaria.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresfot.veterinaria.model.dao.IFacturaMedicaDao;
import com.co.andresfot.veterinaria.model.entity.FacturaMedica;
import com.co.andresfot.veterinaria.model.service.IFacturaMedicaService;

@Service
public class FacturaMedicaServiceImpl implements IFacturaMedicaService {

	@Autowired
	private IFacturaMedicaDao facturaMedicaDao;
	
	@Override
	@Transactional
	public List<FacturaMedica> findCitaByIdWithFacturas(Long id) {
		return facturaMedicaDao.fetchCitaByIdWithFacturas(id);
	}

}
