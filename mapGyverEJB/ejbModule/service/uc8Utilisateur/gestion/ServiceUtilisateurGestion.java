package service.uc8Utilisateur.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;
import dao.exception.uc8Utilisateur.DaoFacadeExceptionUtilisateur;
import service.exception.uc8Utilisateur.ServiceUtilisateurExistantException;

@Singleton
@LocalBean
public class ServiceUtilisateurGestion  {
	
	@EJB
	private DaoFacade daoFacade;

	// Bloc Utilisateur
	public void create(Utilisateur utilisateur) throws ServiceUtilisateurExistantException {
		try {
			daoFacade.addUtilisateur(utilisateur);
		} catch (DaoFacadeExceptionUtilisateur e) {
			System.out.println("************** ServiceUtilisateurGestion - exception **** affichage du code et message d'exception : ");
			throw new ServiceUtilisateurExistantException(e.getCode(),e.getMessage());
		}
	}

	public Utilisateur read(int id) {
		return daoFacade.readUtilisateur(id);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void update(Utilisateur utilisateur) {
		daoFacade.updateUtilisateur(utilisateur);
	}

	public void delete(int id) {
		daoFacade.deleteUtilisateur(id);
	}
	
	//Bloc Groupe
	public void createGroupe(Groupe groupe) {
		System.out.println("********* ServiceUtilisateurGestion  ===> createGroupe" + groupe.toString());
		daoFacade.addGroupe(groupe);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public Groupe readGroupe(int id) {
		return daoFacade.readGroupe(id);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateGroupe(Groupe groupe) {
		daoFacade.updateGroupe(groupe);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteGroupe(int id) {
		daoFacade.deleteGroupe(id);
	}
	
	// Bloc Liste diffusion
	public void createListeDiff(ListeDiffusion listeDiff) {
		daoFacade.addListeDiff(listeDiff);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public ListeDiffusion readListeDiff(int id) {
		return daoFacade.readListeDiff(id);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateListeDiff(ListeDiffusion listeDiff) {
		daoFacade.updateListeDiff(listeDiff);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteListeDiff(int id) {
		daoFacade.deleteListeDiff(id);
	}
}
