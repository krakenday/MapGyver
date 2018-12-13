package webApp.uc4Voyage.auth;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import business.uc8Utilisateur.Utilisateur;
import webApp.uc4Voyage.VoyageAction;

public class AuthenticationInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		Utilisateur utilisateur = (Utilisateur) sessionAttributes.get("utilisateur");
		System.out.println("***IDM AuthenticationInterceptor - intercept : personne = " + utilisateur);
		if (utilisateur.getEmail() == null) {
			return Action.LOGIN;
		}
		else {
			System.out.println("***IDM AuthenticationInterceptor - actionInvocation.invoke()");
			// on recupère l'action demandée
			Action action = (Action) actionInvocation.getAction();
			// si l'action implements LoginAware, on injecte le loginBean de la session
			// dans l'instance d'action
			if(action instanceof VoyageAction){
				((VoyageAction) action).setUtilisateur(utilisateur);
			}
			return actionInvocation.invoke(); // on continue le workflow
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
