package com.co.andresfot.veterinaria.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresfot.veterinaria.model.dao.IVeterinarioDao;
import com.co.andresfot.veterinaria.model.entity.Veterinario;
import com.co.andresfot.veterinaria.model.service.IVeterinarioService;

@Service
public class VeterinarioServiceImpl implements IVeterinarioService{

	@Autowired
	private IVeterinarioDao veterinarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Veterinario> findAllVeterinarios() {
		return (List<Veterinario>) veterinarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Veterinario findVeterinarioById(Long id) {
		return veterinarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveVeterinario(Veterinario veterinario) {
		veterinarioDao.save(veterinario);
	}

	@Override
	@Transactional
	public void deleteVeterinarioById(Long id) {		 
		veterinarioDao.deleteById(id);
	}

}
