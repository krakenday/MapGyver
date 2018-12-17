package service.uc4Voyage;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;


public class ControlVoyage {

	public ControlVoyage() {
	}

	public void checkVoyage(Voyage voyage) throws VoyageRGException {
		controlNom(voyage.getNom());
		controlDateDebut(voyage.getDateDebut());
		controlNbParticipant(voyage.getNbParticipant());		
	}

	private void controlNom(String nom) throws VoyageRGException {
		if (nom==null || nom.isBlank()) throw new VoyageRGException("Nom du voyage obligatoire");	
		else {
			if (nom.length()>50) throw new VoyageRGException("Nom du voyage trop long");
			if (nom.contains("Paris")) throw new VoyageRGException("Terme incorrect");
		}
	}

	private void controlDateDebut(LocalDate dateDebut) {
		// TODO Auto-generated method stub
		
	}

	private void controlNbParticipant(Integer nbParticipant) throws VoyageRGException {
		if (nbParticipant!=null) {
			if (nbParticipant<0) throw new VoyageRGException("Nombre de participants incorrect");	
			if (nbParticipant>100) throw new VoyageRGException("Nombre de participants élevé");	
		}	
	}
	
    
    
    
    
}
