package com.co.andresfot.veterinaria.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "facturas_medicas")
public class FacturaMedica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String medicamento;

	@NotNull(message = "El precio no puede ir vacio")
	private Double precio;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String dosis;

	@ManyToOne
	@JoinColumn(name = "id_cita")
	private Cita cita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}
