package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping
	public String Home(@RequestParam int id, Model model) {
		//model.addAttribute("azz", id);
		return "home";		
	}
	@PostMapping
	public String postHome() {
		return "redirect:/home";
	}
}
