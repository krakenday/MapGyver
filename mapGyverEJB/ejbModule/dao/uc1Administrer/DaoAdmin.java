package dao.uc1Administrer;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import dao.exception.uc1Administrer.DaoInexistantException;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoAdmin {

	@PersistenceContext(unitName=DaoParamAdmin.CONTEXT_PERSISTANCE)
	private EntityManager 		em;

	/**
	 * Retourne EntityUtilisateur par id
	 * si pas trouve : new InexistantException()
	 * @throws DaoInexistantException 
	 */
	public EntityUtilisateur getUserById(int id) throws DaoInexistantException {

		EntityUtilisateur user = null;
		try { 
			user = em.find(EntityUtilisateur.class, id);
		} catch (PersistenceException e) {				
			// recherche de la cause
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof NoResultException)) {
				t = t.getCause();
			}
			if (t instanceof NoResultException) {
				throw new DaoInexistantException();
			}			
		}
		if (user == null) throw new DaoInexistantException();
		return user;
	}
}
