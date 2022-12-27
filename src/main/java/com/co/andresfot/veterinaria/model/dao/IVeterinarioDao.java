package com.co.andresfot.veterinaria.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.andresfot.veterinaria.model.entity.Veterinario;

public interface IVeterinarioDao extends CrudRepository<Veterinario, Long>{

}
