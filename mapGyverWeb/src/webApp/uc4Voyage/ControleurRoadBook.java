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
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controleur RoadBook doGet");
		HttpSession session = request.getSession(false);
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if (utilisateur!=null) {
			String path = request.getPathInfo();
			doForSessionOK(request, response, path, utilisateur);
		} else {
			doForSessionKO(request, response);
		}
	}

	private void doForSessionKO(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//TODO faire page voyage "veuillez vous logger ou creer un compte"
		response.sendRedirect(request.getContextPath()+"/mapgyver/login.jsp");
	}

	private void doForSessionOK(HttpServletRequest request, HttpServletResponse response, String path, Utilisateur utilisateur)
			throws ServletException, IOException {
		if (path == null || path.equals("/")) 	{	
			setRoadBookFromUserOnRequest(request, utilisateur);
			showPageRoadBook(request, response);
		}
		else if (path.equals("/create")) 	{
			createRoadBook(request, utilisateur);
			showPageRoadBook(request, response);
		}
		else if (path.equals("/add/")) 	{
			addVoyageOnRoadBook(request, utilisateur);
			showPageVoyage(request, response);
		}
		else if (path.matches("/delete(.*)")) {
			deleteRoadBook(request, path);
			showPageRoadBook(request, response);			
		}
		else {
			showErreur(request, response);
		}
	}


	private void showPageVoyage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		showPage(request, response, "/vue/voyages.jsp"); 
	}

	private void showPageRoadBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		showPage(request, response, "/vue/voyages/roadBook.jsp");
	}
	
	private void showErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showPage(request, response, "/vue/404.jsp");
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);	
	}

	private void setRoadBookFromUserOnRequest(HttpServletRequest request, Utilisateur utilisateur) 
			throws ServletException, IOException {
		try {
			RoadBook roadBook = serviceMpg.getRoadBookByUser(utilisateur);
			System.out.println("roadBook : " + roadBook);
			if (roadBook !=null) request.setAttribute("roadBook",roadBook);
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_GET.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}
	
	private void createRoadBook(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("create");
		try {
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
		}  catch (NumberFormatException | ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void addVoyageOnRoadBook(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("create");
		try {
			RoadBook roadBook= getOrCreateUserRoadBook(utilisateur);
			Voyage voyage = new FormVoyage(request).createVoyage();
			roadBook.addVoyage(voyage);
			roadBook = serviceMpg.updateRoadBook(roadBook);
			request.setAttribute("roadBook",roadBook);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_INSERT.getMsg());
		} catch (ExceptionServiceVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
					+" *Err. "+ e.getMessage());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_INSERT.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private RoadBook getOrCreateUserRoadBook(Utilisateur utilisateur) throws ServiceFacadeExceptionVoyage {
		RoadBook roadBook =  serviceMpg.getRoadBookByUser(utilisateur);
		if (roadBook ==null) roadBook = serviceMpg.createRoadBook(new RoadBook(utilisateur));
		return roadBook;
	}

}
