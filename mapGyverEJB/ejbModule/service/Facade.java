package service;

import clientServeur.IServiceFacade;
import dao.DaoFacade;
import service.uc4Voyage.ServiceVoyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@Remote(IServiceFacade.class)
public class Facade implements IServiceFacade {

	//private ServiceVoyage serviceVoyage = new ServiceVoyage();
	

	@EJB
	DaoFacade daoFacade ;
	
	public Facade() {
	}

	@Override
	public void createVoyage(Voyage voyage) {
		System.out.println("do Facade.serviceVoyage.createVoyage(voyage) " + voyage);
		daoFacade.createVoyage(voyage);		
	}

	@Override
	public List<Voyage> readVoyageOrderByID() {
		//return serviceVoyage.readVoyageOrderByID();	
		return null;
	}

	@Override
	public void updateVoyage(Voyage voyage) {
//		serviceVoyage.updateVoyage(voyage);			
	}

	@Override
	public void deleteVoyage(int id) {
//		serviceVoyage.deleteVoyage(id);			
	}

	@Override
	public Voyage findVoyagebyID(int id) {
//		return serviceVoyage.findVoyagebyID(id);
		return null;
	}

	@Override
	public void createRoadBook(RoadBook roadBook) {
//		serviceVoyage.createRoadBook(roadBook);	
	}

	@Override
	public List<RoadBook> readRoadBookOrderByID() {
//		return serviceVoyage.readRoadBookOrderByID();
		return null;
	}

	@Override
	public void updateRoadBook(RoadBook roadBook) {
//		serviceVoyage.updateRoadBook(roadBook);	
	}

	@Override
	public void deleteRoadBook(int id) {
//		serviceVoyage.deleteRoadBook(id);
		
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
