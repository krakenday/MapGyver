package dao.uc4Voyage;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.exception.uc4Voyage.DaoVoyageErrorMessage;
import dao.exception.uc4Voyage.DaoVoyageException;
import dao.uc1Administrer.DaoAdmin;
import entity.uc4Voyage.EntityRoadBook;
import entity.uc4Voyage.EntityVoyage;
import entity.uc8Utilisateur.EntityUtilisateur;


@Singleton
@LocalBean
public class DaoFacadeVoyage {

	private static final String ZONE_EXCEPTION_MSG = ".Bdd";

	@EJB
	private DaoGenericVoyage daoGenericVoyage;
	@EJB
	private DaoAdmin daoAdmin;

	private FactoryEntity factoryEntity = new FactoryEntity();

	public Voyage createVoyage(Voyage voyage) throws DaoVoyageException {
		EntityVoyage entityVoyage = factoryEntity.createEntityFrom(voyage);
		try {
			return factoryEntity.createFromEntity(daoGenericVoyage.create(entityVoyage));
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
			return factoryEntity.createFromEntity(daoGenericVoyage.update(entityVoyage));
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}

	}

	public void deleteVoyage(int id) throws DaoVoyageException {
		try {
			daoGenericVoyage.delete(id, EntityVoyage.class);
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public Voyage getVoyageById(int id) throws DaoVoyageException {
		try {
			return factoryEntity.createFromEntity(daoGenericVoyage.find(id, EntityVoyage.class));
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws DaoVoyageException {
		System.out.println("daoFacadeVoyage createRoadBook");
		System.out.println(roadBook);
		try {
			EntityRoadBook entityRoadBook = factoryEntity.createEntityFrom(roadBook);
			Utilisateur utilisateur = roadBook.getUtilisateur();
			EntityUtilisateur entityUtilisateur = daoAdmin.getUserByEmail(utilisateur.getEmail());
			entityRoadBook.setEntityUtilisateur(entityUtilisateur);
			return factoryEntity.createFromEntity(daoGenericVoyage.create(entityRoadBook));
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		} catch (DaoInexistantException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INSERT);
		}
	}

	public List<RoadBook> readRoadBookOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws DaoVoyageException {
		EntityRoadBook entityRoadBook = factoryEntity.createEntityWithIDFrom(roadBook);
		System.out.println("daoFacadeVoyage updateRoadBook");
		System.out.println(roadBook);
		System.out.println(entityRoadBook);
		try {
			entityRoadBook = daoGenericVoyage.update(entityRoadBook);
			return factoryEntity.createFromEntity(entityRoadBook);
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		} 
	}

	public void deleteRoadBook(int id) throws DaoVoyageException {
		try {
			daoGenericVoyage.delete(id, EntityRoadBook.class);
		} catch (DaoVoyageException e) {
			throw new DaoVoyageException(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}

	}

	public RoadBook getRoadBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoadBook getRoadBookByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws DaoVoyageException {
		RoadBook roadBook = null;
		try {
			EntityUtilisateur entityUtilisateur = daoAdmin.getUserByEmail(utilisateur.getEmail());
			EntityRoadBook entityRoadBook = daoGenericVoyage.getOneToOneBySecondClassId(
					"EntityRoadBook", "entityUtilisateur", "id", entityUtilisateur.getId());
			System.out.println(entityRoadBook);
			if (entityRoadBook!=null) roadBook = factoryEntity.createFromEntity(entityRoadBook);
		} catch (DaoInexistantException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT);
		}
		return roadBook;
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
