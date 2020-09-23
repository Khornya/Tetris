package fr.formation.dao;

import java.util.List;

import fr.formation.model.Piece;

public interface IPieceDao extends IDAO<Piece>{
	public List<Piece> findAll();
}