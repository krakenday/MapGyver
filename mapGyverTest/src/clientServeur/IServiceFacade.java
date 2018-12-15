package clientServeur;


import java.time.LocalDate;
import java.util.List;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;

import business.uc6Jouer.ReponseElire;

import business.uc8Utilisateur.Utilisateur;
import clientServeur.exception.ServiceFacadeExceptionUtilisateur;
//import clientServeur.exception.ServiceFacadeExceptionVoyage;
//import client.serveur.partager.exception.UserException;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;
//import business.uc3Partager.Description;
//import business.uc4Voyage.PointInteret;
//import business.uc4Voyage.RoadBook;
//import business.uc4Voyage.Voyage;
//import clientServeur.exception.ServiceFacadeExceptionUtilisateur;
//import clientServeur.exception.ServiceFacadeExceptionVoyage;



public interface IServiceFacade {

	// ********************************************
	// DM - UC1 Administrer
	// ********************************************

	/**
	 * Retourne un Utilisateur a partir de son id
	 * 
	 * @throws ServiceInexistantException
	 */
	public Utilisateur getUserById(int id) throws ServiceInexistantException;

	/**
	 * Retourne un Utilisateur a partir de son email
	 * 
	 * @throws ServiceInexistantException
	 */
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException;

	
	// *****  Fin DM - UC1 Administrer
	
	/* ********************************************
	  			DB - UC8 Utilisateur
	  *********************************************/
	
	// Fabrique d'utilisateur et groupe (méthodes utilisées avec la servlet ControleurUtilisateur)
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
										LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse);
	
	public Groupe creerGroupe(String nom, Utilisateur utilisateur);
	
	// Gerer l'utilisateur
	/**
	 * Crée un Utilisateur 
	 * @param utilisateur
	 * @throws ServiceFacadeExceptionUtilisateur
	 */
	public void create(Utilisateur utilisateur) throws ServiceFacadeExceptionUtilisateur;
	
	public Utilisateur read(int id);
	
	public void update(Utilisateur utilisateur);
	
	public void delete(int id);

	// Gerer un groupe
	public void createGroupe(Groupe groupe);
	
	public Groupe readGroupe(int id);
	
	public void updateGroupe (Groupe groupe);
	
	public void deleteGroupe(int id);

	// Gerer une Liste Diffusion
	public void createListeDiff(ListeDiffusion listeDiff);
	
	public ListeDiffusion readListeDiff(int id);
	
	public void updateListeDiff (ListeDiffusion listeDiff);
	
	public void deleteListeDiff(int id);
	
	// Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs();
	
	public List<Groupe> listerTousLesGroupes(int id);

	public List<ListeDiffusion> listerToutesLesListes(int id);
	// *****  Fin DB - UC8 Utilisateur
		
	// Voyage, offre de service : CRUD
//	public void 				createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
//	public List<Voyage> 		readVoyageOrderByID();
//	public void 				updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
//	public void 				deleteVoyage(int id) 		throws ServiceFacadeExceptionVoyage;
//	public Voyage 				findVoyagebyID(int id);
//	
	// RoadBook, offre de service : CRUD
//	public void 				createRoadBook(RoadBook roadBook);
//	public List<RoadBook> 		readRoadBookOrderByID();
//	public void 				updateRoadBook(RoadBook roadBook);
//	public void 				deleteRoadBook(int id);
//	public RoadBook				findRoadBookbyID(int id);
	
	// PointInteret, offre de service : CRUD
//	public void 				createPOInteret(PointInteret pointInteret);
//	public List<PointInteret> 	readPOInteretOrderByID();
//	public void 				updatePOInteret(PointInteret pointInteret);
//	public void 				deletePOInteret(int id);
//	public PointInteret 		findPOInteretByID(int id);
	
	// ********************************************
	// AlexB - UC6 Jouer
	// ********************************************

	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao;


	// ***** Fin AlexB - UC6 Jouer
	
	// ********************************************
	// AlexM - Description
	// ********************************************
//	public void addDescription(Description description) throws UserException;
//
//	public void updateDescription(Description description);
	

}
