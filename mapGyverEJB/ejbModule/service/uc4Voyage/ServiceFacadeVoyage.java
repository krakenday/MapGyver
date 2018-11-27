package service.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import service.exception.uc4Voyage.ServiceVoyageException;


@Singleton
@LocalBean
public class ServiceFacadeVoyage {

	@EJB
	private ServiceVoyage serviceVoyage;

	public void createVoyage(Voyage voyage) throws ServiceVoyageException {
		serviceVoyage.createVoyage(voyage);
	}

	public List<Voyage> readVoyageOrderByID() {
		return serviceVoyage.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) throws ServiceVoyageException {
		serviceVoyage.updateVoyage(voyage);
	}

	public void deleteVoyage(int id) throws ServiceVoyageException {
		serviceVoyage.deleteVoyage(id);
	}

	public Voyage findVoyagebyID(int id) {
		return serviceVoyage.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		serviceVoyage.createRoadBook(roadBook);
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return serviceVoyage.readRoadBookOrderByID();
	}

	public void updateRoadBook(RoadBook roadBook) {
		serviceVoyage.updateRoadBook(roadBook);
		
	}

	public void deleteRoadBook(int id) {
		serviceVoyage.deleteRoadBook(id);
	}

	public RoadBook findRoadBookbyID(int id) {
		return serviceVoyage.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		serviceVoyage.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return serviceVoyage.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		serviceVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		serviceVoyage.deletePOInteret(id);
	}

	public PointInteret findPOInteretByID(int id) {
		return serviceVoyage.findPOInteretByID(id);
	}



}
