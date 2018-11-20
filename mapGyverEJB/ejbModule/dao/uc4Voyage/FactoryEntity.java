package dao.uc4Voyage;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;

public class FactoryEntity {

	public FactoryEntity() {
		super();
	}

	public EntityVoyage createEntityFrom(Voyage voyage) {
		String nom 			= voyage.getNom();
		LocalDate dateDebut = voyage.getDateDebut();
		int nbParticipant 	= voyage.getNbParticipant();
		
		return new EntityVoyage(nom, dateDebut, nbParticipant);
	}

}
