package dao.uc4Voyage;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;
import entity.uc4Voyage.EntityVoyage;

public class FactoryEntity {

	public FactoryEntity() {
		super();
	}

	public EntityVoyage createEntityFrom(Voyage voyage) {
		String nom 				= voyage.getNom();
		LocalDate dateDebut 	= voyage.getDateDebut();
		Integer nbParticipant 	= voyage.getNbParticipant();
		return new EntityVoyage(nom, dateDebut, nbParticipant);
	}

	public EntityVoyage createEntityWithIDFrom(Voyage voyage) {
		EntityVoyage entityVoyage = createEntityFrom(voyage);
		entityVoyage.setId(voyage.getId());
		return entityVoyage;
	}

}
