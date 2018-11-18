package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.uc4Voyage.DaoVoyage;

@Singleton
@LocalBean
public class DaoFacade {

	@EJB
	DaoVoyage daoVoyage;

	public void createVoyage(Voyage voyage) {
		System.out.println("do DaoFacade.daoVoyage.createVoyage(voyage) " + voyage);
		daoVoyage.createVoyage(voyage);		
	}

	public List<Voyage> readVoyageOrderByID() {
		return daoVoyage.readVoyageOrderByID();	
	}

	public void updateVoyage(Voyage voyage) {
		daoVoyage.updateVoyage(voyage);			
	}
	
	public void deleteVoyage(int id) {
		daoVoyage.deleteVoyage(id);
	}

	public Voyage findVoyagebyID(int id) {
		return daoVoyage.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		daoVoyage.createRoadBook(roadBook);	
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return daoVoyage.readRoadBookOrderByID();	
	}

	public void updateRoadBook(RoadBook roadBook) {
		daoVoyage.updateRoadBook(roadBook);	
	}

	public void deleteRoadBook(int id) {
		daoVoyage.deleteRoadBook(id);	
	}

	public RoadBook findRoadBookbyID(int id) {
		return daoVoyage.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		daoVoyage.createPOInteret(pointInteret);
		
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return daoVoyage.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		daoVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daoVoyage.deletePOInteret(id);		
	}

	public PointInteret findPOInteretByID(int id) {
		return daoVoyage.findPOInteretByID(id);	
	}

	
	
}
