package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc3Partager.Description;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc6Jouer.ReponseElire;
import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import client.serveur.partager.exception.UserException;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import service.exception.ViolationPersistenceException;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc4Voyage.ServiceVoyageException;
import service.exception.uc6Jouer.ExceptionSurDao;
import service.uc1Administrer.ServiceFacadeAdmin;
import service.uc3Partager.ServiceFacadePartager;
import service.uc4Voyage.ServiceFacadeVoyage;
import service.uc6Jouer.facade.ServiceFacadeJouer;
import service.uc8Utilisateur.ServiceFacadeUtilisateur;
import utilitaire.partager.Erreur;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {

	@EJB
	private ServiceFacadeVoyage serviceFacadeVoyage;

	@EJB
	private ServiceFacadeAdmin serviceFacadeAdmin;

	@EJB
	private ServiceFacadeUtilisateur serviceFacadeUtilisateur;

	@EJB
	private ServiceFacadeJouer serviceFacadeJouer;

	/*
	 * UC3_Partager 
	 */
	@EJB
	private ServiceFacadePartager serviceFacadePartager;

	@Override
	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserById(id);
		return user;
	}

	@Override
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserByEmail(email);
		return user;
	}

	// Bloc Service Utilisateur

	@Override
	public void create(Utilisateur utilisateur) {
		serviceFacadeUtilisateur.create(utilisateur);

	}

	@Override
	public Utilisateur read(int id) {
		return serviceFacadeUtilisateur.read(id) ;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		serviceFacadeUtilisateur.update(utilisateur);
	}

	@Override
	public void delete(int id) {
		serviceFacadeUtilisateur.delete(id);
	}

	// Fabrique Utilisateur
	@Override
	public Utilisateur creerUtilisateur() {
		return serviceFacadeUtilisateur.creerUtilisateur();
	}

	@Override
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return serviceFacadeUtilisateur.creerUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}

	// Bloc service Groupe
	@Override
	public void createGroupe(Groupe groupe) {
		serviceFacadeUtilisateur.createGroupe(groupe);
	}

	@Override
	public Groupe readGroupe(int id) {
		return serviceFacadeUtilisateur.readGroupe(id);
	}

	@Override
	public void updateGroupe(Groupe groupe) {
		serviceFacadeUtilisateur.updateGroupe(groupe);
	}

	@Override
	public void deleteGroupe(int id) {
		serviceFacadeUtilisateur.deleteGroupe(id);
	}

	// Bloc service Liste diffusion
	@Override
	public void createListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.createListeDiff(listeDiff);
	}

	@Override
	public ListeDiffusion readListeDiff(int id) {
		return serviceFacadeUtilisateur.readListeDiff(id);
	}

	@Override
	public void updateListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.updateListeDiff(listeDiff);
	}

	@Override
	public void deleteListeDiff(int id) {
		serviceFacadeUtilisateur.deleteListeDiff(id);
	}

	// Catalogue 
	@Override
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return serviceFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	@Override
	public List<Groupe> listerTousLesGroupes() {
		return serviceFacadeUtilisateur.listerTousLesGroupes();
	}

	@Override
	public List<ListeDiffusion> listerToutesLesListes() {
		return serviceFacadeUtilisateur.listerToutesLesListes();
	}

	// Bloc service voyage

	@Override
	public Voyage createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			return serviceFacadeVoyage.createVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}
	}

	@Override
	public List<Voyage> readVoyageOrderById() {
		//return serviceFacadeVoyage.readVoyageOrderById();	
		return null;
	}

	@Override
	public Voyage updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			return serviceFacadeVoyage.updateVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	@Override
	public void deleteVoyage(int id) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.deleteVoyage(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}		
	}

	@Override
	public Voyage getVoyageById(int id) throws ServiceFacadeExceptionVoyage {
		try {
			return serviceFacadeVoyage.getVoyageById(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}
	}

	@Override
	public RoadBook createRoadBook(RoadBook roadBook) throws ServiceFacadeExceptionVoyage {
		try {
			System.out.println("ServiceFAcade createRoadBook");
			return serviceFacadeVoyage.createRoadBook(roadBook);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(), e.getMessage());
		}
	}

	@Override
	public List<RoadBook> readRoadBookOrderById() {
		//		return serviceFacadeVoyage.readRoadBookOrderById();
		return null;
	}

	@Override
	public RoadBook updateRoadBook(RoadBook roadBook) throws ServiceFacadeExceptionVoyage {
		try {
			System.out.println("ServiceFAcade updateRoadBook");
			return 		serviceFacadeVoyage.updateRoadBook(roadBook);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(), e.getMessage());
		}
	}

	@Override
	public void deleteRoadBook(int id) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.deleteRoadBook(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	@Override
	public RoadBook getRoadBookById(int id) {
		//		return serviceFacadeVoyage.getRoadBookById(id);
		return null;
	}

	@Override
	public RoadBook getRoadBookByUserId(int id) {
		return serviceFacadeVoyage.getRoadBookByUserId(id);
	}

	@Override
	public RoadBook getRoadBookByUser(Utilisateur utilisateur)	throws ServiceFacadeExceptionVoyage {
		try {
			System.out.println("ServiceFAcade getRoadBookByUser");
			return serviceFacadeVoyage.getRoadBookByUser(utilisateur);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(), e.getMessage());
		}
	}

	@Override
	public PointInteret createPOInteret(PointInteret pointInteret) throws ServiceFacadeExceptionVoyage {
		try {
			System.out.println("ServiceFAcade createPOInteret");
			return serviceFacadeVoyage.createPOInteret(pointInteret);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(), e.getMessage());
		}
	}

	@Override
	public List<PointInteret> readPOInteretOrderById() throws ServiceFacadeExceptionVoyage {
		try {
			System.out.println("ServiceFAcade readPOInteretOrderById");
			return serviceFacadeVoyage.readPOInteretOrderById();
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(), e.getMessage());
		}
	}

	@Override
	public PointInteret updatePOInteret(PointInteret pointInteret) {
		//		serviceFacadeVoyage.updatePOInteret(pointInteret);	
		return null;
	}

	@Override
	public void deletePOInteret(int id) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.deletePOInteret(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	@Override
	public PointInteret getPOInteretById(int id) throws ServiceFacadeExceptionVoyage {
		try {
			return serviceFacadeVoyage.getPOInteretById(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	// fin bloc service voyage

	// ********************************************
	// AlexB - UC6 Jouer
	// ********************************************


	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	@Override
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {

		serviceFacadeJouer.createReponseElire(reponseElire);
		System.out.println("tout va bien");
	}
	// ***** Fin AlexB - UC6 Jouer

	/*
	 * Cr�ation
	 */
	@Override
	public void addDescription(Description description) throws UserException {
		if (description == null) throw new UserException(Erreur.DESC_NULL);
		try {
			serviceFacadePartager.addDescription(description);
		} catch (ViolationPersistenceException e) {
			System.out.println("SERVICE_FACADE >>> addDescription(Description description) - Erreur");
			throw new UserException(Erreur.DESC_DOUBLON);
		}
	}

	/*
	 * Modification
	 */
	@Override
	public void updateDescription(Description description) {
		try {
			serviceFacadePartager.updateDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE >>> updateDescription(Description description) - Erreur");
		}
	}



}
