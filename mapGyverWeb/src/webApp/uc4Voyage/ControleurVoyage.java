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

import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;



/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "ControleurBonbon", 
		description = "Controleur Voyage", 
		urlPatterns = {"/voyages/*"}
		)
public class ControleurVoyage extends HttpServlet {
	private static final String ZONE_EXCEPTION = "WebApp";

	private static final long serialVersionUID = 1L;

	private IServiceFacade iServiceFacade;
	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";

	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(VOYAGE_SERVICE_LOOKUP);
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
			doService(request);
			doAccueil(request, response);
		}
		else {
			doErreur(request, response);
		}
	}

	@Override
	protected void finalize() throws Throwable {

	}

	private void doService(HttpServletRequest request) throws ServletException, IOException {
		affciherTrace("Controleur Voyage");
		if 		("create".equals(request.getParameter("todo"))) 	create(request);
		else if ("update".equals(request.getParameter("todo"))) 	update(request);
		else if ("delete".equals(request.getParameter("todo"))) 	delete(request);
		else if ("deleteAll".equals(request.getParameter("todo"))) 	deleteAll();
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

	private void create(HttpServletRequest request) {
		try {
			FormVoyage formVoyage = new FormVoyage(request);
			Voyage voyage = formVoyage.createVoyage();
			iServiceFacade.createVoyage(voyage);
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

	private void update(HttpServletRequest request)  {
		affciherTrace("update");

	}

	private void delete(HttpServletRequest request) {
		affciherTrace("delete");

	}

	private void deleteAll() {
		affciherTrace("deleteAll");

	}

	private void affciherTrace(String string) {
		System.out.println("trace : " + string);

	}
}
