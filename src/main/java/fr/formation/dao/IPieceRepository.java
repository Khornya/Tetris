package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Piece;


public interface IPieceRepository extends JpaRepository<Piece, Integer>{

}
