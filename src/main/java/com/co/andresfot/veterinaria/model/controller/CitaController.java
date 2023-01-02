package com.co.andresfot.veterinaria.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.andresfot.veterinaria.model.entity.Cita;
import com.co.andresfot.veterinaria.model.entity.Mascota;
import com.co.andresfot.veterinaria.model.entity.Veterinario;
import com.co.andresfot.veterinaria.model.service.ICitaService;
import com.co.andresfot.veterinaria.model.service.IMascotaService;
import com.co.andresfot.veterinaria.model.service.IVeterinarioService;

@Controller
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService citaService;
	
	@Autowired
	private IMascotaService mascotaService;
	
	@Autowired
	private IVeterinarioService veterinarioService;

	@GetMapping("/listado-citas")
	public String listarCitas(Model model) {
		
		List<Cita> citas = citaService.findAllCitas();
		model.addAttribute("titulo", "Listado de citas");
		model.addAttribute("citas", citas);
		
		return "citas/listado-citas";
	}
	
	@GetMapping("/nueva-cita")
	private String nuevaCita(Model model) {
		
		List<Mascota> mascotas = mascotaService.findAllMascotas();
		List<Veterinario> veterinarios = veterinarioService.findAllVeterinarios();
		
		model.addAttribute("titulo", "Crear nueva cita");
		model.addAttribute("mascotas", mascotas);
		model.addAttribute("veterinarios", veterinarios);
		model.addAttribute("cita", new Cita());
		
		return "citas/nueva-cita";
	}
	
}
