package webApp.uc4Voyage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	private IServiceFacade serviceMpg;
	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";

	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();

			serviceMpg = (IServiceFacade) context.lookup(VOYAGE_SERVICE_LOOKUP);

		} catch (NamingException e) {
			e.printStackTrace();
			// TODO gerer exception connexion service
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doErreur(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) 	{
			doServiceOnVoyage(request);
			doAccueil(request, response);
		}
		else if (path.equals("/roadBook")) 	{
			doRoadBook(request, response);
		}
		else {
			doErreur(request, response);
		}
	}

	@Override
	protected void finalize() throws Throwable {

	}

	private void doServiceOnVoyage(HttpServletRequest request) throws ServletException, IOException {
		affciherTrace("Controleur Voyage");
		if 		("create".equals(request.getParameter("todo"))) 	createVoyage(request);
		else if ("update".equals(request.getParameter("todo"))) 	updateVoyage(request);
		else if ("delete".equals(request.getParameter("todo"))) 	deleteVoyage(request);
		else if ("deleteAll".equals(request.getParameter("todo"))) 	deleteAllVoyage();
		read(request);
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

	private void doRoadBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
//		 TODO a supprimer : creation roadBook en dur
//		List<Voyage> voyages = new ArrayList<>();
//		voyages.add(new Voyage(1, "Voyage1", null, 10, null));
//		voyages.add(new Voyage(2, "Voyage2", LocalDate.now(), null, null));
//		voyages.add(new Voyage(25, "Voyage25", LocalDate.now().plusDays(20), 5, null));
//		 Fin creation roadBook
		
		//roadBook = new RoadBook(0, utilisateur, voyages);
		RoadBook roadBook = serviceMpg.getRoadBookByUserId(utilisateur.getId());
		System.out.println(roadBook);
		
		request.setAttribute("roadBook",roadBook);
		doPage(request, response, "/vue/voyages/roadBook.jsp");
	}
	
	private void createVoyage(HttpServletRequest request) {
		affciherTrace("create");
		try {
			Voyage voyage = new FormVoyage(request).createVoyage();
			System.out.println(voyage);
			serviceMpg.createVoyage(voyage);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_INSERT.getMsg() 
					+" : "+ voyage.getNom());
		} catch (ExceptionServiceVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_SAISIES.getSolution() 
					+" *Err. "+ e.getMessage());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_INSERT.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
	}

	private void read (HttpServletRequest request) {
		affciherTrace("read");

	}

	private void updateVoyage(HttpServletRequest request)  {
		affciherTrace("update");
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
		affciherTrace("delete");
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
		affciherTrace("deleteAll");

	}

	private void affciherTrace(String string) {
		System.out.println("trace : " + string);

	}
}
