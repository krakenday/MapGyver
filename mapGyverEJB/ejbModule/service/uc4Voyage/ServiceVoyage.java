package service.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.DaoFacade;

/**
 * Session Bean implementation class ServiceVoyage
 */

public class ServiceVoyage {

	@EJB
	DaoFacade daofacade ;
	
	public ServiceVoyage() {
	}

	public void createVoyage(Voyage voyage) {
		System.out.println("do ServiceVoyage.daofacade.createVoyage(voyage) " + voyage);
		daofacade.createVoyage(voyage);
	}

	public List<Voyage> readVoyageOrderByID() {
		return daofacade.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) {
		daofacade.updateVoyage(voyage);
	}

	public void deleteVoyage(int id) {
		daofacade.deleteVoyage(id);
	}

	public Voyage findVoyagebyID(int id) {
		return daofacade.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		daofacade.createRoadBook(roadBook);
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return daofacade.readRoadBookOrderByID();
	}

	public void updateRoadBook(RoadBook roadBook) {
		daofacade.updateRoadBook(roadBook);
		
	}

	public void deleteRoadBook(int id) {
		daofacade.deleteRoadBook(id);
	}

	public RoadBook findRoadBookbyID(int id) {
		return daofacade.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		daofacade.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return daofacade.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		daofacade.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daofacade.deletePOInteret(id);
	}

	public PointInteret findPOInteretByID(int id) {
		return daofacade.findPOInteretByID(id);
	}



}
