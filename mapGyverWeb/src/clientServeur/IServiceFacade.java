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
	public Voyage 				createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	public List<Voyage> 		readVoyageOrderById();
	public Voyage 				updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	public void 				deleteVoyage(int id) 		throws ServiceFacadeExceptionVoyage;
	public Voyage 				getVoyageById(int id);
	
	// RoadBook, offre de service : CRUD
	public RoadBook				createRoadBook(RoadBook roadBook);
	public List<RoadBook> 		readRoadBookOrderById();
	public RoadBook 			updateRoadBook(RoadBook roadBook);
	public void 				deleteRoadBook(int id);
	public RoadBook				getRoadBookById(int id);
	public RoadBook 			getRoadBookByUserId(int id);
	
	// PointInteret, offre de service : CRUD
	public PointInteret 		createPOInteret(PointInteret pointInteret);
	public List<PointInteret> 	readPOInteretOrderById();
	public PointInteret			updatePOInteret(PointInteret pointInteret);
	public void 				deletePOInteret(int id);
	public PointInteret 		getPOInteretById(int id);
	
	
}
