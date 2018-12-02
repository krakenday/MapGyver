package webApp.uc4Voyage;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;

/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "ControleurRoadBook", 
		description = "Controleur RoadBook", 
		urlPatterns = {"/roadBook/*"}
		)
public class ControleurRoadBook extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ZONE_EXCEPTION = "WebApp";
	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";

	private IServiceFacade serviceMpg;

	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();
			serviceMpg = (IServiceFacade) context.lookup(VOYAGE_SERVICE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Controleur RoadBook doPost");
		doErreur(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controleur RoadBook doGet");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("inputEmail");
		if (email!=null) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			System.out.println(utilisateur);
			String path = request.getPathInfo();
			doGetForSessionOK(request, response, path, utilisateur);
		} else {
			doGetForSessionKO(request, response);
		}
	}

	@Override
	protected void finalize() throws Throwable {

	}

	private void doGetForSessionKO(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//TODO faire page voyage "veuillez vous logger ou creer un compte"
		doPage(request, response, "/vue/register.jsp"); 
	}

	private void doGetForSessionOK(HttpServletRequest request, HttpServletResponse response, String path, Utilisateur utilisateur)
			throws ServletException, IOException {
		if (path == null || path.equals("/")) 	{	
			setRoadBookFromRequest(request, utilisateur);
			doAccueil(request, response);
		}
		else if (path.equals("/create")) 	{
			createRoadBook(request, utilisateur);
			doAccueil(request, response);
		}
		else if (path.matches("/delete(.*)")) {
			deleteRoadBook(request, path);
			doAccueil(request, response);			
		}
		else {
			doErreur(request, response);
		}
	}

	private void setRoadBookFromRequest(HttpServletRequest request, Utilisateur utilisateur) 
			throws ServletException, IOException {
		RoadBook roadBook;
		try {
			roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			System.out.println("roadBook : " + roadBook);
			if (roadBook !=null) request.setAttribute("roadBook",roadBook);
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_GET.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPage(request, response, "/vue/voyages/roadBook.jsp");
	}

	private void doErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPage(request, response, "/vue/404.jsp");
	}

	private void doPage(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);	
	}

	private void createRoadBook(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("create");
		try {
			//utilisateur.setId(1);
			System.out.println(utilisateur);
			RoadBook roadBook = serviceMpg.createRoadBook(new RoadBook(utilisateur));
			System.out.println("controleur RoadBook : " + roadBook);
			request.setAttribute("roadBook", roadBook);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_CREATE.getMsg());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_INSERT.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void deleteRoadBook(HttpServletRequest request, String path) {
		System.out.println("delete");
		try {
			int id = Integer.parseInt(path.replace("/delete/", ""));
			serviceMpg.deleteRoadBook(id);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_DELETE.getMsg() + " roadBook #"+id);
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}


	private void deleteAllVoyage() {
		System.out.println("deleteAll");

	}

}
