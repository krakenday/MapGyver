package webApp.uc6Jouer;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc2Souvenir.Photo;
import business.uc6Jouer.Jeu;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;
import webApp.ApplicationSupport;

public class JouerAction extends ApplicationSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private IServiceFacade service;
	private Jeu jeu;
	private Photo photo;
	private Map<String, Object> sessionAttributes = null;

	public void init() {
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String repondreElire() throws ServiceInexistantException, ExceptionSurDao {
		init();
		Utilisateur Utilisateur = service.getUserByEmail(sessionAttributes.get("inputEmail").toString());
		// Jeu jeu = service.getJeuById(idJeu);
		service.listJeu();
		String retour = SUCCESS;
		return retour;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

}
