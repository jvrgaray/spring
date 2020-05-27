package com.bolsadeideas.springboot.form.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Javier");
		usuario.setApellido("Garay");
		usuario.setId("123456789");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			/*Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("errores", errores);*/
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		return "resultado";
	}
}