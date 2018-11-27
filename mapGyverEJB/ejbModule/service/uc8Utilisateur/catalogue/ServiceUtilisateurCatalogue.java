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
	
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacade.listerTousLesUtilisateurs();
	}

	public List<Groupe> listerTousLesGroupes() {
		return daoFacade.listerTousLesGroupes();
	}

	public List<ListeDiffusion> listerToutesLesListes() {
		return daoFacade.listerToutesLesListes();
	}
}
