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
import service.exception.uc6Jouer.ExceptionSurDao;
import webApp.ApplicationSupport;

public class ListJeuAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> sessionAttributes = null;
	private IServiceFacade service;
	private int idJeu;
	private int idPhoto;
	private Jeux jeux;
	private Jeu jeu;
	private String msg;

	@Override
	public void prepare() throws Exception {
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String deletJeu() {
		String retour = "succesDelet";
		try {
			setJeu(service.getJeuById(idJeu));
			service.removeJeu(jeu);
			jeux = service.listJeu();
			addActionMessage("La suppression a ete effectué avec succes");

		} catch (ExceptionSurDao e) {
			addActionError("La suppression n'a pas été effectué");
			retour = ERROR;
		}
		return retour;
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

	public int getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
