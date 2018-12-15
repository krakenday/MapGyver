package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc3Partager.Description;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc6Jouer.ReponseElire;
import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.ViolationPersistenceException;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.exception.uc4Voyage.DaoFacadeExceptionVoyage;
import dao.exception.uc4Voyage.DaoVoyageException;
import dao.exception.uc6Jouer.ConvertionException;
import dao.exception.uc8Utilisateur.DaoFacadeExceptionUtilisateur;
import dao.exception.uc8Utilisateur.DaoUtilisateurExistantException;
import dao.uc1Administrer.DaoFacadeAdmin;
import dao.uc3Partager.DaoFacadePartager;
import dao.uc4Voyage.DaoFacadeVoyage;
import dao.uc6Jouer.facade.DaoFacadeJouer;
import dao.uc8Utilisateur.DaoFacadeUtilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;


@Singleton
@LocalBean
public class DaoFacade {

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";
	
	@EJB
	private DaoFacadePartager daoFacadePartager;
	
	@EJB
	private DaoFacadeAdmin daoFacadeAdmin;
	
	@EJB
	private DaoFacadeUtilisateur daoFacadeUtilisateur;
		
	@EJB
	private DaoFacadeVoyage daoFacadeVoyage;
	
	@EJB
	private DaoFacadeJouer daoFacadeJouer;
	

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserById(id);
		} catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		return user;
	}

	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserByEmail(email);
		} catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		return user;
	}

	//************ Utilisateur
	// Gestion de l'utilisateur 
	
	/**
	 * Creation d'un utilisateur
	 * @param utilisateur
	 * @throws DaoFacadeExceptionUtilisateur
	 */
	public void addUtilisateur(Utilisateur utilisateur) throws DaoFacadeExceptionUtilisateur {
		try {
			daoFacadeUtilisateur.addUtilisateur(utilisateur);				
		}catch (DaoUtilisateurExistantException e ){
			throw new DaoFacadeExceptionUtilisateur(e.getMessage());
		}
	}
	
	/**
	 * 
	 * Récuperer un utilisateur dans la BDD
	 * @param id
	 * 
	 */	
	public Utilisateur readUtilisateur(int id) {
		return daoFacadeUtilisateur.readUtilisateur(id);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateUtilisateur(Utilisateur utilisateur) {
		daoFacadeUtilisateur.updateUtilisateur(utilisateur);
	}
	
	/**
	 * 
	 * Suppression d'un utilisateur
	 * @param id
	 * 
	 */
	public void deleteUtilisateur(int id) {
		daoFacadeUtilisateur.deleteUtilisateur(id);
	}
	
	//Gestion de groupe
	
	/**
	 * Creation d'un groupe d'utilisateur
	 * @param groupe
	 */
	public void addGroupe(Groupe groupe) {
		System.out.println("********* addGroupe ===> DaoFacade " + groupe.toString());
		daoFacadeUtilisateur.addGroupe(groupe);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public Groupe readGroupe(int id) {
		return daoFacadeUtilisateur.readGroupe(id);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateGroupe(Groupe groupe) {
		daoFacadeUtilisateur.updateGroupe(groupe);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteGroupe(int id) {
		daoFacadeUtilisateur.deleteGroupe(id);
	}
	
	//Gestion de liste de diffusion
	
	/**
	 * Creation d'une liste de diffusion de contact 
	 * @param listeDiff
	 */
	public void addListeDiff(ListeDiffusion listeDiff) {
		System.out.println("********* addListeDiff ===> DaoFacade " + listeDiff.toString());
		daoFacadeUtilisateur.addListeDiff(listeDiff);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public ListeDiffusion readListeDiff(int id) {
		return daoFacadeUtilisateur.readListeDiff(id);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void updateListeDiff(ListeDiffusion listeDiff) {
		daoFacadeUtilisateur.updateListeDiff(listeDiff);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	public void deleteListeDiff(int id) {
		daoFacadeUtilisateur.deleteListeDiff(id);
	}
	
	//Catalogue 
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	public List<Groupe> listerTousLesGroupes(int id) {
		return daoFacadeUtilisateur.listerTousLesGroupes(id);
	}

	public List<ListeDiffusion> listerToutesLesListes(int id) {
		return daoFacadeUtilisateur.listerToutesLesListes(id);
	}
	
	//***************** Voyage
	public void createVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.createVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderByID() {
		return daoFacadeVoyage.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
		daoFacadeVoyage.updateVoyage(voyage);	
	} catch (DaoVoyageException e) {
		throw new DaoFacadeExceptionVoyage(e.getCode(),
				ZONE_EXCEPTION_MSG+ e.getMessage());
	}
	}
	
	public void deleteVoyage(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deleteVoyage(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public Voyage findVoyagebyID(int id) {
		return daoFacadeVoyage.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.createRoadBook(roadBook);	
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return daoFacadeVoyage.readRoadBookOrderByID();	
	}

	public void updateRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.updateRoadBook(roadBook);	
	}

	public void deleteRoadBook(int id) {
		daoFacadeVoyage.deleteRoadBook(id);	
	}

	public RoadBook findRoadBookbyID(int id) {
		return daoFacadeVoyage.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.createPOInteret(pointInteret);
		
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return daoFacadeVoyage.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daoFacadeVoyage.deletePOInteret(id);		
	}

	public PointInteret findPOInteretByID(int id) {
		return daoFacadeVoyage.findPOInteretByID(id);	
	}
	//fin ***************** Voyage


	//Partager
	/*
	 * Création
	 */
	public void addDescription(Description description) throws service.exception.ViolationPersistenceException {
		try {
			daoFacadePartager.addDescription(description);
		} catch (ViolationPersistenceException e) {
			System.out.println("DAO_FACADE >>> addDescription(Description description) - Erreur");
			throw new service.exception.ViolationPersistenceException();
		}
	}

	/*
	 * Modification
	 */
	public void updateDescription(Description description) {
		try {
			daoFacadePartager.updateDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> updateDescription(Description description) - Erreur");
		}
	}

	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id) {
		try {
			daoFacadePartager.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> deleteDescription(int id) - Erreur");
		}
	}

	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description) {
		try {
			daoFacadePartager.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> deleteDescription(Description description) - Erreur");
		}
	}


	/**
	 * UC6 Jouer =>interface entre DaoFacade et DaoFaceJouer
	 */

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {
		try {
			daoFacadeJouer.createReponseElire(reponseElire);
		} catch (ConvertionException e) {
			throw new ExceptionSurDao(e.getMessage(), e.getCause());
		}
	}

}
