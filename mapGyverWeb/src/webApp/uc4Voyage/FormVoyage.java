package webApp.uc4Voyage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;

import business.uc4Voyage.Voyage;

public class FormVoyage {

	private HttpServletRequest request;


	public FormVoyage(HttpServletRequest request) {
		this.request = request;
	}

	public Voyage createVoyage() throws ExceptionServiceVoyage {
		Voyage voyage = new Voyage(controlTitre());
		voyage.setDateDebut(controlDate());
		voyage.setNbParticipant(controlParticipant());
		return voyage;
	}
	
	private String controlTitre() throws ExceptionServiceVoyage {
		if (request.getParameter("titre").isEmpty()) throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.TITRE);
		return request.getParameter("titre");
	}
	
	private LocalDate controlDate() throws ExceptionServiceVoyage {
		LocalDate date = null;
		try {
			if (!request.getParameter("depart").isEmpty())
				date = LocalDate.parse(request.getParameter("depart"), DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		} catch (DateTimeParseException e) {
			throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.DATE);
		}
		return date;
	}

	private Integer controlParticipant() throws ExceptionServiceVoyage {
		Integer nb = null;
		try {
			if (!request.getParameter("quantite").isEmpty()) {
				nb = Integer.parseInt(request.getParameter("quantite"));
				if (nb<0) throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.PARTICIPANTS);
			}
		} catch (NumberFormatException e) {
			throw new ExceptionServiceVoyage(ExceptionServiceVoyage.ERROR_MSG.PARTICIPANTS);
		}
		return nb;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
