package com.co.andresfot.veterinaria.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.andresfot.veterinaria.model.entity.Mascota;

public interface IMascotaDao extends CrudRepository<Mascota, Long> {

}
