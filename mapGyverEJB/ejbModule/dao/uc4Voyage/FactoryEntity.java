package dao.uc4Voyage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import entity.uc4Voyage.EntityRoadBook;
import entity.uc4Voyage.EntityVoyage;
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
//		Utilisateur utilisateur = roadBook.getUtilisateur();
//		EntityUtilisateur entityUtilisateur = new EntityUtilisateur();
//		entityUtilisateur.setId(utilisateur.getId());
//		entityRoadBook.setEntityUtilisateur(entityUtilisateur);
//		entityRoadBook.setVoyages(createEntityFrom(roadBook.getVoyages()));
		return entityRoadBook;
	}
	
	public RoadBook createFromEntity(EntityRoadBook entityRoadBook) {
		RoadBook roadBook = new RoadBook();
		roadBook.setId(roadBook.getId());
		EntityUtilisateur entityUtilisateur = entityRoadBook.getEntityUtilisateur();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(entityUtilisateur.getId());
		roadBook.setUtilisateur(utilisateur);
//		roadBook.setVoyages(createFromEntity(entityRoadBook.getVoyages()));
		return roadBook;
	}

}
