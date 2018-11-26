package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import service.exception.uc4Voyage.ServiceVoyageException;
import service.uc4Voyage.ServiceFacadeVoyage;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {

	@EJB
	private ServiceFacadeVoyage serviceFacadeVoyage;

	@Override
	public void createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.createVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}
	}

	@Override
	public List<Voyage> readVoyageOrderByID() {
		//return serviceFacadeVoyage.readVoyageOrderByID();	
		return null;
	}

	@Override
	public void updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.updateVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	@Override
	public void deleteVoyage(int id) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.deleteVoyage(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}		
	}

	@Override
	public Voyage findVoyagebyID(int id) {
		//		return serviceFacadeVoyage.findVoyagebyID(id);
		return null;
	}

	@Override
	public void createRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.createRoadBook(roadBook);	
	}

	@Override
	public List<RoadBook> readRoadBookOrderByID() {
		//		return serviceFacadeVoyage.readRoadBookOrderByID();
		return null;
	}

	@Override
	public void updateRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.updateRoadBook(roadBook);	
	}

	@Override
	public void deleteRoadBook(int id) {
		//		serviceFacadeVoyage.deleteRoadBook(id);

	}

	@Override
	public RoadBook findRoadBookbyID(int id) {
		//		return serviceVoyage.findRoadBookbyID(id);
		return null;
	}

	@Override
	public void createPOInteret(PointInteret pointInteret) {
		//		serviceVoyage.createPOInteret(pointInteret);		
	}

	@Override
	public List<PointInteret> readPOInteretOrderByID() {
		//		return serviceVoyage.readPOInteretOrderByID();
		return null;
	}

	@Override
	public void updatePOInteret(PointInteret pointInteret) {
		//		serviceVoyage.updatePOInteret(pointInteret);	

	}

	@Override
	public void deletePOInteret(int id) {
		//		serviceVoyage.deletePOInteret(id);
	}

	@Override
	public PointInteret findPOInteretByID(int id) {
		//		return serviceVoyage.findPOInteretByID(id);
		return null;
	}



}
