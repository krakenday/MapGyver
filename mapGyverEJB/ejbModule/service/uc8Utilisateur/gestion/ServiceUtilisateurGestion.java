package service.uc8Utilisateur.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceUtilisateurGestion  {
	
	@EJB
	private DaoFacade daoFacade;

	
	public void create(Utilisateur utilisateur) {
		daoFacade.addUtilisateur(utilisateur);
	}

	
	public Utilisateur read(int id) {
		return daoFacade.readUtilisateur(id);
	}

	
	public void update(Utilisateur utilisateur) {
		daoFacade.updateUtilisateur(utilisateur);
		
	}

	
	public void delete(int id) {
		daoFacade.deleteUtilisateur(id);
	}



}
