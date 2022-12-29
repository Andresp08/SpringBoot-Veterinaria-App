package com.co.andresfot.veterinaria.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.andresfot.veterinaria.model.entity.Mascota;
import com.co.andresfot.veterinaria.model.service.IMascotaService;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

	@Autowired
	private IMascotaService mascotaService;
	
	@GetMapping("/listado-mascotas")
	public String listadoMascotas(Model model) {
		
		List<Mascota> mascotas = mascotaService.findAllMascotas();
		model.addAttribute("titulo", "Listado de mascotas");
		model.addAttribute("mascotas", mascotas);
		
		return "mascotas/listado-mascotas";
	}
	
}
