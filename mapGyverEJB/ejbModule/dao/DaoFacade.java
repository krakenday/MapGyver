package dao;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.uc1Administrer.DaoFacadeAdmin;
import service.exception.uc1Administrer.ServiceInexistantException;

@Singleton
@LocalBean
public class DaoFacade {
	
	@EJB
	private DaoFacadeAdmin daoFacadeAdmin;
	
	@EJB
	private DaoFacadeUtilisateur daoFacadeUtilisateur;

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserById(id);
		}
		catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		
		return user;
	}

	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserByEmail(email);
		}
		catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		
		return user;
	}
	
	//Ici commence le territoire de Djallel
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
	
	//Gestion du groupe
	public void addGroupe(Groupe groupe) {
		daoFacadeUtilisateur.addGroupe(groupe);
	}
	public Groupe readGroupe(int id) {
		return daoFacadeUtilisateur.readGroupe(id);
	}
	
	public void updateGroupe(Groupe groupe) {
		daoFacadeUtilisateur.updateGroupe(groupe);
	}
	
	public void deleteGroupe(int id) {
		daoFacadeUtilisateur.deleteGroupe(id);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(ListeDiffusion listeDiff) {
		daoFacadeUtilisateur.addListeDiff(listeDiff);
	}
	public ListeDiffusion readListeDiff(int id) {
		return daoFacadeUtilisateur.readListeDiff(id);
	}
	
	public void updateListeDiff(ListeDiffusion listeDiff) {
		daoFacadeUtilisateur.updateListeDiff(listeDiff);
	}
	
	public void deleteListeDiff(int id) {
		daoFacadeUtilisateur.deleteListeDiff(id);
	}
	
	//Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	public List<Groupe> listerTousLesGroupes() {
		return daoFacadeUtilisateur.listerTousLesGroupes();
	}

	public List<ListeDiffusion> listerToutesLesListes() {
		return daoFacadeUtilisateur.listerToutesLesListes();
	}
	//Merci de votre visite
}
