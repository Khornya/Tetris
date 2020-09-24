package fr.formation.controller;

import fr.formation.model.Piece;
import fr.formation.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public List<Piece> startGame(Model model) {
		return pieceService.findAll();
	}
}
