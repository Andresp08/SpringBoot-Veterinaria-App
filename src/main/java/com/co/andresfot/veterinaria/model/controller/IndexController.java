package com.co.andresfot.veterinaria.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"", "/", "/index", "/home"})
	public String paginaPrincipal(Model model) {
		
		model.addAttribute("titulo", "VetySystem - A tu servicio");
		
		return "index";
	}
	
}
