package fr.formation.models;

public class Piece {
    private String name;
    private int[][] matrix;

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
}
