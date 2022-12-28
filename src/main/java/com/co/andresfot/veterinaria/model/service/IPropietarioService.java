package com.co.andresfot.veterinaria.model.service;

import java.util.List;

import com.co.andresfot.veterinaria.model.entity.Propietario;

public interface IPropietarioService {

	public List<Propietario> findAllPropietarios();

	public Propietario findPropietarioById(Long id);

	public void savePropietario(Propietario propietario);

	public void deletePropietarioById(Long id);

}
