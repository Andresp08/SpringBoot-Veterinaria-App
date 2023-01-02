package com.co.andresfot.veterinaria.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_cita")
	@FutureOrPresent(message = "La fecha de la cita no puede ser inferior al día de hoy")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCita;

	@NotEmpty(message = "El campo no puede ir vacio")
	@NotBlank(message = "El campo no puede ir con espacios en blanco")
	private String diagnostico;

	@NotNull(message = "El valor no puede ir vacio")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_mascota")
	private Mascota mascota;

	@ManyToOne
	@JoinColumn(name = "id_veterinario")
	private Veterinario veterinario;

	@OneToMany(mappedBy = "cita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FacturaMedica> facturasMedicas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public List<FacturaMedica> getFacturasMedicas() {
		return facturasMedicas;
	}

	public void setFacturasMedicas(List<FacturaMedica> facturasMedicas) {
		this.facturasMedicas = facturasMedicas;
	}

}
