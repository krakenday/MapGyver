package webApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "Controleur", 
		description = "Controleur General", 
		urlPatterns = {"/xx/*"}
		)
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ArrayList<String> EXIST_URL = 
			new ArrayList<String>(Arrays.asList(new String[]{"/404.jsp","/login.jsp","/register.jsp","/forgot-password.jsp"}));
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doErreur(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherTrace("Controleur Generale");
		String path = request.getPathInfo();
		afficherTrace(path);
		if (path == null || path.equals("/")) {
			doAccueil(request, response);
		}
		else if (EXIST_URL.contains(path)) {
			doPage(request, response, "/vue"+path);
		}
		else if (path.matches("/voyages(.*)")) {
			doPage(request, response, path);			
		}
		else if (path.matches("/admin(.*)")) {
			doPage(request, response, path);			
		}
		else if (path.matches("/utilisateur(.*)")) {
			doPage(request, response, path);			
		}
		else {
			doErreur(request, response);
		}
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPage(request, response, "/vue/index.jsp");
	}
	
	private void doErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPage(request, response, "/vue/404.jsp");
	}
	
	private void doPage(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);		
	}

	private void afficherTrace(String string) {
		System.out.println("trace : " + string);
	}
}
