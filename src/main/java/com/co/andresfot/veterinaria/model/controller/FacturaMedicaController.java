package com.co.andresfot.veterinaria.model.controller;

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

import com.co.andresfot.veterinaria.model.entity.Cita;
import com.co.andresfot.veterinaria.model.entity.FacturaMedica;
import com.co.andresfot.veterinaria.model.service.ICitaService;
import com.co.andresfot.veterinaria.model.service.IFacturaMedicaService;

@Controller
@RequestMapping("/facturas")
@SessionAttributes("facturaMedica")
public class FacturaMedicaController {
	
	@Autowired
	private IFacturaMedicaService facturaMedicaService;
	
	@Autowired
	private ICitaService citaService;

	@GetMapping("/emitir-factura/{id}")
	public String crearFactura(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		Cita cita = null;
		
		if (id > 0) {
			cita = citaService.findCitaById(id);

			if (cita == null) {
				flash.addFlashAttribute("error", "La factura no existe en la BBDD!!");
				return "redirect:/index";
			}
		} else {
			flash.addFlashAttribute("error", "El post no existe en la BBDD!!");
			return "redirect:/index";
		}
		
		FacturaMedica facturaMedica = new FacturaMedica();
		facturaMedica.setCita(cita);
		
		model.addAttribute("titulo", "Nueva Factura");
		model.addAttribute("cita", cita);
		model.addAttribute("facturaMedica", facturaMedica);
		return "facturas/emitir-factura";
	}
	
	@PostMapping("/guardar-factura")
	public String guardarFactura(@Valid FacturaMedica facturaMedica, BindingResult result, 
			Model model, SessionStatus status, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nueva Factura");
			model.addAttribute("facturaMedica", facturaMedica);
			return "facturas/emitir-factura";
		}
		
		facturaMedicaService.saveFacturaMedica(facturaMedica);
		status.setComplete();
		flash.addFlashAttribute("success", "Factura medica guardada con exito!!");
		
		return "redirect:/citas/detalle-cita/" + facturaMedica.getCita().getId();
	}
	
}
