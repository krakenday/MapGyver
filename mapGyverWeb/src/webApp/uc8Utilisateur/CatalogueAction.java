package webApp.uc8Utilisateur;

import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import clientServeur.IServiceFacade;
import webApp.ApplicationSupport;

public class CatalogueAction extends ApplicationSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static final String SERVICE_FACADE_LOOKUP= "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private IServiceFacade iServiceFacade;
	private Map<String, Object> sessionAttributes = null; 
	
	
	private List<Groupe> groupes;
	private List<ListeDiffusion> listeDiff;



	// Initialiser le context	
	public void init() {
		System.out.println("*************** CatalogueAction - init() : ");
		try {
			InitialContext context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(SERVICE_FACADE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}		
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
		System.out.println("*************** CatalogueAction - execute() : ");
		init();
		groupes= iServiceFacade.listerTousLesGroupes();
		listeDiff= iServiceFacade.listerToutesLesListes();
	return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes= sessionAttr;
	}

}
