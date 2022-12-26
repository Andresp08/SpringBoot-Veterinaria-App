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
@Table(name = "propietarios")
public class Propietario implements Serializable {

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
	private String direccion;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String correo;

	@OneToMany(mappedBy = "propietario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Mascota> mascotas;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}
