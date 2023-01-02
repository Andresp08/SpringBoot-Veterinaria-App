package com.co.andresfot.veterinaria.model.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.co.andresfot.veterinaria.model.entity.Cita;
import com.co.andresfot.veterinaria.model.entity.Mascota;
import com.co.andresfot.veterinaria.model.entity.Veterinario;
import com.co.andresfot.veterinaria.model.service.ICitaService;
import com.co.andresfot.veterinaria.model.service.IMascotaService;
import com.co.andresfot.veterinaria.model.service.IVeterinarioService;

@Controller
@RequestMapping("/citas")
@SessionAttributes("cita")
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

	@PostMapping("/nueva-cita")
	private String guardarCita(@Valid Cita cita, BindingResult result, Model model,
			@RequestParam(name = "mascota", required = true) Long idMascota, 
			@RequestParam(name = "veterinario", required = true) Long idVeterinario,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			List<Mascota> mascotas = mascotaService.findAllMascotas();
			List<Veterinario> veterinarios = veterinarioService.findAllVeterinarios();

			model.addAttribute("titulo", "Crear nueva cita");
			model.addAttribute("mascotas", mascotas);
			model.addAttribute("veterinarios", veterinarios);
			model.addAttribute("cita", cita);
			return "citas/nueva-cita";
		}

		Mascota mascota = mascotaService.findMascotaById(idMascota);
		Veterinario veterinario = veterinarioService.findVeterinarioById(idVeterinario);

		cita.setMascota(mascota);
		cita.setVeterinario(veterinario);
		citaService.saveCita(cita);
		status.setComplete();
		flash.addFlashAttribute("success", "Cita creada con exito!!");

		return "redirect:/citas/listado-citas";
	}

}
