package clientServeur;

import java.time.LocalDate;
import java.util.List;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import clientServeur.exception.ServiceFacadeExceptionVoyage;



public interface IServiceFacade {

	// ********************************************
	//  DM - UC1 Administrer
	// ********************************************

	/**
	 * Retourne un Utilisateur a partir de son id
	 * @throws ServiceInexistantException 
	 */
	public Utilisateur getUserById(int id) 			throws ServiceInexistantException;
	/**
	 * Retourne un Utilisateur a partir de son email
	 * @throws ServiceInexistantException 
	 */
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException;
	
	// *****  Fin DM - UC1 Administrer
	
	// ********************************************
	//  DB - UC8 Utilisateur
	// ********************************************
	//LA Fabrique d'utilisateur
	public Utilisateur creerUtilisateur();
	
	// le modifier apres l'ajout de la classe ville et pays
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse);
	
	// Gerer l'utilisateur
	public void create(Utilisateur utilisateur);
	
	public Utilisateur read(int id);
	
	public void update(Utilisateur utilisateur);
	
	public void delete(int id);
	
	// Catalogue utilisateur
	public List<Utilisateur> listerTousLesUtilisateurs();
	
	// Gerer un groupe
	public void createGroupe(Groupe groupe);
	
	public Groupe readGroupe(int id);
	
	public void updateGroupe (Groupe groupe);
	
	public void deleteGroupe(int id);
	
	// Catalogue groupe
	public List<Groupe> listerTousLesGroupes();
	
	// Gerer une Liste Diffusion
	public void createListeDiff(ListeDiffusion listeDiff);
	
	public ListeDiffusion readListeDiff(int id);
	
	public void updateListeDiff (ListeDiffusion listeDiff);
	
	public void deleteListeDiff(int id);
	
	// Catalogue Liste diffusion
	public List<ListeDiffusion> listerToutesLesListes();
	// *****  Fin DB - UC8 Utilisateur
		
	// Voyage, offre de service : CRUD
	
	/**
	 * Methode permettant de faire persister un voyage
	 * @param voyage a persister 
	 * @return voyage sauvegardé
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public Voyage 				createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Methode listant tous les voyages préalablement sauvegardés et les ordonnants
	 * par ID ascendant
	 * @return liste des voyages sauvegardés
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public List<Voyage> 		readVoyageOrderById() 		throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Met à jour un voyage préalablement sauvegardé
	 * @param voyage déjà sauvegardé contenant les nouvelles informations
	 * @return voyage sauvegardé 
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public Voyage 				updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Supprime le voyage préalablement sauvegardé
	 * @param id du voyage à supprimer
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public void 				deleteVoyage(int id) 		throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Recupère un voyage préalablement sauvegardé
	 * @param id du voyage a récupérer
	 * @return voyage sauvegardé qui correspond à l'id indiqué
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public Voyage 				getVoyageById(int id) 		throws ServiceFacadeExceptionVoyage;
	
	// RoadBook, offre de service : CRUD
	/**
	 * Methode permettant de faire persister un roadBook
	 * @param roadBook a persister 
	 * @return roadBook sauvegardé
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public RoadBook				createRoadBook(RoadBook roadBook) 			throws ServiceFacadeExceptionVoyage;

	/**
	 * Methode listant tous les roadBook préalablement sauvegardés et les ordonnants
	 * par ID ascendant
	 * @return liste des roadBook sauvegardés
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public List<RoadBook> 		readRoadBookOrderById() 					throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Met à jour un roadBook préalablement sauvegardé
	 * @param roadBook déjà sauvegardé 
	 * contenant les nouvelles informations à enregistrer
	 * @return roadBook sauvegardé
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public RoadBook 			updateRoadBook(RoadBook roadBook) 			throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Supprime le roadBook préalablement sauvegardé
	 * @param id du roadBook à supprimer
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public void 				deleteRoadBook(int id) 						throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Recupère un roadBook préalablement sauvegardé
	 * selon l'id du roadBook
	 * @param id du roadBook a récupérer
	 * @return roadBook sauvegardé qui correspond à l'id indiqué
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public RoadBook				getRoadBookById(int id) 					throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Recupère un roadBook préalablement sauvegardé
	 * selon l'id d'un utilisateur
	 * @param id de l'utilisateur a qui appartient le roadBook
	 * @return roadBook sauvegardé qui correspond à l'id de l'utilisateur indiqué
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public RoadBook 			getRoadBookByUserId(int id) 				throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Recupère le roadBook préalablement sauvegardé
	 * de l'utilisateur indiquéé
	 * @param utilisateur a qu iappartien le roadBook
	 * @return roadBook sauvegardé qui correspond à l'utilisateur indiqué
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public RoadBook 			getRoadBookByUser(Utilisateur utilisateur)	throws ServiceFacadeExceptionVoyage;
	
	// PointInteret, offre de service : CRUD
	
	/**
	 * Methode permettant de faire persister un point d'interet
	 * @param point d'interet a persister 
	 * @return point d'interet sauvegardé
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public PointInteret 		createPOInteret(PointInteret pointInteret)	throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Methode listant tous les points d'interets préalablement sauvegardés 
	 * et les ordonnants par Id
	 * @return point d'interet sauvegardé
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public List<PointInteret> 	readPOInteretOrderById()					throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Met à jour un point d'interet préalablement sauvegardé
	 * @param pointInteret déjà sauvegardé
	 * contenant les nouvelles informations à enregistrer
	 * @return point d'interet sauvegardé 
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public PointInteret			updatePOInteret(PointInteret pointInteret)	throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Supprime le point d'interet préalablement sauvegardé
	 * @param id du point d'interet à supprimer
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public void 				deletePOInteret(int id)						throws ServiceFacadeExceptionVoyage;
	
	/**
	 * Recupère un point d'interet préalablement sauvegardé
	 * selon l'id du point d'interet
	 * @param id du point d'interet a récupérer
	 * @return point d'interet sauvegardé qui correspond à l'id indiqué
	 * @throws ServiceFacadeExceptionVoyage
	 */
	public PointInteret 		getPOInteretById(int id)					throws ServiceFacadeExceptionVoyage;
	
}
