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

	public List<Voyage> readVoyageOrderById() throws ServiceVoyageException {
		try {
			return daoFacade.readVoyageOrderById();
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
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

	public Voyage getVoyageById(int id) throws ServiceVoyageException {
		try {
			return daoFacade.getVoyageById(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		try {
			return daoFacade.createRoadBook(roadBook);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public List<RoadBook> readRoadBookOrderById() throws ServiceVoyageException {
		try {
			return daoFacade.readRoadBookOrderById();
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws ServiceVoyageException {
		try {
			return daoFacade.updateRoadBook(roadBook);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public void deleteRoadBook(int id) throws ServiceVoyageException {
		try {
			daoFacade.deleteRoadBook(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public RoadBook getRoadBookById(int id) throws ServiceVoyageException {
		try {
			return daoFacade.getRoadBookById(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public RoadBook getRoadBookByUserId(int id) throws ServiceVoyageException {
		try {
			return daoFacade.getRoadBookByUserId(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws ServiceVoyageException {
		try {
			return daoFacade.getRoadBookByUser(utilisateur);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public PointInteret createPOInteret(PointInteret pointInteret) throws ServiceVoyageException {
		try {
			return daoFacade.createPOInteret(pointInteret);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public List<PointInteret> readPOInteretOrderById() throws ServiceVoyageException {
		try {
			return daoFacade.readPOInteretOrderById();
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) throws ServiceVoyageException {
		try {
			return daoFacade.updatePOInteret(pointInteret);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public void deletePOInteret(int id) throws ServiceVoyageException {
		try {
			daoFacade.deletePOInteret(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}

	public PointInteret getPOInteretById(int id) throws ServiceVoyageException {
		try {
			return daoFacade.getPOInteretById(id);
		} catch (DaoFacadeExceptionVoyage e) {
			throw new ServiceVoyageException(e.getCode(),e.getMessage());
		}
	}



}
