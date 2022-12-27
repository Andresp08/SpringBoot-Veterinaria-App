package com.co.andresfot.veterinaria.model.service;

import java.util.List;

import com.co.andresfot.veterinaria.model.entity.Veterinario;

public interface IVeterinarioService {

	public List<Veterinario> findAllVeterinarios();

	public Veterinario findVeterinarioById(Long id);

	public void saveVeterinario(Veterinario veterinario);

	public void deleteVeterinarioById(Long id);

}
