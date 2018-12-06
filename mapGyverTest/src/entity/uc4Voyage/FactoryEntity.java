package entity.uc4Voyage;

import java.util.ArrayList;
import java.util.List;

import business.uc4Voyage.Coordonnee;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
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

	public EntityVoyage createEntityWithIDFrom(Voyage voyage) {
		EntityVoyage entityVoyage = createEntityFrom(voyage);
		entityVoyage.setId(voyage.getId());
		return entityVoyage;
	}

	public Voyage createFromEntity(EntityVoyage entityVoyage) {
		Voyage voyage = new Voyage(entityVoyage.getNom());
		voyage.setId(entityVoyage.getId());
		voyage.setDateDebut(entityVoyage.getDateDebut());
		voyage.setNbParticipant(entityVoyage.getNbParticipant());
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

	private List<EntityVoyage> createEntityWithIDFrom(List<Voyage> voyages) {
		List<EntityVoyage> entityVoyages = new ArrayList<>();
		for (Voyage voyage : voyages) {
			EntityVoyage entityVoyage = createEntityWithIDFrom(voyage);
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

	public EntityRoadBook createEntityWithIDFrom(RoadBook roadBook) {
		EntityRoadBook entityRoadBook = new EntityRoadBook();
		entityRoadBook.setVoyages(createEntityWithIDFrom(roadBook.getVoyages()));;
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
	
	//TODO a finaliser
	public List<PointInteret> createFromEntityPOI(List<EntityPointInteret> listEntityPOI) {
		List<PointInteret> listPOI = new ArrayList<>();
		for (EntityPointInteret entityPOI : listEntityPOI) {
			PointInteret pointInteret = createFromEntity(entityPOI);
			listPOI.add(pointInteret);
		}
		return listPOI;
	}
	
	//TODO a finaliser
	private PointInteret createFromEntity(EntityPointInteret entityPOI) {
		PointInteret pointInteret = null;
		if (entityPOI instanceof EntityLieu) pointInteret = createFromEntity((EntityLieu)entityPOI);
		else if (entityPOI instanceof EntityVille) pointInteret = createFromEntity((EntityVille)entityPOI);
		else if (entityPOI instanceof EntityPays) pointInteret = createFromEntity((EntityPays)entityPOI);
		
		pointInteret.setNom(entityPOI.getNom());
		pointInteret.setId(entityPOI.getId());
		pointInteret.setCoordonnee(createFromEntity(entityPOI.getCoordonnee()));
		return pointInteret;
	}
	
	//TODO a finaliser
	private Coordonnee createFromEntity(EntityCoordonnee entityCoordonnee) {
		Coordonnee coordonnee = new Coordonnee(entityCoordonnee.getLatitude(), entityCoordonnee.getLongitude());
		coordonnee.setId(entityCoordonnee.getId());
		return null;
	}

}
