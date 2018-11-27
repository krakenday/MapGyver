package dao.uc8Utilisateur;

import java.util.List;

import javax.ejb.EJB;

//import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.uc8Utilisateur.catalogue.DaoUtilisateurCatalogue;
import dao.uc8Utilisateur.gestion.DaoUtilisateurGestion;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoFacadeUtilisateur {

	@EJB
	DaoUtilisateurGestion daoGestion;
	
	@EJB
	DaoUtilisateurCatalogue daoCatalogue;
	
	FabriqueEntity fabriqueEntity= new FabriqueEntity();
	
	//Gestion de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) {
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		daoGestion.addUtilisateur(entityUtilisateur);
	}
	
	public Utilisateur readUtilisateur(int id) {
		EntityUtilisateur entityUtilisateur= daoGestion.readUtilisateur(id);
		Utilisateur utilisateur= fabriqueEntity.createUser(entityUtilisateur);
		return utilisateur;
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		daoGestion.updateUtilisateur(entityUtilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		daoGestion.deleteUtilisateur(id);
	}
	
	//Gestion du groupe
	public void addGroupe(Groupe groupe) {
		EntityGroupe entityGroupe= fabriqueEntity.creeEntityGroupe(groupe);
		daoGestion.addGroupe(entityGroupe);
	}
	public Groupe readGroupe(int id) {
		EntityGroupe entityGroupe= daoGestion.readGroupe(id);
		Groupe groupe= fabriqueEntity.creeGroupe(entityGroupe);
		return groupe;
	}
	
	public void updateGroupe(Groupe groupe) {
		EntityGroupe entityGroupe= fabriqueEntity.creeEntityGroupe(groupe);
		daoGestion.updateGroupe(entityGroupe);
	}
	
	public void deleteGroupe(int id) {
		daoGestion.deleteGroupe(id);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(ListeDiffusion listeDiff) {
		EntityListeDiffusion entityListeDiff= fabriqueEntity.creeEntityListeDiff(listeDiff);
		daoGestion.addListeDiff(entityListeDiff);
	}
	public ListeDiffusion readListeDiff(int id) {
		EntityListeDiffusion entityListeDiff= daoGestion.readListeDiff(id);
		ListeDiffusion listeDiff= fabriqueEntity.creeListeDiff(entityListeDiff);
		return listeDiff;
	}
	
	public void updateListeDiff(ListeDiffusion listeDiff) {
		EntityListeDiffusion entityListeDiff= fabriqueEntity.creeEntityListeDiff(listeDiff);
		daoGestion.updateListeDiff(entityListeDiff);
	}
	
	public void deleteListeDiff(int id) {
		daoGestion.deleteListeDiff(id);
	}
	
	//Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs() {
		
//		return daoCatalogue.listerTousLesUtilisateurs();
		return null;
	}

	public List<Groupe> listerTousLesGroupes() {
		
//		return daoCatalogue.listerTousLesGroupes();
		return null;
	}

	public List<ListeDiffusion> listerToutesLesListes() {
		
//		return daoCatalogue.listerToutesLesListes();
		return null;
	}

}
