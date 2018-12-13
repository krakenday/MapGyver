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

	//***************** Voyage
	public Voyage createVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			return daoFacadeVoyage.createVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".Voyage"+ e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderById() {
		return daoFacadeVoyage.readVoyageOrderById();
	}

	public Voyage updateVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			System.out.println("DAoFacade " + voyage);
			return daoFacadeVoyage.updateVoyage(voyage);	
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".Voyage"+ e.getMessage());
		}
	}

	public void deleteVoyage(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deleteVoyage(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".Voyage"+ e.getMessage());
		}
	}

	public Voyage getVoyageById(int id) throws DaoFacadeExceptionVoyage {
		try {
			return daoFacadeVoyage.getVoyageById(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".Voyage"+ e.getMessage());
		}
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws DaoFacadeExceptionVoyage {
		try {
			System.out.println("daoFacade createRoadBook");
			return daoFacadeVoyage.createRoadBook(roadBook);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".RoadBook"+ e.getMessage());
		}
	}

	public List<RoadBook> readRoadBookOrderById() {
		return daoFacadeVoyage.readRoadBookOrderById();	
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws DaoFacadeExceptionVoyage {
		try {
			System.out.println("daoFacade updateRoadBook");
			return daoFacadeVoyage.updateRoadBook(roadBook);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".RoadBook"+ e.getMessage());
		}
	}

	public void deleteRoadBook(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deleteRoadBook(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".RoadBook"+ e.getMessage());
		}
	}

	public RoadBook getRoadBookById(int id) {
		return daoFacadeVoyage.getRoadBookById(id);
	}

	public RoadBook getRoadBookByUserId(int id) {
		return daoFacadeVoyage.getRoadBookByUserId(id);
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws DaoFacadeExceptionVoyage {
		try {
			System.out.println("daoFacade getRoadBookByUser");
			return daoFacadeVoyage.getRoadBookByUser(utilisateur);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".RoadBook"+ e.getMessage());
		}
	}

	public PointInteret createPOInteret(PointInteret pointInteret) throws DaoFacadeExceptionVoyage  {
		try {
			System.out.println("daoFacade createPOInteret");
			return daoFacadeVoyage.createPOInteret(pointInteret);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".POI"+ e.getMessage());
		}

	}

	public List<PointInteret> readPOInteretOrderById() throws DaoFacadeExceptionVoyage {
		try {
			System.out.println("daoFacade readPOInteretOrderById");
			return daoFacadeVoyage.readPOInteretOrderById();
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".POI"+ e.getMessage());
		}
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) {
		return daoFacadeVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deletePOInteret(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".POI"+ e.getMessage());
		}
	}

	public PointInteret getPOInteretById(int id) throws DaoFacadeExceptionVoyage {
		try {
			return daoFacadeVoyage.getPOInteretById(id);	
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					".POI"+ e.getMessage());
		}
	}
	//fin ***************** Voyage


	//Partager
	/*
	 * Cr�ation
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
