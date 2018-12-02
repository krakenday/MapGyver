package service.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;
import dao.exception.uc4Voyage.DaoFacadeExceptionVoyage;
import service.exception.uc4Voyage.ServiceVoyageException;

@Singleton
@LocalBean
public class ServiceVoyage {

	@EJB
	private DaoFacade daoFacade;

	public Voyage createVoyage(Voyage voyage) throws ServiceVoyageException {
		try {
			return daoFacade.createVoyage(voyage);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderById() {
		return daoFacade.readVoyageOrderById();
	}

	public Voyage updateVoyage(Voyage voyage) throws ServiceVoyageException {
		try {
			return daoFacade.updateVoyage(voyage);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public void deleteVoyage(int id) throws ServiceVoyageException {
		try {
			daoFacade.deleteVoyage(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public Voyage getVoyageById(int id) {
		return daoFacade.getVoyageById(id);
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		try {
			System.out.println("ServiceVoyage createRoadBook");
			return daoFacade.createRoadBook(roadBook);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public List<RoadBook> readRoadBookOrderById() {
		return daoFacade.readRoadBookOrderById();
	}

	public RoadBook updateRoadBook(RoadBook roadBook) {
		return daoFacade.updateRoadBook(roadBook);

	}

	public void deleteRoadBook(int id) {
		daoFacade.deleteRoadBook(id);
	}

	public RoadBook getRoadBookById(int id) {
		return daoFacade.getRoadBookById(id);
	}

	public RoadBook getRoadBookByUserId(int id) {
		return daoFacade.getRoadBookByUserId(id);
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws ServiceVoyageException {
		try {
			System.out.println("ServiceVoyage getRoadBookByUser");
			return daoFacade.getRoadBookByUser(utilisateur);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public PointInteret createPOInteret(PointInteret pointInteret) {
		return daoFacade.createPOInteret(pointInteret);
	}

	public List<PointInteret> readPOInteretOrderById() {
		return daoFacade.readPOInteretOrderById();
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) {
		return daoFacade.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daoFacade.deletePOInteret(id);
	}

	public PointInteret getPOInteretById(int id) {
		return daoFacade.getPOInteretById(id);
	}



}
