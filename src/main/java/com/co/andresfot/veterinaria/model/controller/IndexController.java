package com.co.andresfot.veterinaria.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"", "/", "/index", "/home"})
	public String paginaPrincipal() {
		return "index";
	}
	
}
