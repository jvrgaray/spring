package com.bolsaideas.springboot.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "hola spring framework");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Javier");
		usuario.setApellido("Garay");
		// usuario.setEmail("jvrgaray@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		/*
		 * List<Usuario> usuarios = new ArrayList<>(); usuarios.add(new
		 * Usuario("Javier", "Garay", "jvrgaray@gmail.com")); usuarios.add(new
		 * Usuario("Sandra", "Pineda", "spineda08@gmail.com"));
		 */
		List<Usuario> usuarios = Arrays.asList(new Usuario("Javier", "Garay", "jvrgaray@gmail.com"),
				new Usuario("Sandra", "Pineda", "spineda08@gmail.com"));

		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);

		return "listar";
	}
}
