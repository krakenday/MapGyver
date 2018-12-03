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
		name = "ControleurVoyage", 
		description = "Controleur Voyage", 
		urlPatterns = {"/voyages/*"}
		)
public class ControleurVoyage extends HttpServlet {

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
		System.out.println("Controleur Voyage doPost");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controleur Voyage doGet");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("inputEmail");
		if (email!=null) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			String path = request.getPathInfo();
			doGetForSessionOK(request, response, path, utilisateur);
		} else {
			doGetForSessionKO(request, response);
		}
	}


	private void doGetForSessionKO(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//TODO faire page voyage "veuillez vous logger ou creer un compte"
		doPage(request, response, "/vue/register.jsp"); 
	}

	private void doGetForSessionOK(HttpServletRequest request, HttpServletResponse response, String path, Utilisateur utilisateur)
			throws ServletException, IOException {
		if (path == null || path.equals("/")) 	{
			doServiceOnVoyage(request, utilisateur);
			doAccueil(request, response);
		}
		else if (path.matches("/roadBook(.*)")) {
			doPage(request, response, path);
		}
		else {
			doErreur(request, response);
		}
	}

	private void doServiceOnVoyage(HttpServletRequest request, Utilisateur utilisateur) throws ServletException, IOException {
		if 		("create".equals(request.getParameter("todo"))) 	createVoyage(request, utilisateur);
		else if ("update".equals(request.getParameter("todo"))) 	updateVoyage(request);
		else if ("delete".equals(request.getParameter("todo"))) 	deleteVoyage(request);
		else if ("deleteAll".equals(request.getParameter("todo"))) 	deleteAllVoyage();
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPage(request, response, "/vue/voyages.jsp"); 
	}

	private void doErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPage(request, response, "/vue/404.jsp");
	}

	private void doPage(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);	
	}

	private void createVoyage(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("create");
		try {
			RoadBook roadBook= getOrCreateUserRoadBook(utilisateur);
			Voyage voyage = new FormVoyage(request).createVoyage();
			roadBook.getVoyages().add(voyage);
			System.out.println("roadBook : " + roadBook);
			roadBook = serviceMpg.updateRoadBook(roadBook);
			//voyage = serviceMpg.createVoyage(voyage);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_INSERT.getMsg());
			//+" : #"+ voyage.getId() +" - "+ voyage.getNom());
		} catch (ExceptionServiceVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
					+" *Err. "+ e.getMessage());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_INSERT.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error create Voyage");
		}
	}

	private RoadBook getOrCreateUserRoadBook(Utilisateur utilisateur) throws ServiceFacadeExceptionVoyage {
		RoadBook roadBook;
		roadBook = serviceMpg.getRoadBookByUser(utilisateur);
		if (roadBook ==null) roadBook = serviceMpg.createRoadBook(new RoadBook(utilisateur));
		System.out.println(roadBook);
		return roadBook;
	}

	private void updateVoyage(HttpServletRequest request)  {
		System.out.println("update");
		try {
			Voyage voyage = new FormVoyage(request).createVoyage();
			voyage.setId(voyage.getNbParticipant());
			serviceMpg.updateVoyage(voyage);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_UPDATE.getMsg() 
					+" : "+ voyage.getNom());
		} catch (ExceptionServiceVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
					+" *Err. "+ e.getMessage());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_UPDATE.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void deleteVoyage(HttpServletRequest request) {
		System.out.println("delete");
		try {
			//Voyage voyage = new FormVoyage(request).createVoyage();
			serviceMpg.deleteVoyage(Integer.parseInt(request.getParameter("id")));
			//			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_DELETE.getMsg() 
			//					+" : "+ voyage.getNom());
			//		} catch (ExceptionServiceVoyage e) {
			//			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
			//					+" *Err. "+ e.getMessage());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void deleteAllVoyage() {
		System.out.println("deleteAll");

	}

}
