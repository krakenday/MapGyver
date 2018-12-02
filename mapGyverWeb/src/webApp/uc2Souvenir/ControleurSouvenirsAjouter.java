package webApp.uc2Souvenir;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet en charge du traitement des donnees recus depuis 
 * le formulaire de la jsp (form de consultsouvenirs.jsp)
 * et des requetes d ajout vers le serveur d application
 */
@WebServlet(
		name = "ControleurSouvenirsAjouter", 
		description = "Controleur d ajout pour UC2", 
		urlPatterns = {"/ajouter"}
		)

public class ControleurSouvenirsAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("je suis dans ControleurSouvenirAjout-Dans mon POST !!");
		
		request.getParameter("com");
		System.out.println(request.getParameter("com"));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	};
}