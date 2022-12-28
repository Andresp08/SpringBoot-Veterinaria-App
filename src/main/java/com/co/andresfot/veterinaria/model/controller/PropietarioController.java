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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.co.andresfot.veterinaria.model.entity.Propietario;
import com.co.andresfot.veterinaria.model.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService propietarioService;

	@GetMapping("/listado-propietarios")
	public String listarPropietarios(Model model) {

		List<Propietario> propietarios = propietarioService.findAllPropietarios();

		model.addAttribute("propietarios", propietarios);
		model.addAttribute("titulo", "Listado de propietarios");

		return "propietarios/listado-propietarios";
	}

	@GetMapping("/nuevo-propietario")
	public String agregarPropietario(Model model) {

		model.addAttribute("propietario", new Propietario());
		model.addAttribute("titulo", "Añadir propietario");

		return "propietarios/nuevo-propietario";
	}

	@PostMapping("/nuevo-propietario")
	public String guardarPropietario(@Valid Propietario propietario, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("propietario", propietario);
			model.addAttribute("titulo", "Añadir propietario");
			return "propietarios/nuevo-propietario";
		}

		propietarioService.savePropietario(propietario);
		status.setComplete();
		flash.addFlashAttribute("success", "El propietario fue añadido con exito!!");

		return "redirect:/propietarios/listado-propietarios";
	}

	@GetMapping("/editar-propietario/{id}")
	public String editarPropietario(@PathVariable Long id, Model model, RedirectAttributes flash) {

		Propietario propietario = null;

		if (id > 0) {
			propietario = propietarioService.findPropietarioById(id);

			if (propietario == null) {
				flash.addFlashAttribute("error", "El propietario no existe en la BBDD!!");
				return "redirect:/propietarios/listado-propietarios";
			}
		} else {
			flash.addFlashAttribute("error", "El propietario no existe en la BBDD!!");
			return "redirect:/propietarios/listado-propietarios";
		}

		model.addAttribute("titulo", "Editar propietario");
		model.addAttribute("propietario", propietario);

		return "propietarios/nuevo-propietario";
	}

	@GetMapping("/eliminar-propietario/{id}")
	public String eliminarPropietario(@PathVariable Long id, RedirectAttributes flash) {

		Propietario propietario = null;
		
		if (id > 0) {
			propietario = propietarioService.findPropietarioById(id);
			
			if (propietario == null) {
				flash.addFlashAttribute("error", "El propietario no existe en la BBDD!!");
				return "redirect:/propietarios/listado-propietarios";
			}
		} else {
			flash.addFlashAttribute("error", "El propietario no existe en la BBDD!!");
			return "redirect:/propietarios/listado-propietarios";
		}

		propietarioService.deletePropietarioById(propietario.getId());
		
		flash.addFlashAttribute("success", "El propietario fue eliminado con exito!!");

		return "redirect:/propietarios/listado-propietarios";
	}
}
