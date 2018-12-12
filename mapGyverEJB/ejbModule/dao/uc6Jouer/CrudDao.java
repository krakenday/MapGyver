package dao.uc6Jouer;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc6Jouer.Jeu;
import dao.DaoParam;
import dao.exception.uc6Jouer.ConvertionException;
import entity.uc6Jouer.JeuEntity;

/**
 * Permet la creation,la suppression d'une entity,les recherches
 * 
 * create {@link #createCrud(T aPersister) }
 * 
 * @author lours
 *
 */
@Singleton
@LocalBean
public class CrudDao {

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em;

	/**
	 * Permet la creation d'une Entity de façon generique
	 * 
	 * @param aPersister
	 */
	public <T> void createCrud(T aPersister) {
		em.persist(aPersister);
	}

	public JeuEntity getJeuById(int idJeu) {
		return em.find(JeuEntity.class, idJeu);
	}
}
