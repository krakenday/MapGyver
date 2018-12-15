package webApp.uc8Utilisateur;

import java.util.List;
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

public class CatalogueAction extends ApplicationSupport implements SessionAware, Preparable {

	private static final long serialVersionUID = 1L;
	
	private IServiceFacade iServiceFacade;
	private Map<String, Object> sessionAttributes = null; 
	
	private List<Utilisateur> utilisateurs;
	private List<Groupe> groupes;
	private List<ListeDiffusion> listeDiff;


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<ListeDiffusion> getListeDiff() {
		return listeDiff;
	}

	public void setListeDiff(List<ListeDiffusion> listeDiff) {
		this.listeDiff = listeDiff;
	}

	@Override
	public String execute() throws Exception {
		
		Utilisateur utilisateur= (Utilisateur) sessionAttributes.get("utilisateur");
		System.out.println("*** UtilisateurAction - delete: id utilisateur= " + utilisateur.getId());
		
		utilisateurs= iServiceFacade.listerTousLesUtilisateurs();
		groupes= iServiceFacade.listerTousLesGroupes(utilisateur.getId());
		listeDiff= iServiceFacade.listerToutesLesListes(utilisateur.getId());
		return SUCCESS;
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
