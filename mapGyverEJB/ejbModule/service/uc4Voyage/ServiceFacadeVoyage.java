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

	public List<Voyage> readVoyageOrderById() {
		return serviceVoyage.readVoyageOrderById();
	}

	public void updateVoyage(Voyage voyage) throws ServiceVoyageException {
		serviceVoyage.updateVoyage(voyage);
	}

	public void deleteVoyage(int id) throws ServiceVoyageException {
		serviceVoyage.deleteVoyage(id);
	}

	public Voyage getVoyageById(int id) {
		return serviceVoyage.getVoyageById(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		serviceVoyage.createRoadBook(roadBook);
	}

	public List<RoadBook> readRoadBookOrderById() {
		return serviceVoyage.readRoadBookOrderById();
	}

	public void updateRoadBook(RoadBook roadBook) {
		serviceVoyage.updateRoadBook(roadBook);
		
	}

	public void deleteRoadBook(int id) {
		serviceVoyage.deleteRoadBook(id);
	}

	public RoadBook getRoadBookById(int id) {
		return serviceVoyage.getRoadBookById(id);
	}

	public RoadBook getRoadBookByUserId(int id) {
		return serviceVoyage.getRoadBookByUserId(id);
	}
	
	public void createPOInteret(PointInteret pointInteret) {
		serviceVoyage.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderById() {
		return serviceVoyage.readPOInteretOrderById();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		serviceVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		serviceVoyage.deletePOInteret(id);
	}

	public PointInteret getPOInteretById(int id) {
		return serviceVoyage.getPOInteretById(id);
	}



}
