package fr.formation.controller;

import fr.formation.model.Piece;
import fr.formation.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/piece")
public class PieceController {
    @Autowired
    private PieceService pieceService;

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("pieces", this.pieceService.findAll());

        return "list";
    }

    @GetMapping("/add")
    public String add() {
        return "form";
    }

    @PostMapping("/add")
    public String add(Piece piece) {
        this.pieceService.add(piece);

        return "redirect:./list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("piece", this.pieceService.findById(id));

        return "form";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, Piece piece) {
        this.pieceService.edit(id, piece);

        return "redirect:./list";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        this.pieceService.deleteById(id);

        return "redirect:../list";
    }
}
