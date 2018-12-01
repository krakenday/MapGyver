package dao.uc4Voyage;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;
import entity.uc4Voyage.EntityVoyage;

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

}
