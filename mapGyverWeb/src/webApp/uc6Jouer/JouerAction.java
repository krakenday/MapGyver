package webApp.uc6Jouer;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc6Jouer.Jeu;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;
import webApp.ApplicationSupport;

public class JouerAction extends ApplicationSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private IServiceFacade service;
	private int idJeu;
	private int idPhoto;
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

	public String listerJeu() {
		init();
		String retour = SUCCESS;
		return retour;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;

	}

}
