package dao.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.exception.uc4Voyage.DaoVoyageException;
import entity.uc4Voyage.EntityVoyage;


@Singleton
@LocalBean
public class DaoFacadeVoyage {

	private static final String ZONE_EXCEPTION_MSG = ".Bdd";
	
	@EJB
	private DaoVoyage daoVoyage;

	private FactoryEntity factoryEntity = new FactoryEntity();
	
	public Voyage createVoyage(Voyage voyage) throws DaoVoyageException {
		EntityVoyage entityVoyage = factoryEntity.createEntityFrom(voyage);
			try {
				return factoryEntity.createFromEntity(daoVoyage.create(entityVoyage));
			} catch (DaoVoyageException e) {
				throw new DaoVoyageException(e.getCode(),
						ZONE_EXCEPTION_MSG+ e.getMessage());
			}
	}

	public List<Voyage> readVoyageOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

	public Voyage updateVoyage(Voyage voyage) throws DaoVoyageException {
		EntityVoyage entityVoyage = factoryEntity.createEntityWithIDFrom(voyage);
		try {
			return factoryEntity.createFromEntity(daoVoyage.update(entityVoyage));
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}

	}

	public void deleteVoyage(int id) throws DaoVoyageException {
		try {
			daoVoyage.delete(id, EntityVoyage.class);
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public Voyage getVoyageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoadBook createRoadBook(RoadBook roadBook) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RoadBook> readRoadBookOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

	public RoadBook updateRoadBook(RoadBook roadBook) {
		// TODO Auto-generated method stub
		return null;

	}

	public void deleteRoadBook(int id) {
		// TODO Auto-generated method stub

	}

	public RoadBook getRoadBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RoadBook getRoadBookByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PointInteret createPOInteret(PointInteret pointInteret) {
		// TODO Auto-generated method stub
		return null;

	}

	public List<PointInteret> readPOInteretOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) {
		// TODO Auto-generated method stub
		return null;

	}

	public void deletePOInteret(int id) {
		// TODO Auto-generated method stub

	}

	public PointInteret getPOInteretById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
