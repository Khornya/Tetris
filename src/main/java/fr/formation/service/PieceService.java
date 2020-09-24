package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IPieceRepository;
import fr.formation.exception.PieceNotFoundException;
import fr.formation.model.Piece;

@Service
public class PieceService {
	@Autowired
	private IPieceRepository daoPiece; 
    //private static int id = 1; Géré un base de données -> auto increment
    //private List<Piece> pieces; Géré dans la dao

    public List<Piece> findAll() {
        return this.daoPiece.findAll();
    }

    public void add(Piece piece) {
        this.daoPiece.save(piece);       
    }

    public void edit(int id, Piece piece) {
        piece.setId(id);
        this.daoPiece.save(piece);
    }

    public Piece findById(int id) {
        return this.daoPiece.findById(id).orElseThrow(PieceNotFoundException::new);
               
    }

    public void deleteById(int id) {
        this.daoPiece.deleteById(id);
    }
}
