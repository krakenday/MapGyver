package dao.uc8Utilisateur.gestion;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.uc8Utilisateur.DaoParamUtilisateur;
import entity.uc8Utilisateur.EntityUtilisateur;


@Singleton
@LocalBean
public class DaoUtilisateurGestion {
	
	@PersistenceContext(unitName= DaoParamUtilisateur.CONTEXT_PERSISTANCE)
	EntityManager em; 
	
	public void addUtilisateur(EntityUtilisateur entityUtilisateur) {
			em.persist(entityUtilisateur);
	}
	
	public EntityUtilisateur readUtilisateur(int id) {
		return em.find(EntityUtilisateur.class, id);
	}
	
	public void updateUtilisateur(EntityUtilisateur entityUtilisateur) {
		EntityUtilisateur utilisateur= em.find(EntityUtilisateur.class, entityUtilisateur.getId());
		em.merge(utilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		em.remove(id);
	}
	
}
