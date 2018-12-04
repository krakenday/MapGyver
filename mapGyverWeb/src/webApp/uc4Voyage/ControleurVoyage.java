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
			//doServiceOnVoyage(request, utilisateur);
			showPageVoyage(request, response);
		}
		else if (path.matches("/delete(.*)")) {
			deleteVoyage(request, utilisateur);
			showPageRoadBook(request, response, utilisateur);
		}
		else if (path.matches("/update/(.*)"))  {
			updateVoyage(request, path);
			showPageRoadBook(request, response, utilisateur);
		}
		else if (path.matches("/roadBook(.*)")) {
			showPage(request, response, path);
		}
		else {
			try {
				Integer id = Integer.parseInt(path.replace("/", ""));
				setVoyageFormIdOnRequest(request, id);
				showPageVoyage(request, response);
			} catch (NumberFormatException e){
				showErreur(request, response);
			}
		}
	}

	private void doServiceOnVoyage(HttpServletRequest request, Utilisateur utilisateur) throws ServletException, IOException {
//		if 		("create".equals(request.getParameter("todo"))) 	createVoyage(request, utilisateur);
//		//else if ("update".equals(request.getParameter("todo"))) 	updateVoyage(request, path);
//		else if ("delete".equals(request.getParameter("todo"))) 	deleteVoyage(request, utilisateur);
//		else if ("deleteAll".equals(request.getParameter("todo"))) 	deleteAllVoyage();
	}

	private void showPageVoyage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		showPage(request, response, "/vue/voyages.jsp"); 
	}

	private void setVoyageFormIdOnRequest(HttpServletRequest request, Integer id) {
		System.out.println(id);
		if (id!=null) {
			try {
				Voyage voyage = serviceMpg.getVoyageById(id);
				request.setAttribute("voyage", voyage);
				System.out.println(voyage);
			} catch (ServiceFacadeExceptionVoyage e) {
				request.setAttribute("probleme", ControleurVoyageMsg.ERROR_GET.getSolution() 
						+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
			}
		}
	}

	private void showPageRoadBook(HttpServletRequest request, HttpServletResponse response, Utilisateur utilisateur) throws ServletException, IOException{
		try {
			RoadBook roadBook = getOrCreateUserRoadBook(utilisateur);
			request.setAttribute("roadBook", roadBook);
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_GET.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		}
		showPage(request, response, "/vue/voyages/roadBook.jsp");
	}

	private void showErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showPage(request, response, "/vue/404.jsp");
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher(path); 
		disp.forward(request,response);	
	}

	private void createVoyage(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("create");
		try {
			RoadBook roadBook= getOrCreateUserRoadBook(utilisateur);
			Voyage voyage = new FormVoyage(request).createVoyage();
			roadBook.getVoyages().add(voyage);
			roadBook = serviceMpg.updateRoadBook(roadBook);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_INSERT.getMsg());
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

	private void updateVoyage(HttpServletRequest request, String path)  {
		System.out.println("update");
		try {
			int id = Integer.parseInt(path.replace("/update/", "").replace("/", ""));
			Voyage voyage = new FormVoyage(request).createVoyage();
			voyage.setId(id);
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

	private void deleteVoyage(HttpServletRequest request, Utilisateur utilisateur) {
		System.out.println("delete");
		try {
			RoadBook roadBook= getOrCreateUserRoadBook(utilisateur);
			roadBook.removeVoyageById(Integer.parseInt(request.getParameter("id")));
			roadBook = serviceMpg.updateRoadBook(roadBook);
			serviceMpg.deleteVoyage(Integer.parseInt(request.getParameter("id"))); 
			request.setAttribute("roadBook",roadBook);
			request.setAttribute("success", ControleurVoyageMsg.SUCCESS_DELETE.getMsg());
		} catch (ServiceFacadeExceptionVoyage e) {
			request.setAttribute("probleme", ControleurVoyageMsg.ERROR_DELETE.getSolution() 
					+" *Err. "+ ZONE_EXCEPTION+ e.getMessage());
		} 
	}

	private void deleteAllVoyage() {
		System.out.println("deleteAll");

	}

}
