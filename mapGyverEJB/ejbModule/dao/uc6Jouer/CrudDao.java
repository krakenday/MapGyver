package dao.uc6Jouer;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.DaoParam;
import entity.uc6Jouer.JeuEntity;
import entity.uc6Jouer.JeuxEntity;

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

	public JeuxEntity listJeu() {
		JeuxEntity jeux = new JeuxEntity();
		for (Object resultjeuEntity : em.createQuery("select j from JeuEntity j").getResultList()) {
			jeux.add((JeuEntity) resultjeuEntity);
		}
		return jeux;
	}
}
