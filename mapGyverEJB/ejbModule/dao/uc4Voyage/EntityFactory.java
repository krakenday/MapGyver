package dao.uc4Voyage;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;

public class EntityFactory {

	public EntityFactory() {
		super();
	}

	public EntityVoyage createEntityFrom(Voyage voyage) {
//		int id 				= voyage.getId();
		String nom 			= voyage.getNom();
		LocalDate dateDebut = voyage.getDateDebut();
		int nbParticipant 	= voyage.getNbParticipant();
		
		return new EntityVoyage(nom, dateDebut, nbParticipant);
	}

}
