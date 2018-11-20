package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.exception.uc4Voyage.DaoFacadeErrorMessageVoyage;
import dao.exception.uc4Voyage.DaoFacadeExceptionVoyage;
import dao.exception.uc4Voyage.DaoVoyageException;
import dao.uc4Voyage.DaoFacadeVoyage;

@Singleton
@LocalBean
public class DaoFacade {

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";
	@EJB
	private DaoFacadeVoyage daoFacadeVoyage;

	public void createVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.createVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderByID() {
		return daoFacadeVoyage.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) {
		daoFacadeVoyage.updateVoyage(voyage);			
	}
	
	public void deleteVoyage(int id) {
		daoFacadeVoyage.deleteVoyage(id);
	}

	public Voyage findVoyagebyID(int id) {
		return daoFacadeVoyage.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.createRoadBook(roadBook);	
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return daoFacadeVoyage.readRoadBookOrderByID();	
	}

	public void updateRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.updateRoadBook(roadBook);	
	}

	public void deleteRoadBook(int id) {
		daoFacadeVoyage.deleteRoadBook(id);	
	}

	public RoadBook findRoadBookbyID(int id) {
		return daoFacadeVoyage.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.createPOInteret(pointInteret);
		
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return daoFacadeVoyage.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daoFacadeVoyage.deletePOInteret(id);		
	}

	public PointInteret findPOInteretByID(int id) {
		return daoFacadeVoyage.findPOInteretByID(id);	
	}

	
	
}
