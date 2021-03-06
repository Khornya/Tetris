package fr.formation.model;

import javax.persistence.*;

@Entity
@Table(name="piece")
public class Piece {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	private int id;
	@Column(name="PRO_NOM", length = 50)
    private String name;

	@Column (name="PRO_MAT")
    private int[][] matrix;

    public Piece() {
    }

    public Piece(String name, int[][] matrix) {
        this.name = name;
        this.matrix = matrix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
