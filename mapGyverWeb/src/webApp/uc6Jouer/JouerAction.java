package webApp.uc6Jouer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc2Souvenir.Photo;
import business.uc6Jouer.ElirePhoto;
import business.uc6Jouer.Jeu;
import business.uc6Jouer.ReponseElire;
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
	private Jeu jeu;
	private ElirePhoto jeuElire;
	private Photo photo;
	private Collection<Photo> photos;
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
		Utilisateur utilisateur = service.getUserByEmail(sessionAttributes.get("inputEmail").toString());
		setPhoto(service.getPhotoById(idPhoto));
		ReponseElire reponseElire = new ReponseElire(jeu, utilisateur, LocalDate.now(), photo);
		System.out.println("ReponseElireAction ==>" + reponseElire);
		String retour = SUCCESS;
		return retour;
	}

	public int getIdJeu() {
		return idJeu;
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(int idJeu) {
		init();
		try {
			this.jeu = service.getJeuById(idJeu);
		} catch (ExceptionSurDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ElirePhoto getJeuElire() {
		return jeuElire;
	}

	public void setJeuElire(ElirePhoto jeuElire) {
		this.jeuElire = jeuElire;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Collection<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

	@Override
	public String execute() {
		setJeu(this.idJeu);
		return SUCCESS;
	}

}
