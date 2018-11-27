package dao.uc8Utilisateur.catalogue;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.uc8Utilisateur.DaoParamUtilisateur;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoUtilisateurCatalogue {

	@PersistenceContext(unitName= DaoParamUtilisateur.CONTEXT_PERSISTANCE)
	EntityManager em; 
	
	public List<EntityUtilisateur> listerTousLesUtilisateurs() {
		ArrayList<EntityUtilisateur> liste = new ArrayList<EntityUtilisateur>();

		for (Object u : em.createQuery("select u from EntityUtilisateur u order by u.nom asc").getResultList())
		{   
			if (u instanceof EntityUtilisateur) {
				liste.add((EntityUtilisateur)u);
			}
		}
		return liste;
	}

	public List<EntityGroupe> listerTousLesGroupes() {
		ArrayList<EntityGroupe> liste = new ArrayList<EntityGroupe>();

		for (Object g : em.createQuery("select g from EntityGroupe g order by g.nom asc").getResultList())
		{   
			if (g instanceof EntityGroupe) {
				liste.add((EntityGroupe)g);
			}
		}
		return liste;
	}

	public List<EntityListeDiffusion> listerToutesLesListes() {
		ArrayList<EntityListeDiffusion> liste = new ArrayList<EntityListeDiffusion>();

		for (Object l : em.createQuery("select l from EntityListeDiffusion l order by u.nom asc").getResultList())
		{   
			if (l instanceof EntityListeDiffusion) {
				liste.add((EntityListeDiffusion)l);
			}
		}
		return liste;
	}
}
