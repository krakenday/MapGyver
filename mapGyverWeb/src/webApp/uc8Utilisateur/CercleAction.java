package webApp.uc8Utilisateur;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Preparable;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import utilitaire.UtilAction;
import webApp.ApplicationSupport;

public class CercleAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;
	
	private IServiceFacade iServiceFacade;
	private Map<String, Object> sessionAttributes = null; 
	
	private Groupe groupe;
	private ListeDiffusion listeDiff;

	// Ajouter un nouveau groupe
	public String addGroupe() {
		try {			
			Utilisateur utilisateur= (Utilisateur) sessionAttributes.get("utilisateur");
			System.out.println("*** UtilisateurAction - addGroupe: id utilisateur= " + utilisateur.getId());
			groupe.setUtilisateur(utilisateur);
			iServiceFacade.createGroupe(groupe);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	// Ajouter un nouvelle liste de diffusion
	public String addListe() {
		try {			
			Utilisateur utilisateur= (Utilisateur) sessionAttributes.get("utilisateur");
			System.out.println("*** UtilisateurAction - addListeDiff: id utilisateur= " + utilisateur.getId());			
			listeDiff.setUtilisateur(utilisateur);
			iServiceFacade.createListeDiff(listeDiff);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//GUETTERS ET SETTERS 
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	public ListeDiffusion getListeDiff() {
		return listeDiff;
	}

	public void setListeDiff(ListeDiffusion listeDiff) {
		this.listeDiff = listeDiff;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes= sessionAttr;
	}

	@Override
	public void prepare() throws Exception {
		try {
			InitialContext context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(UtilAction.SERVICE_FACADE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}			
	}
}
