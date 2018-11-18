package clientServeur;

import java.util.List;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;



public interface IServiceFacade {
	
	// Voyage, offre de service : CRUD
	public void 				createVoyage(Voyage voyage);
	public List<Voyage> 		readVoyageOrderByID();
	public void 				updateVoyage(Voyage voyage);
	public void 				deleteVoyage(int id);
	public Voyage 				findVoyagebyID(int id);
	
	// RoadBook, offre de service : CRUD
	public void 				createRoadBook(RoadBook roadBook);
	public List<RoadBook> 		readRoadBookOrderByID();
	public void 				updateRoadBook(RoadBook roadBook);
	public void 				deleteRoadBook(int id);
	public RoadBook				findRoadBookbyID(int id);
	
	// PointInteret, offre de service : CRUD
	public void 				createPOInteret(PointInteret pointInteret);
	public List<PointInteret> 	readPOInteretOrderByID();
	public void 				updatePOInteret(PointInteret pointInteret);
	public void 				deletePOInteret(int id);
	public PointInteret 		findPOInteretByID(int id);
	
	
}