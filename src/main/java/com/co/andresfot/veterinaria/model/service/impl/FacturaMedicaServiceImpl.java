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
	@Transactional(readOnly = true)
	public List<FacturaMedica> findCitaByIdWithFacturas(Long id) {
		return facturaMedicaDao.fetchCitaByIdWithFacturas(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FacturaMedica findFacturaById(Long id) {
		return facturaMedicaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveFacturaMedica(FacturaMedica facturaMedica) {
		facturaMedicaDao.save(facturaMedica);
	}

}
