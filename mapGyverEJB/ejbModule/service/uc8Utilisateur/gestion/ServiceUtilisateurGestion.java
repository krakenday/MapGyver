package service.uc8Utilisateur.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceUtilisateurGestion  {
	
	@EJB
	private DaoFacade daoFacade;

	// Bloc utilisateur
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
	
	//Bloc groupe
	public void createGroupe(Groupe groupe) {
		daoFacade.addGroupe(groupe);
	}

	public Groupe readGroupe(int id) {
		return daoFacade.readGroupe(id);
	}

	public void updateGroupe(Groupe groupe) {
		daoFacade.updateGroupe(groupe);
	}

	public void deleteGroupe(int id) {
		daoFacade.deleteGroupe(id);
	}
	
	// Bloc service Liste diffusion
	public void createListeDiff(ListeDiffusion listeDiff) {
		daoFacade.addListeDiff(listeDiff);
	}

	public ListeDiffusion readListeDiff(int id) {
		return daoFacade.readListeDiff(id);
	}
	
	public void updateListeDiff(ListeDiffusion listeDiff) {
		daoFacade.updateListeDiff(listeDiff);
	}

	public void deleteListeDiff(int id) {
		daoFacade.deleteListeDiff(id);
	}
}
