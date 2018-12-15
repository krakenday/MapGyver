package dao.uc8Utilisateur;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc8Utilisateur.DaoUtilisateurExistantException;
import dao.uc8Utilisateur.catalogue.DaoUtilisateurCatalogue;
import dao.uc8Utilisateur.fabrique.FabriqueEntity;
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
	
	@EJB
	private FabriqueEntity fabriqueEntity;
	
	//Gestion de l'utilisateur
	/**
	 * Reçoit en parametres un Utilisateur, il passera par la fabrique pour le repasser en entityUtilisateur pour etre persister dans la classe DaoGestion
	 * @param utilisateur
	 * @throws DaoUtilisateurExistantException
	 */
	public void addUtilisateur(Utilisateur utilisateur) throws DaoUtilisateurExistantException {
			EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
			daoGestion.addUtilisateur(entityUtilisateur);		
	}
	
	public Utilisateur readUtilisateur(int id) {
		EntityUtilisateur entityUtilisateur= daoGestion.readUtilisateur(id);
		Utilisateur utilisateur= fabriqueEntity.createUser(entityUtilisateur);
		return utilisateur;
	}
	
	/*
	 * PAS FONCTIONNEL
	 */
	public void updateUtilisateur(Utilisateur utilisateur) {
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		daoGestion.updateUtilisateur(entityUtilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		daoGestion.deleteUtilisateur(id);
	}
	
	//Gestion du groupe
	/**
	 * Reçoit en parametres un Groupe, il passera par la fabrique pour le repasser en entityUtilisateur pour etre persister dans la classe DaoGestion
	 * @param groupe
	 */
	public void addGroupe(Groupe groupe) {
		Utilisateur utilisateur= readUtilisateur(groupe.getUtilisateur().getId());
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		entityUtilisateur.setId(groupe.getUtilisateur().getId());
		EntityGroupe entityGroupe= new EntityGroupe(groupe.getNom(), entityUtilisateur);
		daoGestion.addGroupe(entityGroupe);
	}
	
	/*
	 * PAS FONCTIONNEL
	 */
	public Groupe readGroupe(int id) {
		EntityGroupe entityGroupe= daoGestion.readGroupe(id);
		Utilisateur utilisateur= fabriqueEntity.createUser(entityGroupe.getUtilisateur());
		Groupe groupe= new Groupe(entityGroupe.getNom(), utilisateur);
		return groupe;
	}
	
	/*
	 * PAS FONCTIONNEL
	 */
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
	
	/*
	 * PAS FONCTIONNEL
	 */
	public ListeDiffusion readListeDiff(int id) {
		EntityListeDiffusion entityListeDiff= daoGestion.readListeDiff(id);
		ListeDiffusion listeDiff= fabriqueEntity.creeListeDiff(entityListeDiff);
		return listeDiff;
	}
	
	/*
	 * PAS FONCTIONNEL
	 */
	public void updateListeDiff(ListeDiffusion listeDiff) {
		EntityListeDiffusion entityListeDiff= fabriqueEntity.creeEntityListeDiff(listeDiff);
		daoGestion.updateListeDiff(entityListeDiff);
	}
	
	/*
	 * PAS FONCTIONNEL
	 */
	public void deleteListeDiff(int id) {
		daoGestion.deleteListeDiff(id);
	}
	
	//Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs() {
		ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
		for (EntityUtilisateur u : daoCatalogue.listerTousLesUtilisateurs()) {   
			if (u instanceof EntityUtilisateur) {
				Utilisateur utilisateur= fabriqueEntity.createUser(u);
				utilisateur.setId(u.getId());
				liste.add(utilisateur);
			}
		}
		return liste;
	}

	public List<Groupe> listerTousLesGroupes(int id) {
		System.out.println("************ DaoFacadeUtilisateur listeGroupe ***********");
		ArrayList<Groupe> liste = new ArrayList<Groupe>();
		for (EntityGroupe g : daoCatalogue.listerTousLesGroupes(id)) {   
			if (g instanceof EntityGroupe) {
				Utilisateur utilisateur= fabriqueEntity.createUser(((EntityGroupe) g).getUtilisateur());
				utilisateur.setId(((EntityGroupe) g).getUtilisateur().getId());
				Groupe groupe= new Groupe(((EntityGroupe) g).getNom(), utilisateur);
				groupe.setId(((EntityGroupe) g).getId());
				liste.add(groupe);
			}
		}
		return liste;
	}

	public List<ListeDiffusion> listerToutesLesListes(int id) {
		System.out.println("************ DaoFacadeUtilisateur listeDiffusion ***********");
		ArrayList<ListeDiffusion> liste = new ArrayList<ListeDiffusion>();
		for (EntityListeDiffusion f : daoCatalogue.listerToutesLesListes(id)) {   
			if (f instanceof EntityListeDiffusion) {
				Utilisateur utilisateur= fabriqueEntity.createUser(((EntityListeDiffusion) f).getUtilisateur());
				utilisateur.setId(((EntityListeDiffusion) f).getUtilisateur().getId());
				ListeDiffusion listeDiff= new ListeDiffusion(((EntityListeDiffusion) f).getNom(), utilisateur);
				listeDiff.setId(((EntityListeDiffusion) f).getId());
				liste.add(listeDiff);
			}
		}
		return liste;
	}

}
