package com.co.andresfot.veterinaria.model.service;

import java.util.List;

import com.co.andresfot.veterinaria.model.entity.Mascota;

public interface IMascotaService {

	public List<Mascota> findAllMascotas();

	public Mascota findMascotaById(Long id);

	public void saveMascota(Mascota mascota);

	public void deleteMascotaById(Long id);

}
