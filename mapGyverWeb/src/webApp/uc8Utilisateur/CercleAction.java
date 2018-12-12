package webApp.uc8Utilisateur;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import webApp.ApplicationSupport;

public class CercleAction extends ApplicationSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static final String SERVICE_FACADE_LOOKUP= "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private IServiceFacade iServiceFacade;
	private Map<String, Object> sessionAttributes = null; 
	
	private String inputNomGroupe;
	private String inputNomListe;
	
	
	private String msg;
	
	// Initialiser le context	
	public void init() {

		try {
			InitialContext context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(SERVICE_FACADE_LOOKUP);
			msg= null ;
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	
	public String addGroupe() {
		init();
		System.out.println("*** UtilisateurAction - addGroupe **********");	
		try {			
			Utilisateur utilisateur= (Utilisateur) sessionAttributes.get("utilisateur");
			System.out.println("*** UtilisateurAction - addGroupe: id utilisateur= " + utilisateur.getId());			

			Groupe groupe= new Groupe(inputNomGroupe, utilisateur);
			iServiceFacade.createGroupe(groupe);

			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String addListe() {
		init();
		System.out.println("*** UtilisateurAction - addListe **********");	
		try {			
			Utilisateur utilisateur= (Utilisateur) sessionAttributes.get("utilisateur");
			System.out.println("*** UtilisateurAction - addGroupe: id utilisateur= " + utilisateur.getId());			

			ListeDiffusion liste= new ListeDiffusion(inputNomListe, utilisateur);
			iServiceFacade.createListeDiff(liste);

			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	

	public String getInputNomGroupe() {
		return inputNomGroupe;
	}

	public void setInputNomGroupe(String inputNomGroupe) {
		this.inputNomGroupe = inputNomGroupe;
	}

	public String getInputNomListe() {
		return inputNomListe;
	}

	public void setInputNomListe(String inputNomListe) {
		this.inputNomListe = inputNomListe;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes= sessionAttr;
	}

}
