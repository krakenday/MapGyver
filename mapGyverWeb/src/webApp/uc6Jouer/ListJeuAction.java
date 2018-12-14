package webApp.uc6Jouer;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Preparable;

import business.uc6Jouer.Jeu;
import business.uc6Jouer.Jeux;
import clientServeur.IServiceFacade;
import freemarker.template.utility.Execute;
import service.exception.uc6Jouer.ExceptionSurDao;
import webApp.ApplicationSupport;

public class ListJeuAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> sessionAttributes = null;
	private IServiceFacade service;
	private Jeux jeux;
	private Jeu jeu;

	@Override
	public void prepare() throws Exception {
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String listerJeu() {
		String retour = SUCCESS;
		try {
			jeux = service.listJeu();
		} catch (ExceptionSurDao e) {
			return ERROR;
		}
		return retour;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

	public Jeux getJeux() {
		return jeux;
	}

	public void setJeux(Jeux jeux) {
		this.jeux = jeux;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

}
