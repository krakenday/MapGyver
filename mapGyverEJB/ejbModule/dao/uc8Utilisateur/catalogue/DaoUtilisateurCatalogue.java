package dao.uc8Utilisateur.catalogue;

import java.util.ArrayList;
import java.util.List;

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
public class DaoUtilisateurCatalogue {

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em; 
	
	// Liste de tous les utilisateurs de l'application
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

	/**
	 * 
	 * @param id est l'identifiant de l'utilisateur
	 * @return liste des groupes de l'utilisateur
	 */
	public List<EntityGroupe> listerTousLesGroupes(int id) {
		System.out.println("************ DaoUtilisateur - listerLesGroupes ***********");
		ArrayList<EntityGroupe> liste = new ArrayList<EntityGroupe>();
		for (Object g : em.createQuery("select g from EntityGroupe g where g.utilisateur.id=?1 order by g.nom asc").setParameter(1, id).getResultList())
		{   
			if (g instanceof EntityGroupe) {
				liste.add((EntityGroupe)g);
			}
		}
		return liste;
	}

	/**
	 * 
	 * @param id est l'identifiant de l'utilisateur
	 * @return liste des liste de diffusion de l'utilisateur
	 */
	public List<EntityListeDiffusion> listerToutesLesListes(int id) {
		System.out.println("************ DaoUtilisateur - listerLesGroupes ***********");
		ArrayList<EntityListeDiffusion> liste = new ArrayList<EntityListeDiffusion>();
		for (Object l : em.createQuery("select l from EntityListeDiffusion l where l.utilisateur.id=?1 order by l.nom asc").setParameter(1, id).getResultList())
		{   
			if (l instanceof EntityListeDiffusion) {
				liste.add((EntityListeDiffusion)l);
			}
		}
		return liste;
	}
}
