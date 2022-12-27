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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.co.andresfot.veterinaria.model.entity.Veterinario;
import com.co.andresfot.veterinaria.model.service.IVeterinarioService;

@Controller
@RequestMapping("/veterinarios")
@SessionAttributes("veterinario")
public class VeterinarioController {

	@Autowired
	private IVeterinarioService veterinarioService;

	@GetMapping("/listado-veterinarios")
	public String listadoVeterinarios(Model model) {

		List<Veterinario> veterinarios = veterinarioService.findAllVeterinarios();
		model.addAttribute("titulo", "Listado de veterinarios");
		model.addAttribute("veterinarios", veterinarios);

		return "veterinarios/listado-veterinarios";
	}

	@GetMapping("/nuevo-veterinario")
	public String añadirVeterinario(Model model) {

		model.addAttribute("titulo", "Añadir nuevo veterinario");
		model.addAttribute("veterinario", new Veterinario());

		return "veterinarios/nuevo-veterinario";
	}

	@PostMapping("/nuevo-veterinario")
	public String guardarVeterinario(@Valid Veterinario veterinario, BindingResult result, Model model,
			SessionStatus status, RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Añadir nuevo veterinario");
			model.addAttribute("veterinario", veterinario);
			return "veterinarios/nuevo-veterinario";
		}

		veterinarioService.saveVeterinario(veterinario);
		status.setComplete();
		flash.addFlashAttribute("success", "Veterinario guardado con exito!!");

		return "redirect:/veterinarios/listado-veterinarios";
	}

	@GetMapping("/editar-veterinario/{id}")
	public String editarVeterinario(@PathVariable Long id, Model model, RedirectAttributes flash) {

		Veterinario veterinario = null;

		if (id > 0) {
			veterinario = veterinarioService.findVeterinarioById(id);

			if (veterinario == null) {
				flash.addFlashAttribute("error", "El veterinario no existe en la BBDD!!");
				return "redirect:/veterinarios/listado-veterinarios";
			}
		} else {
			flash.addFlashAttribute("error", "El veterinario no existe en la BBDD!!");
			return "redirect:/veterinarios/listado-veterinarios";
		}

		model.addAttribute("veterinario", veterinario);

		return "veterinarios/nuevo-veterinario";
	}

	@GetMapping("/eliminar-veterinario/{id}")
	public String eliminarVeterinario(@PathVariable Long id, RedirectAttributes flash) {

		if (id > 0) {
			veterinarioService.deleteVeterinarioById(id);
		} else {
			flash.addFlashAttribute("error", "El veterinario no existe en la BBDD!!");
			return "redirect:/veterinarios/listado-veterinarios";
		}

		flash.addFlashAttribute("success", "El veterinario fue eliminado con exito!!");
		return "redirect:/veterinarios/listado-veterinarios";
	}
}
