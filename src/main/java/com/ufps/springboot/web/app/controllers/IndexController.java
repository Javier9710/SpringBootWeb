package com.ufps.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufps.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/","","home"})
	public String index(Model model,ModelMap model1, Map<String,Object> map, ModelAndView mv) {
		
		model.addAttribute("titulo", textoIndex);
		model1.addAttribute("titulo1", "Hola Spring Framework!----ModelMap");
		map.put("titulo2", "Hola Spring Framework!----Map" );
		mv.addObject("titulo3", "Hola Spring Framework!----MapAndView");
		mv.setViewName("index");
		return "index";
	}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Javier");
		usuario.setApellido("Moncada");
		usuario.setEmail("javier@Ufps.edu.co");
		model.addAttribute("usuario", usuario);
		
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> pasarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>() ;
		usuarios.add(new Usuario("Camilo","Moncada","camilo@gmail.com"));
		usuarios.add(new Usuario("jean","Moncada","jean@gmail.com"));
		usuarios.add(new Usuario("Mafer","Moncada","mafer@gmail.com"));
	
		return usuarios;
	}
	

}
