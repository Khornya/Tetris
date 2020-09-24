package fr.formation.controller;

import fr.formation.model.Piece;
import fr.formation.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private PieceService pieceService;

	@GetMapping
	public String Home(Model model) {
		return "home";		
	}

	@PostMapping
	public String startGame(Model model) {
		List<Piece> pieces = pieceService.findAll();
		model.addAttribute("pieces", pieces);
		if (pieces.isEmpty()) return "redirect:./piece/add";
		return "home";
	}
}
