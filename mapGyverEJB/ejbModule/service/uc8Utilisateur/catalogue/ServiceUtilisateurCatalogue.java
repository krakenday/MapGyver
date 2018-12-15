package service.uc8Utilisateur.catalogue;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceUtilisateurCatalogue {

	@EJB
	private DaoFacade daoFacade;
	
	/**
	 * 
	 * @return une liste d'utilisateurs
	 */
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacade.listerTousLesUtilisateurs();
	}

	/**
	 * 
	 * @param id est l'identifiant d'un utilisateur
	 * @return la liste de groupe d'un utilisateur triée par nom
	 */
	public List<Groupe> listerTousLesGroupes(int id) {
		return daoFacade.listerTousLesGroupes(id);
	}
	
	/**
	 * 
	 * @param id est l'identifiant d'un utilisateur
	 * @return la liste des liste de diffusion d'un utilisateur triée par nom
	 */
	public List<ListeDiffusion> listerToutesLesListes(int id) {
		return daoFacade.listerToutesLesListes(id);
	}
}
