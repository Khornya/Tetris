package fr.formation.service;

import fr.formation.exception.PieceNotFoundException;
import fr.formation.models.Piece;

import java.util.ArrayList;
import java.util.List;

public class PieceService {
    private static int id = 1;
    private List<Piece> pieces;

    public List<Piece> findAll() {
        return this.pieces;
    }

    public void add(Piece piece) {
        if (this.pieces == null) {
            this.pieces = new ArrayList<>();
        }

        piece.setId(id++);
        this.pieces.add(piece);
    }

    public void edit(int id, Piece piece) {
        Piece pieceToEdit = this.findById(id);

        pieceToEdit.setName(piece.getName());
        pieceToEdit.setMatrix(piece.getMatrix());
    }

    public Piece findById(int id) {
        return this.pieces
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(PieceNotFoundException::new);
    }

    public void deleteById(int id) {
        this.pieces.removeIf(c -> c.getId() == id);
    }
}
