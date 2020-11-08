package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlador {

	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("mensaje", "Bienvenido a thymeleaf");
		
		return "index";
	}
}
