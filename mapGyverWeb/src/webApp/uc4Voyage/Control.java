package webApp.uc4Voyage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.Voyage;

public class Control {

	public Control() {
		// TODO Auto-generated constructor stub
	}

	public Voyage createVoyage(VoyageAction voyageAction) throws ExceptionServiceVoyage {
		String nom 								= voyageAction.inputNomVoyage;
		String dateDebut 						= voyageAction.inputDateDebut;
		String nbParticipant 					= voyageAction.inputNbParticipant;
		ArrayList<PointInteret> pointInteret 	= voyageAction.listPointInteret;
		return controleVoyage(nom, dateDebut, nbParticipant, pointInteret);
	}

	private Voyage controleVoyage(String nom, String dateDebut, String nbParticipant,
			ArrayList<PointInteret> pointInteret) throws ExceptionServiceVoyage {
		Voyage voyage = new Voyage(controlTitre(nom));
		voyage.setDateDebut(controlDate(dateDebut));
		voyage.setNbParticipant(controlParticipant(nbParticipant));
		voyage.setPointInteret(controlPOI(pointInteret));
		return voyage;
	}

	private String controlTitre(String nom) throws ExceptionServiceVoyage {
		if (nom==null || nom.isBlank())
			throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.TITRE);
		return nom;
	}

	private Integer controlParticipant(String nbParticipant) throws ExceptionServiceVoyage {
		Integer nb = null;
		if (!nbParticipant.isBlank()) {
			try {
				nb = Integer.parseInt(nbParticipant);
				if (nb<0) throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.PARTICIPANTS);
			} catch (NumberFormatException e) {
				throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.PARTICIPANTS);
			}
		}
		return nb;
	}

	private LocalDate controlDate(String dateDebut) throws ExceptionServiceVoyage {
		LocalDate date = null;
		if (!dateDebut.isBlank()) {
			try {
				date = LocalDate.parse((dateDebut), DateTimeFormatter.ofPattern("uuuu-MM-dd"));
			}	catch (DateTimeParseException e) {
				throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.DATE);
			}
		}
		return date;
	}

	private ArrayList<PointInteret> controlPOI(ArrayList<PointInteret> pointInteret) {
		// TODO test ArrayList<PointInteret>
		return pointInteret;
	}

}
