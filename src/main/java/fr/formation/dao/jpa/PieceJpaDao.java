package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IPieceDao;
import fr.formation.model.Piece;

@Repository
public class PieceJpaDao implements IPieceDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Piece> findAll() {
		return em.createQuery("select p from Produit p", Piece.class)
				.getResultList();
	}

	@Override
	public Piece findById(int id) {
//		return em.createQuery("select p from Produit p where p.id = ?", Produit.class)
//				.setParameter(1, id)
//				.getSingleResult();
		
		return em.find(Piece.class, id);
	}

	@Override
	@Transactional
	public Piece save(Piece entity) {
		if (entity.getId() == 0) { //AJOUT
			em.persist(entity);
		}
		
		else { //UPDATE
			entity = em.merge(entity);
		}
		
		return entity;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		em.createQuery("delete from Piece p where p.id = ?")
			.setParameter(1, id)
			.executeUpdate();
		
//		em.remove(this.findById(id));
	}

	/*@Override
	public List<Piece> findByPieceId(int Id) {
		return em.createQuery("select p from Produit p where p.fournisseur.id = ?", Piece.class)
				.setParameter(1, fournisseurId)
				.getResultList();
	}*/
}
