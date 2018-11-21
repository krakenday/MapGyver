package dao;

//import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.uc8Utilisateur.DaoFacadeUtilisateur;

@Singleton
@LocalBean
public class DaoFacade {

	@EJB
	private DaoFacadeUtilisateur daoFacadeUtilisateur;
	
	//Ici commence le territoire de Xander
		// Gestion de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) {
		daoFacadeUtilisateur.addUtilisateur(utilisateur);
	}
	
	public Utilisateur readUtilisateur(int id) {
		return daoFacadeUtilisateur.readUtilisateur(id);
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		daoFacadeUtilisateur.updateUtilisateur(utilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		daoFacadeUtilisateur.deleteUtilisateur(id);
	}
		// Catalogue de l'utilisateur
//	public List<Utilisateur> listeTousLesUtilisateurs(){
//		return daoFacadeUtilisateur.
//	}
		//Gestion Groupe et liste
	//Merci de votre visite
}
