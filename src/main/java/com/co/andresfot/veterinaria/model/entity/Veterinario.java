package com.co.andresfot.veterinaria.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "veterinarios")
public class Veterinario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String nombre;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String telefono;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String especialidad;

	@OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cita> citas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
