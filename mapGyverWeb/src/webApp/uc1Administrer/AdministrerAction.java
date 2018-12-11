package webApp.uc1Administrer;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import webApp.ApplicationSupport;

public class AdministrerAction extends ApplicationSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private IServiceFacade service;
	
	private String inputEmail;
	private String inputPassword;
	
	private String msg;
	
	// variables pour injecter l'instance de la session          
	private Map<String, Object> sessionAttributes = null; 
	
	public void init(){
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public String login() {
		init();
		System.out.println("*** AdministrerAction - doLogin - login/pw : " + inputEmail + "/" + inputPassword);
		try {
			Utilisateur user = service.getUserByEmail(inputEmail);
			System.out.println("*** AdministrerAction - doLogin - user : " + user);			
			
			// !!!!!!!!!!!!!!!!!!!! - au moment de l'ecriture du code, 
			// le pw n'est pas gere dans Utilisateur - J'enleve le control
//			System.out.println("*** ControleurAdministrer - doLogin - pw   : " + user.getMotDePasse());
//			if (!pw.equals(user.getMotDePasse().getPassword())) throw new ServiceInexistantException();
			
			sessionAttributes.put("inputEmail", user.getEmail());
			sessionAttributes.put("utilisateur", user);
			
			return SUCCESS;
		} catch (ServiceInexistantException e) {
			msg = " : Votre email ou votre password est incorrect.";
			return ERROR;
		}	
	}

	public String logout() {
		sessionAttributes.clear();
		return SUCCESS;
	}
	
	public String forgot() {
		msg = " : Fallait pas oublier le mot de passe. Debrouille toi!!";
		return ERROR;
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
	
	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
