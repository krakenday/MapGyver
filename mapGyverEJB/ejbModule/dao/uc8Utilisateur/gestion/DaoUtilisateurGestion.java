package dao.uc8Utilisateur.gestion;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.DaoParam;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityUtilisateur;


@Singleton
@LocalBean
public class DaoUtilisateurGestion {
	
//DM	@PersistenceContext(unitName= DaoParamUtilisateur.CONTEXT_PERSISTANCE)
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em; 
	
	public void addUtilisateur(EntityUtilisateur entityUtilisateur) {
		System.out.println("***DM DaoUtilisateurGestion - addUtilisateur user : " + entityUtilisateur);
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
	
	//Gestion du groupe
	public void addGroupe(EntityGroupe entityGroupe) {
		em.persist(entityGroupe);
	}
	public EntityGroupe readGroupe(int id) {
		return em.find(EntityGroupe.class, id);
	}
	
	public void updateGroupe(EntityGroupe entityGroupe) {
		EntityGroupe groupe = em.find(EntityGroupe.class, entityGroupe.getId());
		em.merge(groupe);
	}
	
	public void deleteGroupe(int id) {
		em.remove(id);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(EntityListeDiffusion entityListeDiff) {
		em.persist(entityListeDiff);
	}
	public EntityListeDiffusion readListeDiff(int id) {
		return em.find(EntityListeDiffusion.class, id);
	}
	
	public void updateListeDiff(EntityListeDiffusion entityListeDiff) {
		EntityListeDiffusion listeDiff= em.find(EntityListeDiffusion.class, entityListeDiff.getId());
		em.merge(listeDiff);
	}
	
	public void deleteListeDiff(int id) {
		em.remove(id);
	}
}
