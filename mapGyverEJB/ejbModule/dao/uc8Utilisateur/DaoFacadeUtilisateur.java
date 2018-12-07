package dao.uc8Utilisateur;

import java.util.List;

import javax.ejb.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc8Utilisateur.DaoUtilisateurExistantException;
import dao.uc8Utilisateur.catalogue.DaoUtilisateurCatalogue;
import dao.uc8Utilisateur.gestion.DaoUtilisateurGestion;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoFacadeUtilisateur {

	@EJB
	private DaoUtilisateurGestion daoGestion;
	
	@EJB
	private DaoUtilisateurCatalogue daoCatalogue;
	
	FabriqueEntity fabriqueEntity= new FabriqueEntity();
	
	//Gestion de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) throws DaoUtilisateurExistantException {
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
		Utilisateur utilisateur= readUtilisateur(groupe.getUtilisateur().getId());
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		entityUtilisateur.setId(groupe.getUtilisateur().getId());
		EntityGroupe entityGroupe= new EntityGroupe(groupe.getNom(), entityUtilisateur);
		daoGestion.addGroupe(entityGroupe);
	}
	
	public Groupe readGroupe(int id) {
		EntityGroupe entityGroupe= daoGestion.readGroupe(id);
		System.out.println("************** readGroupe l'entity= "+ entityGroupe.toString());
		Utilisateur utilisateur= fabriqueEntity.createUser(entityGroupe.getUtilisateur());
		System.out.println("************** readGroupe user= "+ utilisateur.toString());
		Groupe groupe= new Groupe(entityGroupe.getNom(), utilisateur);
		System.out.println("************** readGroupe groupe= "+ groupe.toString());
		
		return groupe;
	}
	
	public void updateGroupe(Groupe groupe) {
		EntityGroupe entityGroupe= fabriqueEntity.createEntityGroupe(groupe);
		daoGestion.updateGroupe(entityGroupe);
	}
	
	public void deleteGroupe(int id) {
		daoGestion.deleteGroupe(id);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(ListeDiffusion listeDiff) {
		Utilisateur utilisateur= readUtilisateur(listeDiff.getUtilisateur().getId());
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		entityUtilisateur.setId(listeDiff.getUtilisateur().getId());
		EntityListeDiffusion entityListeDiffusion= new EntityListeDiffusion (listeDiff.getNom(), entityUtilisateur);
		daoGestion.addListeDiff(entityListeDiffusion);
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
