package com.co.andresfot.veterinaria.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresfot.veterinaria.model.dao.IMascotaDao;
import com.co.andresfot.veterinaria.model.entity.Mascota;
import com.co.andresfot.veterinaria.model.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private IMascotaDao mascotaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Mascota> findAllMascotas() {
		return (List<Mascota>) mascotaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mascota findMascotaById(Long id) {
		return mascotaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveMascota(Mascota mascota) { 
		mascotaDao.save(mascota);
	}

	@Override
	@Transactional
	public void deleteMascotaById(Long id) {
		mascotaDao.deleteById(id);
	}

}
