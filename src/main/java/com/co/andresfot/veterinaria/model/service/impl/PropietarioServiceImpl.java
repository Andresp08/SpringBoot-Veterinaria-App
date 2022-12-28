package com.co.andresfot.veterinaria.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresfot.veterinaria.model.dao.IPropietarioDao;
import com.co.andresfot.veterinaria.model.entity.Propietario;
import com.co.andresfot.veterinaria.model.service.IPropietarioService;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioDao propietarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Propietario> findAllPropietarios() {
		return (List<Propietario>) propietarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Propietario findPropietarioById(Long id) {
		return propietarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void savePropietario(Propietario propietario) {
		propietarioDao.save(propietario);
	}

	@Override
	@Transactional
	public void deletePropietarioById(Long id) {
		propietarioDao.deleteById(id);
	}
	
}
