package service.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import service.exception.uc4Voyage.ServiceVoyageException;


@Singleton
@LocalBean
public class ServiceFacadeVoyage {

	@EJB
	private ServiceVoyage serviceVoyage;

	public Voyage createVoyage(Voyage voyage) throws ServiceVoyageException {
		return serviceVoyage.createVoyage(voyage);
	}

	public List<Voyage> readVoyageOrderById() {
		return serviceVoyage.readVoyageOrderById();
	}

	public Voyage updateVoyage(Voyage voyage) throws ServiceVoyageException {
		return serviceVoyage.updateVoyage(voyage);
	}

	public void deleteVoyage(int id) throws ServiceVoyageException {
		serviceVoyage.deleteVoyage(id);
	}

	public Voyage getVoyageById(int id) throws ServiceVoyageException {
		return serviceVoyage.getVoyageById(id);
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		System.out.println("ServiceFAcadeVoyage createRoadBook");
		return serviceVoyage.createRoadBook(roadBook);
	}

	public List<RoadBook> readRoadBookOrderById() {
		return serviceVoyage.readRoadBookOrderById();
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		return serviceVoyage.updateRoadBook(roadBook);
	}

	public void deleteRoadBook(int id) throws ServiceVoyageException {
		serviceVoyage.deleteRoadBook(id);
	}

	public RoadBook getRoadBookById(int id) {
		return serviceVoyage.getRoadBookById(id);
	}

	public RoadBook getRoadBookByUserId(int id) {
		return serviceVoyage.getRoadBookByUserId(id);
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws ServiceVoyageException {
		return serviceVoyage.getRoadBookByUser(utilisateur);
	}
	
	public PointInteret createPOInteret(PointInteret pointInteret) {
		return serviceVoyage.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderById() throws ServiceVoyageException {
		return serviceVoyage.readPOInteretOrderById();
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) {
		return serviceVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		serviceVoyage.deletePOInteret(id);
	}

	public PointInteret getPOInteretById(int id) {
		return serviceVoyage.getPOInteretById(id);
	}





}
