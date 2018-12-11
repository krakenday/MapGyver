package webApp.uc2Souvenir;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirection vers les differents services de l'UC2 Souvenirs
 */
@WebServlet(
		name = "ControleurSouvenirs", 
		description = "Controleur Souvenir", 
		urlPatterns = {"/XXsouvenirs/*"}
		)
public class ControleurSouvenirs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherTrace("Controleur Souvenirs");
		String path = request.getPathInfo();
		afficherTrace(path);
		
		
		if (path.matches("/")) {
			doPage(request, response);
		}
		else if (path.matches("/ajouter")) {
			doRedirect(request, response, path);
		}
		else if (path.matches("/supprimer")) {
			doRedirect(request, response, path);
		}
		
		else doErreur(request, response);
		
	}
	
	private void doPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRedirect(request, response, "/vue/souvenirs.jsp");
		
	}

	private void doErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("****ControleurSouvenir-doErreur: probleme de redirection");
		doRedirect(request, response, "/vue/404.jsp");
	}

	private void doRedirect(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);		
	}

	private void afficherTrace(String string) {
		System.out.println("trace : " + string);
	}
}
