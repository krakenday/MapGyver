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
	
	private ControlVoyage controlVoyage = new ControlVoyage();

	public Voyage createVoyage(Voyage voyage) throws ServiceVoyageException {
		checkRGVoyage(voyage);
		return serviceVoyage.createVoyage(voyage);
	}

	public List<Voyage> readVoyageOrderById() throws ServiceVoyageException {
		return serviceVoyage.readVoyageOrderById();
	}

	public Voyage updateVoyage(Voyage voyage) throws ServiceVoyageException {
		checkRGVoyage(voyage);
		return serviceVoyage.updateVoyage(voyage);
	}

	public void deleteVoyage(int id) throws ServiceVoyageException {
		serviceVoyage.deleteVoyage(id);
	}

	public Voyage getVoyageById(int id) throws ServiceVoyageException {
		return serviceVoyage.getVoyageById(id);
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		return serviceVoyage.createRoadBook(roadBook);
	}

	public List<RoadBook> readRoadBookOrderById() throws ServiceVoyageException {
		return serviceVoyage.readRoadBookOrderById();
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		for (Voyage voyage : roadBook.getVoyages()) {
			checkRGVoyage(voyage);
		}
		return serviceVoyage.updateRoadBook(roadBook);
	}

	public void deleteRoadBook(int id) throws ServiceVoyageException {
		serviceVoyage.deleteRoadBook(id);
	}

	public RoadBook getRoadBookById(int id) throws ServiceVoyageException {
		return serviceVoyage.getRoadBookById(id);
	}

	public RoadBook getRoadBookByUserId(int id) throws ServiceVoyageException {
		return serviceVoyage.getRoadBookByUserId(id);
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws ServiceVoyageException {
		return serviceVoyage.getRoadBookByUser(utilisateur);
	}
	
	public PointInteret createPOInteret(PointInteret pointInteret) throws ServiceVoyageException {
		return serviceVoyage.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderById() throws ServiceVoyageException {
		return serviceVoyage.readPOInteretOrderById();
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) throws ServiceVoyageException {
		return serviceVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) throws ServiceVoyageException {
		serviceVoyage.deletePOInteret(id);
	}

	public PointInteret getPOInteretById(int id) throws ServiceVoyageException {
		return serviceVoyage.getPOInteretById(id);
	}

	private void checkRGVoyage(Voyage voyage) throws ServiceVoyageException {
		try {
			controlVoyage.checkVoyage(voyage);
		} catch (VoyageRGException e) {
			throw new ServiceVoyageException(e.getMessage());
		}
	}




}
