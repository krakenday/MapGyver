package clientServeur;


import java.time.LocalDate;
import java.util.List;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;

import business.uc6Jouer.ReponseElire;

import business.uc8Utilisateur.Utilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import clientServeur.exception.ServiceFacadeExceptionVoyage;



public interface IServiceFacade {
	
	public Utilisateur getUserById(int id) 			throws ServiceInexistantException;
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException;
	public void create(Utilisateur utilisateur);
	public void delete(int id);

	// Voyage, offre de service : CRUD
	public Voyage 				createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	public List<Voyage> 		readVoyageOrderById() 		throws ServiceFacadeExceptionVoyage;
	public Voyage 				updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage;
	public void 				deleteVoyage(int id) 		throws ServiceFacadeExceptionVoyage;
	public Voyage 				getVoyageById(int id) 		throws ServiceFacadeExceptionVoyage;

	// RoadBook, offre de service : CRUD
	public RoadBook				createRoadBook(RoadBook roadBook) 			throws ServiceFacadeExceptionVoyage;
	public List<RoadBook> 		readRoadBookOrderById() 					throws ServiceFacadeExceptionVoyage;
	public RoadBook 			updateRoadBook(RoadBook roadBook) 			throws ServiceFacadeExceptionVoyage;
	public void 				deleteRoadBook(int id) 						throws ServiceFacadeExceptionVoyage;
	public RoadBook				getRoadBookById(int id) 					throws ServiceFacadeExceptionVoyage;
	public RoadBook 			getRoadBookByUserId(int id) 				throws ServiceFacadeExceptionVoyage;
	public RoadBook 			getRoadBookByUser(Utilisateur utilisateur)	throws ServiceFacadeExceptionVoyage;

	// PointInteret, offre de service : CRUD
	public PointInteret 		createPOInteret(PointInteret pointInteret)	throws ServiceFacadeExceptionVoyage;
	public List<PointInteret> 	readPOInteretOrderById()					throws ServiceFacadeExceptionVoyage;
	public PointInteret			updatePOInteret(PointInteret pointInteret)	throws ServiceFacadeExceptionVoyage;
	public void 				deletePOInteret(int id)						throws ServiceFacadeExceptionVoyage;
	public PointInteret 		getPOInteretById(int id)					throws ServiceFacadeExceptionVoyage;




}
