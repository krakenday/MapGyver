package webApp.uc4Voyage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Preparable;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import webApp.ApplicationSupport;

public class VoyageAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;

	private static final String ROADBOOK_SUCCESS 	= "ROADBOOK_SUCCESS";
	private static final String ROADBOOK_ERROR 		= "ROADBOOK_ERROR";
	private static final String VOYAGE_SUCCESS 		= "VOYAGE_SUCCESS";
	private static final String VOYAGE_ERROR 		= "VOYAGE_ERROR";

	private IServiceFacade serviceMpg;
	private Utilisateur utilisateur;
	private RoadBook roadBook;
	private Voyage voyage;
	private String success;
	private String probleme;

	// variables pour injecter l'instance de la session          
	private Map<String, Object> sessionAttributes = null;

	// id du voyage
	public String id;
	
	// element du formulaire voyage
	public String 					inputNomVoyage;
	public String 					inputDateDebut;
	public String 					inputNbParticipant;
	public ArrayList<PointInteret> 	listPointInteret;
	
	@Override
	public void prepare() throws Exception {
		try {
			Context context = new InitialContext();
			serviceMpg = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
			probleme = null;
			success = null;
			utilisateur = getUser();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}     
	
	public String createRoadBook() {
		try {
			roadBook= getOrCreateUserRoadBook(utilisateur);
			success = ControleurVoyageMsg.SUCCESS_CREATE.getMsg();
			return ROADBOOK_SUCCESS;
		}	catch (ServiceFacadeExceptionVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_INSERT.getSolution() 
					+ " *Err. RoadBook" + e.getMessage();
			return ROADBOOK_ERROR;
		}
	}

	public String readRoadBook() {
		try {
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			return ROADBOOK_SUCCESS;
		} catch (ServiceFacadeExceptionVoyage e) {
			return ROADBOOK_ERROR;
		}	
	}

	public String deleteRoadBook() {
		try {
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			serviceMpg.deleteRoadBook(roadBook.getId());
			success = ControleurVoyageMsg.SUCCESS_DELETE.getMsg() 
					+ " roadBook #"+roadBook.getId();
			roadBook = null;
			return ROADBOOK_SUCCESS;
		} catch (ServiceFacadeExceptionVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+" *Err. "+ " *Err. RoadBook" + e.getMessage();
			return ROADBOOK_ERROR;
		}	
	}

	public String createVoyage() {
		try {
			roadBook = getOrCreateUserRoadBook(utilisateur);
			voyage = new Control().createVoyage(this);
			roadBook.addVoyage(voyage);
			roadBook = serviceMpg.updateRoadBook(roadBook);
			success = ControleurVoyageMsg.SUCCESS_INSERT.getMsg();
			return ROADBOOK_SUCCESS;
		} catch (ExceptionServiceVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_GET.getSolution() +" *Err. RoadBook"+ e.getMessage();
			return VOYAGE_ERROR;
		}	catch (ServiceFacadeExceptionVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_INSERT.getSolution() +" *Err. RoadBook"+ e.getMessage();
			return VOYAGE_ERROR;
		}
	}

	public String readVoyage() {
		try {
			int idVoyage = Integer.parseInt(id);
			voyage = serviceMpg.getVoyageById(idVoyage);
			setInfoVoyage();
			return VOYAGE_SUCCESS;
		} catch (Exception e) {
			return VOYAGE_ERROR;
		}	
	}

	private void setInfoVoyage() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		inputNomVoyage 		= voyage.getNom();
		inputDateDebut 		= voyage.getDateDebut().format(formatter);
		inputNbParticipant 	= voyage.getNbParticipant().toString();
		// TODO set POInteret
	}

	public String updateVoyage() {
		try {
			voyage = new Control().createVoyage(this);
			voyage.setId(Integer.parseInt(id));
			serviceMpg.updateVoyage(voyage);
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			success = ControleurVoyageMsg.SUCCESS_UPDATE.getMsg();
			return ROADBOOK_SUCCESS;
		} catch (ExceptionServiceVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_SAISIES.getSolution() +" *Err. "+ e.getMessage();
			return VOYAGE_ERROR;
		} catch (ServiceFacadeExceptionVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_UPDATE.getSolution() +" *Err. Voyage"+ e.getMessage();
			return VOYAGE_ERROR;
		}

	}

	public String deleteVoyage() {
		try {
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			int idVoyage = Integer.parseInt(id);
			roadBook.removeVoyageById(idVoyage);
			roadBook = serviceMpg.updateRoadBook(roadBook);
			serviceMpg.deleteVoyage(idVoyage);
			success = ControleurVoyageMsg.SUCCESS_DELETE.getMsg() 
					+ " voyage #"+idVoyage;
			return ROADBOOK_SUCCESS;
		} catch (ServiceFacadeExceptionVoyage e) {
			probleme = ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+ " *Err. Voyage" + e.getMessage();
			return ROADBOOK_ERROR;
		} catch (NumberFormatException e) {
			probleme = ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
					+" *Err. "+ e.getMessage();
			return ROADBOOK_ERROR;
		} 
	}	

	private Utilisateur getUser() {
		Utilisateur user = new Utilisateur();
		user.setId(401);
		user.setEmail("i.mohamady@gmail.com");
		return user;
	}	

	private RoadBook getOrCreateUserRoadBook(Utilisateur utilisateur) throws ServiceFacadeExceptionVoyage{
		try {
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
		} catch (ServiceFacadeExceptionVoyage e) {
			roadBook = serviceMpg.createRoadBook(new RoadBook(utilisateur));
		}
		return roadBook;
	}

	/**
	 * methode à surcharger pour faire le lien entre 
	 * la session gérée par sessionAware et notre propriete 
	 * sessionAttributes
	 */
	@Override    
	public void setSession(Map<String, Object> sessionAttr) {        
		this.sessionAttributes = sessionAttr;    
	}

	public IServiceFacade getServiceMpg() {
		return serviceMpg;
	}

	public void setServiceMpg(IServiceFacade serviceMpg) {
		this.serviceMpg = serviceMpg;
	}

	public RoadBook getRoadBook() {
		return roadBook;
	}

	public void setRoadBook(RoadBook roadBook) {
		this.roadBook = roadBook;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getProbleme() {
		return probleme;
	}

	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getInputNomVoyage() {
		return inputNomVoyage;
	}
	public void setInputNomVoyage(String inputNomVoyage) {
		this.inputNomVoyage = inputNomVoyage;
	}

	public ArrayList<PointInteret> getListPointInteret() {
		return listPointInteret;
	}
	public void setListPointInteret(ArrayList<PointInteret> listPointInteret) {
		this.listPointInteret = listPointInteret;
	}
	public String getInputDateDebut() {
		return inputDateDebut;
	}
	public void setInputDateDebut(String inputDateDebut) {
		this.inputDateDebut = inputDateDebut;
	}
	public String getInputNbParticipant() {
		return inputNbParticipant;
	}
	public void setInputNbParticipant(String inputNbParticipant) {
		this.inputNbParticipant = inputNbParticipant;
	}


}