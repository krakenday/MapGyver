package dao.uc8Utilisateur.gestion;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import dao.DaoParam;
import dao.exception.uc8Utilisateur.DaoUtilisateurExistantException;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityUtilisateur;


@Singleton
@LocalBean
public class DaoUtilisateurGestion {
	
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em; 
	
	//Gestion de l'utilisateur
	public void addUtilisateur(EntityUtilisateur entityUtilisateur) throws DaoUtilisateurExistantException {
		try {
			em.persist(entityUtilisateur);
			em.flush();
		} catch (PersistenceException e) {
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
				t = t.getCause();
			}
			if (t instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("************ DaoUtilisateur - exception ");
				throw new DaoUtilisateurExistantException();
			}
		}	
	}
	
	public EntityUtilisateur readUtilisateur(int id) {
		EntityUtilisateur utilisateur= em.find(EntityUtilisateur.class, id);
		return utilisateur;
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateUtilisateur(EntityUtilisateur entityUtilisateur) {
		EntityUtilisateur utilisateur= em.find(EntityUtilisateur.class, entityUtilisateur.getId());
		em.merge(utilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		EntityUtilisateur utilisateur= em.find(EntityUtilisateur.class, id);
		System.out.println("*************** DaoUtilisateur" + utilisateur.toString());
		em.remove(utilisateur);
	}
	
	//Gestion du groupe
	public void addGroupe(EntityGroupe entityGroupe) {
		em.persist(entityGroupe);
		em.flush();
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public EntityGroupe readGroupe(int id) {
		EntityGroupe groupe= em.find(EntityGroupe.class, id);
		return groupe;
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateGroupe(EntityGroupe entityGroupe) {
		EntityGroupe groupe = em.find(EntityGroupe.class, entityGroupe.getId());
		em.merge(groupe);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteGroupe(int id) {
		EntityGroupe groupe= em.find(EntityGroupe.class, id);
		em.remove(groupe);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(EntityListeDiffusion listeDiff) {
		em.persist(listeDiff);
		em.flush();
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public EntityListeDiffusion readListeDiff(int id) {
		EntityListeDiffusion listeDiff= em.find(EntityListeDiffusion.class, id);
		return listeDiff ;
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateListeDiff(EntityListeDiffusion entityListeDiff) {
		EntityListeDiffusion listeDiff= em.find(EntityListeDiffusion.class, entityListeDiff.getId());
		em.merge(listeDiff);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteListeDiff(int id) {
		EntityListeDiffusion listeDiff= em.find(EntityListeDiffusion.class, id);
		em.remove(listeDiff);
	}
}
