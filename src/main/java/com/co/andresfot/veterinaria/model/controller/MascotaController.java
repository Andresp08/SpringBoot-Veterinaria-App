package com.co.andresfot.veterinaria.model.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.co.andresfot.veterinaria.model.entity.Mascota;
import com.co.andresfot.veterinaria.model.entity.Propietario;
import com.co.andresfot.veterinaria.model.service.IMascotaService;
import com.co.andresfot.veterinaria.model.service.IPropietarioService;

@Controller
@RequestMapping("/mascotas")
@SessionAttributes("mascota")
public class MascotaController {

	@Autowired
	private IMascotaService mascotaService;

	@Autowired
	private IPropietarioService propietarioService;

	@GetMapping("/listado-mascotas")
	public String listadoMascotas(Model model) {

		List<Mascota> mascotas = mascotaService.findAllMascotas();
		model.addAttribute("titulo", "Listado de mascotas");
		model.addAttribute("mascotas", mascotas);

		return "mascotas/listado-mascotas";
	}

	@GetMapping("/nueva-mascota")
	public String agregarMascota(Model model) {

		List<Propietario> propietarios = propietarioService.findAllPropietarios();
		model.addAttribute("titulo", "Agregar mascota");
		model.addAttribute("propietarios", propietarios);
		model.addAttribute("mascota", new Mascota());

		return "mascotas/nueva-mascota";
	}
	
	@PostMapping("/nueva-mascota")
	public String guardarMascota(@Valid Mascota mascota, BindingResult result, Model model,  
			@RequestParam(name = "propietario") Long id, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			List<Propietario> propietarios = propietarioService.findAllPropietarios();
			model.addAttribute("titulo", "Agregar mascota");
			model.addAttribute("propietarios", propietarios);
			model.addAttribute("mascota", mascota);
			return "mascotas/nueva-mascota";
		}
		
		Propietario propietario = propietarioService.findPropietarioById(id);
		mascota.setPropietario(propietario);
		mascotaService.saveMascota(mascota);
		status.setComplete();
		flash.addFlashAttribute("success", "Mascota guardada con exito!!");
		
		
		return "redirect:/mascotas/listado-mascotas";
	}
	
	@GetMapping("/editar-mascota/{id}")
	public String editarMascota(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		List<Propietario> propietarios = propietarioService.findAllPropietarios();
		Mascota mascota = null;
		
		if(id > 0) {
			mascota = mascotaService.findMascotaById(id);
			
			if(mascota == null) {
				flash.addFlashAttribute("error", "La mascota no existe en la BBDD!!");
				return "redirect:/mascotas/listado-mascotas";
			}
		} else {
			flash.addFlashAttribute("error", "La mascota no existe en la BBDD!!");
			return "redirect:/mascotas/listado-mascotas";
		}
		
		model.addAttribute("titulo", "Editar Mascota");
		model.addAttribute("propietarios", propietarios);
		model.addAttribute("mascota", mascota);
		
		return "mascotas/nueva-mascota";
	}
	
	@GetMapping("/eliminar-mascota/{id}")
	public String eliminarMascota(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		Mascota mascota = null;
		
		if(id > 0) {
			mascota = mascotaService.findMascotaById(id);
			
			if(mascota == null) {
				flash.addFlashAttribute("error", "La mascota no existe en la BBDD!!");
				return "redirect:/mascotas/listado-mascotas";
			}
		} else {
			flash.addFlashAttribute("error", "La mascota no existe en la BBDD!!");
			return "redirect:/mascotas/listado-mascotas";
		}
		
		mascotaService.deleteMascotaById(mascota.getId());
		
		return "redirect:/mascotas/listado-mascotas";
	}

}
