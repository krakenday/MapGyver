package webApp.uc6Jouer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Preparable;

import business.uc2Souvenir.Photo;
import clientServeur.IServiceFacade;
import webApp.ApplicationSupport;

public class JeuAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> sessionAttributes = null;
	private IServiceFacade service;
	private ArrayList<Photo> photos;
	private LocalDate dateFinInscription;
	private LocalDate dateFin;
	private LocalDate dateDebut;
	private String nomJeu;

	@Override
	public void prepare() throws Exception {
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

	public String execute() {
		photos = service.uc1GetAllPhoto();
		return SUCCESS;

	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public LocalDate getDateFinInscription() {
		return dateFinInscription;
	}

	public void setDateFinInscription(LocalDate dateFinInscription) {
		this.dateFinInscription = dateFinInscription;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

}
