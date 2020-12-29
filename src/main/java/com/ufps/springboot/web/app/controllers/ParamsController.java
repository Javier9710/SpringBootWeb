package com.ufps.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

	@GetMapping("/")
	public String index() {
		
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "Cualquier Cosa")String texto,Model model) {
		
		model.addAttribute("resultado", "el texto es : "+texto);
		return "params/ver";
		
	}
	
	@GetMapping("/mix")
	public String param(@RequestParam String saludo,@RequestParam Integer numero,Model  model) {
		
		model.addAttribute("resultado", "'el Saludo es : '"+saludo+" 'y el numero es: '"+ numero);
		return "params/ver";
		
	}
	
	@GetMapping("/mix-http")
	public String param(HttpServletRequest request,Model  model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero=0;// TODO: handle exception
		}
		
		model.addAttribute("resultado", "el Saludo es : '"+saludo+"' y el numero es: '"+ numero+"'");
		return "params/ver";
		
	}
}
