package entity.uc4Voyage;

import java.util.ArrayList;
import java.util.List;

import business.uc4Voyage.Coordonnee;
import business.uc4Voyage.Lieu;
import business.uc4Voyage.Pays;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Ville;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityUtilisateur;

public class FactoryEntity {

	public FactoryEntity() {
		super();
	}

	public EntityVoyage createEntityFrom(Voyage voyage) {
		EntityVoyage entityVoyage = new EntityVoyage(voyage.getNom());
		entityVoyage.setDateDebut(voyage.getDateDebut());
		entityVoyage.setNbParticipant(voyage.getNbParticipant());
		return entityVoyage;
	}

	public EntityVoyage createEntityWithIdFrom(Voyage voyage) {
		EntityVoyage entityVoyage = createEntityFrom(voyage);
		entityVoyage.setId(voyage.getId());
		return entityVoyage;
	}

	public Voyage createFromEntity(EntityVoyage entityVoyage) {
		Voyage voyage = new Voyage(entityVoyage.getNom());
		voyage.setId(entityVoyage.getId());
		voyage.setDateDebut(entityVoyage.getDateDebut());
		voyage.setNbParticipant(entityVoyage.getNbParticipant());
		voyage.setPointInteret(createFromEntityPOI(entityVoyage.getEntityPointInteret()));
		return voyage;
	}

	private List<EntityVoyage> createEntityFrom(List<Voyage> voyages) {
		List<EntityVoyage> entityVoyages = new ArrayList<>();
		for (Voyage voyage : voyages) {
			EntityVoyage entityVoyage = createEntityFrom(voyage);
			entityVoyages.add(entityVoyage);
		}
		return entityVoyages;
	}

	private List<EntityVoyage> createEntityWithIdFrom(List<Voyage> voyages) {
		List<EntityVoyage> entityVoyages = new ArrayList<>();
		for (Voyage voyage : voyages) {
			EntityVoyage entityVoyage = createEntityWithIdFrom(voyage);
			entityVoyages.add(entityVoyage);
		}
		return entityVoyages;
	}

	private List<Voyage> createFromEntity(List<EntityVoyage> entityVoyages) {
		List<Voyage> voyages = new ArrayList<>();
		for (EntityVoyage entityVoyage : entityVoyages) {
			Voyage voyage = createFromEntity(entityVoyage);
			voyages.add(voyage);
		}
		return voyages;
	}

	public EntityRoadBook createEntityFrom(RoadBook roadBook) {
		EntityRoadBook entityRoadBook = new EntityRoadBook();
		entityRoadBook.setVoyages(createEntityFrom(roadBook.getVoyages()));;
		Utilisateur utilisateur = roadBook.getUtilisateur();
		EntityUtilisateur entityUtilisateur = new EntityUtilisateur();
		entityUtilisateur.setId(utilisateur.getId());
		entityRoadBook.setEntityUtilisateur(entityUtilisateur);
		return entityRoadBook;
	}

	public EntityRoadBook createEntityWithIdFrom(RoadBook roadBook) {
		EntityRoadBook entityRoadBook = new EntityRoadBook();
		entityRoadBook.setVoyages(createEntityWithIdFrom(roadBook.getVoyages()));;
		Utilisateur utilisateur = roadBook.getUtilisateur();
		EntityUtilisateur entityUtilisateur = new EntityUtilisateur();
		entityUtilisateur.setId(utilisateur.getId());
		entityRoadBook.setEntityUtilisateur(entityUtilisateur);
		entityRoadBook.setId(roadBook.getId());
		return entityRoadBook;
	}


	public RoadBook createFromEntity(EntityRoadBook entityRoadBook) {
		EntityUtilisateur entityUtilisateur = entityRoadBook.getEntityUtilisateur();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(entityUtilisateur.getId());
		RoadBook roadBook = new RoadBook(utilisateur);
		roadBook.setId(entityRoadBook.getId());
		roadBook.setVoyages(createFromEntity(entityRoadBook.getVoyages()));
		return roadBook;
	}

	public List<PointInteret> createFromEntityPOI(List<EntityPointInteret> listEntityPOI) {
		List<PointInteret> listPOI = new ArrayList<>();
		for (EntityPointInteret entityPOI : listEntityPOI) {
			PointInteret pointInteret = PointInteretCreateFromEntity(entityPOI);
			listPOI.add(pointInteret);
		}
		return listPOI;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends PointInteret> T PointInteretCreateFromEntity(EntityPointInteret entityPOI) {
		if (entityPOI instanceof EntityLieu) return (T) createFromEntity((EntityLieu)entityPOI);
		else if (entityPOI instanceof EntityVille) return (T) createFromEntity((EntityVille)entityPOI);
		else if (entityPOI instanceof EntityPays) return (T) createFromEntity((EntityPays)entityPOI);
		else return null;
	}

	public Coordonnee createFromEntity(EntityCoordonnee entityCoordonnee) {
		Coordonnee coordonnee = null;
		if (entityCoordonnee !=null) {
			coordonnee = new Coordonnee(entityCoordonnee.getLatitude(), entityCoordonnee.getLongitude());
		}
		return coordonnee;
	}

	public Coordonnee createFromEntityWithId(EntityCoordonnee entityCoordonnee) {
		Coordonnee coordonnee = null;
		if (entityCoordonnee !=null) {
			coordonnee = createFromEntity(entityCoordonnee);
			coordonnee.setId(entityCoordonnee.getId());
		}
		return coordonnee;
	}

	public EntityCoordonnee createEntityFrom(Coordonnee coordonnee) {
		EntityCoordonnee entityCoord = null;
		if (coordonnee !=null) {
			entityCoord = new EntityCoordonnee(coordonnee.getLatitude(), coordonnee.getLongitude());
		}
		return entityCoord ;
	}

	public EntityCoordonnee createEntityWithIdFrom(Coordonnee coordonnee) {
		EntityCoordonnee entityCoord = null;
		if (coordonnee !=null) {
			entityCoord = createEntityFrom(coordonnee);
			entityCoord.setId(coordonnee.getId());
		}
		return entityCoord ;
	}
	
	public Pays createFromEntity(EntityPays entityPays) {
		Pays pays = null;
		if (entityPays!=null) {
			pays = new Pays(entityPays.getNom());
			pays.setCoordonnee(createFromEntity(entityPays.getCoordonnee()));
		}
		return pays;
	}

	public Lieu createFromEntity(EntityLieu entityLieu) {
		Lieu lieu = null;
		if (entityLieu!=null) {
			lieu = new Lieu(entityLieu.getNom());
			lieu.setCoordonnee(createFromEntity(entityLieu.getCoordonnee()));
			lieu.setVille(createFromEntity(entityLieu.getVille()));
		}
		return lieu;
	}

	public Ville createFromEntity(EntityVille entityVille) {
		Ville ville = null;
		if (entityVille!=null) {
			ville = new Ville(entityVille.getNom());
			ville.setCoordonnee(createFromEntity(entityVille.getCoordonnee()));
			ville.setPays(createFromEntity(entityVille.getPays()));
		}
		return ville;
	}
}
