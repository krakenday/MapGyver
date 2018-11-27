package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
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
