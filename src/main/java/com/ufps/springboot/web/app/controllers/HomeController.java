package com.ufps.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		//return "redirect:/app/index";
		//return "redirect:https://www.google.com";
		return "forward:/app/index";
		
	}
}
