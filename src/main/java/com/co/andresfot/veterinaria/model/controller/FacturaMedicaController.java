package com.co.andresfot.veterinaria.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facturas")
public class FacturaMedicaController {

	@GetMapping("/emitir-factura/{id}")
	public String crearFactura(Model model) {
		model.addAttribute("titulo", "Nueva Factura");
		return "facturas/emitir-factura";
	}
	
}
