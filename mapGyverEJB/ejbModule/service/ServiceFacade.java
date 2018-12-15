package service;

import java.time.LocalDate;
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
import clientServeur.exception.ServiceFacadeExceptionUtilisateur;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import service.exception.ViolationPersistenceException;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc4Voyage.ServiceVoyageException;
import service.exception.uc6Jouer.ExceptionSurDao;
import service.exception.uc8Utilisateur.ServiceUtilisateurExistantException;
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
	
	// Fabrique utilisateur et groupe
	@Override
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return serviceFacadeUtilisateur.creerUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
	
	@Override
	public Groupe creerGroupe(String nom, Utilisateur utilisateur) {
		return serviceFacadeUtilisateur.creerGroupe(nom, utilisateur);
	};

	// Gestion utilisateur
	@Override
	public void create(Utilisateur utilisateur) throws ServiceFacadeExceptionUtilisateur {
		try {
			serviceFacadeUtilisateur.create(utilisateur);			
		}catch(ServiceUtilisateurExistantException e) {
			throw new ServiceFacadeExceptionUtilisateur(e.getCode(), e.getMessage());
		}
	}

	@Override
	public Utilisateur read(int id) {
		return serviceFacadeUtilisateur.read(id) ;
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public void update(Utilisateur utilisateur) {
		serviceFacadeUtilisateur.update(utilisateur);
	}

	@Override
	public void delete(int id) {
		serviceFacadeUtilisateur.delete(id);
	}


	// Bloc service Groupe
	@Override
	public void createGroupe(Groupe groupe) {
		System.out.println("********* createGroupe ===> ServiceFacade " + groupe.toString());
		serviceFacadeUtilisateur.createGroupe(groupe);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public Groupe readGroupe(int id) {
		return serviceFacadeUtilisateur.readGroupe(id);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public void updateGroupe(Groupe groupe) {
		serviceFacadeUtilisateur.updateGroupe(groupe);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public void deleteGroupe(int id) {
		serviceFacadeUtilisateur.deleteGroupe(id);
	}

	// Bloc service Liste diffusion
	@Override
	public void createListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.createListeDiff(listeDiff);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public ListeDiffusion readListeDiff(int id) {
		return serviceFacadeUtilisateur.readListeDiff(id);
	}
	
	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
	@Override
	public void updateListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.updateListeDiff(listeDiff);
	}

	/*
	 * NON FONCTIONNELLE, PREVUE POUR LA VERSION 2.0
	 */
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
	public List<Groupe> listerTousLesGroupes(int id) {
		System.out.println("************ ServiceFacade listeGroupe ***********");
		return serviceFacadeUtilisateur.listerTousLesGroupes(id);
	}

	@Override
	public List<ListeDiffusion> listerToutesLesListes(int id) {
		return serviceFacadeUtilisateur.listerToutesLesListes(id);
	}

	// Bloc service voyage

	@Override
	public void createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.createVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}
	}

	@Override
	public List<Voyage> readVoyageOrderByID() {
		//return serviceFacadeVoyage.readVoyageOrderByID();	
		return null;
	}

	@Override
	public void updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.updateVoyage(voyage);
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
	public Voyage findVoyagebyID(int id) {
		//		return serviceFacadeVoyage.findVoyagebyID(id);
		return null;
	}

	@Override
	public void createRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.createRoadBook(roadBook);	
	}

	@Override
	public List<RoadBook> readRoadBookOrderByID() {
		//		return serviceFacadeVoyage.readRoadBookOrderByID();
		return null;
	}

	@Override
	public void updateRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.updateRoadBook(roadBook);	
	}

	@Override
	public void deleteRoadBook(int id) {
		//		serviceFacadeVoyage.deleteRoadBook(id);

	}

	@Override
	public RoadBook findRoadBookbyID(int id) {
		//		return serviceVoyage.findRoadBookbyID(id);
		return null;
	}

	@Override
	public void createPOInteret(PointInteret pointInteret) {
		//		serviceVoyage.createPOInteret(pointInteret);		
	}

	@Override
	public List<PointInteret> readPOInteretOrderByID() {
		//		return serviceVoyage.readPOInteretOrderByID();
		return null;
	}

	@Override
	public void updatePOInteret(PointInteret pointInteret) {
		//		serviceVoyage.updatePOInteret(pointInteret);	

	}

	@Override
	public void deletePOInteret(int id) {
		//		serviceVoyage.deletePOInteret(id);
	}

	@Override
	public PointInteret findPOInteretByID(int id) {
		//		return serviceVoyage.findPOInteretByID(id);
		return null;
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
	 * Création
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
