package dao.uc6Jouer;

import java.sql.SQLException;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

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
	public <T> void createCrud(T aPersister)
			throws SQLException, EJBTransactionRolledbackException, IllegalArgumentException, PersistenceException {
		try {
			em.persist(aPersister);
		} catch (RollbackException | ConstraintViolationException e) {
			System.out.println("c'est la bonne");
		}
	}

	public JeuEntity getJeuById(int idJeu)
			throws SQLException, EJBTransactionRolledbackException, IllegalArgumentException {

		return em.find(JeuEntity.class, idJeu);

	}

	public JeuxEntity listJeu() throws SQLException, EJBTransactionRolledbackException, IllegalArgumentException {
		JeuxEntity jeux = new JeuxEntity();
		for (Object resultjeuEntity : em.createQuery("select j from JeuEntity j").getResultList()) {
			jeux.add((JeuEntity) resultjeuEntity);
		}
		return jeux;
	}

	public void removeJeu(JeuEntity jeuEntity)
			throws SQLException, EJBTransactionRolledbackException, IllegalArgumentException {
		em.remove(jeuEntity);
	}
}
