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
import entity.uc4Voyage.EntityPointInteret;
import entity.uc4Voyage.EntityRoadBook;
import entity.uc4Voyage.EntityVoyage;
import entity.uc4Voyage.FactoryEntity;
import entity.uc8Utilisateur.EntityUtilisateur;


@Singleton
@LocalBean
public class DaoFacadeVoyage {
	
	/** Recuperer tous les roadBook (Requete nommee Voir META-INF orm.xml)  */
	private static final String UC4_FINDALL_ROADBOOK 	= "UC4_findAll_RoadBook";
	/** Recuperer tous les voyages (Requete nommee Voir META-INF orm.xml)  */
	private static final String UC4_FINDALL_VOYAGES 	= "UC4_findAll_Voyage";
	/** Recuperer tous les point d'interet (Requete nommee Voir META-INF orm.xml)  */
	private static final String UC4_FINDALL_POI 		= "UC4_findAll_POI";
	
	@EJB
	private DaoGenericVoyage daoGenericVoyage;
	
	@EJB
	private DaoAdmin daoAdmin;

	private FactoryEntity factoryEntity = new FactoryEntity();

	public Voyage createVoyage(Voyage voyage) throws DaoVoyageException {
		EntityVoyage entityVoyage = factoryEntity.createEntityFrom(voyage);
			return factoryEntity.createFromEntity(daoGenericVoyage.create(entityVoyage));
	}

	public List<Voyage> readVoyageOrderById() throws DaoVoyageException {
		List<EntityVoyage> listEntity = 
				daoGenericVoyage.findAll(EntityVoyage.class, UC4_FINDALL_VOYAGES);
		List<Voyage> list = factoryEntity.createFromEntity(listEntity);
		return list;
	}

	public Voyage updateVoyage(Voyage voyage) throws DaoVoyageException {
		EntityVoyage entityVoyage = factoryEntity.createEntityFrom(voyage);
			return factoryEntity.createFromEntity(daoGenericVoyage.update(entityVoyage));

	}

	public void deleteVoyage(int id) throws DaoVoyageException {
			daoGenericVoyage.delete(id, EntityVoyage.class);
	}

	public Voyage getVoyageById(int id) throws DaoVoyageException {
			return factoryEntity.createFromEntity(daoGenericVoyage.find(id, EntityVoyage.class));
	}

	public RoadBook createRoadBook(RoadBook roadBook) throws DaoVoyageException {
		try {
			EntityRoadBook entityRoadBook = factoryEntity.createEntityFrom(roadBook);
			Utilisateur utilisateur = roadBook.getUtilisateur();
			EntityUtilisateur entityUtilisateur = daoAdmin.getUserByEmail(utilisateur.getEmail());
			entityRoadBook.setEntityUtilisateur(entityUtilisateur);
			return factoryEntity.createFromEntity(daoGenericVoyage.create(entityRoadBook));
		} catch (DaoInexistantException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INSERT);
		}
	}

	public List<RoadBook> readRoadBookOrderById() throws DaoVoyageException {
		List<EntityRoadBook> listEntity = 
				daoGenericVoyage.findAll(EntityRoadBook.class, UC4_FINDALL_ROADBOOK);
		List<RoadBook> list = factoryEntity.createFromEntityRoadBook(listEntity);
		return list;
	}

	public RoadBook updateRoadBook(RoadBook roadBook) throws DaoVoyageException {
		EntityRoadBook entityRoadBook = factoryEntity.createEntityFrom(roadBook);
			entityRoadBook = daoGenericVoyage.update(entityRoadBook);
			return factoryEntity.createFromEntity(entityRoadBook);
	}

	public void deleteRoadBook(int id) throws DaoVoyageException {
			daoGenericVoyage.delete(id, EntityRoadBook.class);
	}

	public RoadBook getRoadBookById(int id) throws DaoVoyageException {
		return factoryEntity.createFromEntity(daoGenericVoyage.find(id, EntityRoadBook.class));
	}

	public RoadBook getRoadBookByUserId(int id) throws DaoVoyageException {
		RoadBook roadBook = null;
			EntityRoadBook entityRoadBook = daoGenericVoyage.getOneToOneBySecondClassId(
					"EntityRoadBook", "entityUtilisateur", "id", id);
			if (entityRoadBook!=null) roadBook = factoryEntity.createFromEntity(entityRoadBook);
		return roadBook;
	}

	public RoadBook getRoadBookByUser(Utilisateur utilisateur) throws DaoVoyageException {
		RoadBook roadBook = null;
			try {
				EntityUtilisateur entityUtilisateur = daoAdmin.getUserByEmail(utilisateur.getEmail());
				roadBook = getRoadBookByUserId(entityUtilisateur.getId());
			} catch (DaoInexistantException e) {
				throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT);
			}
		return roadBook;
	}

	public PointInteret createPOInteret(PointInteret pointInteret) throws DaoVoyageException {
		EntityPointInteret entityPointInteret= factoryEntity.createEntityFrom(pointInteret);
		EntityPointInteret entityPoi= daoGenericVoyage.create(entityPointInteret);
		return factoryEntity.createFromEntity(entityPoi);
	}

	public List<PointInteret> readPOInteretOrderById() throws DaoVoyageException {
		List<EntityPointInteret> listEntityPOI = 
				daoGenericVoyage.findAll(EntityPointInteret.class, UC4_FINDALL_POI);
		List<PointInteret> listPOI = factoryEntity.createFromEntityPOI(listEntityPOI);
		return listPOI;
	}

	public PointInteret updatePOInteret(PointInteret pointInteret) throws DaoVoyageException {
		EntityPointInteret entityPointInteret = factoryEntity.createEntityFrom(pointInteret);
			return factoryEntity.createFromEntity(daoGenericVoyage.update(entityPointInteret));

	}

	public void deletePOInteret(int id) throws DaoVoyageException {
		daoGenericVoyage.delete(id, EntityPointInteret.class);
	}

	public PointInteret getPOInteretById(int id) throws DaoVoyageException {
		return factoryEntity.createFromEntity(daoGenericVoyage.find(id, EntityPointInteret.class));
	}

}
