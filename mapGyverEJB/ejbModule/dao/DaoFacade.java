package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Photo;
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

	@EJB
	private DaoFacadePartager daoFacadePartager;

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";

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

	public ArrayList<Photo> uc1GetAllPhoto() {
		return daoFacadeAdmin.uc1GetAllPhoto();
	}

	// Ici commence le territoire de Djallel
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

	// Gestion du groupe
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

	// Gestion de liste de diffusion
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

	// Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	public List<Groupe> listerTousLesGroupes() {
		return daoFacadeUtilisateur.listerTousLesGroupes();
	}

	public List<ListeDiffusion> listerToutesLesListes() {
		return daoFacadeUtilisateur.listerToutesLesListes();
	}
	// Merci de votre visite

	// ***************** Voyage
	public void createVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.createVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(), ZONE_EXCEPTION_MSG + e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderByID() {
		return daoFacadeVoyage.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.updateVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(), ZONE_EXCEPTION_MSG + e.getMessage());
		}
	}

	public void deleteVoyage(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deleteVoyage(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(), ZONE_EXCEPTION_MSG + e.getMessage());
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
	// fin ***************** Voyage

	// Partager
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
