package webApp.uc4Voyage;

import java.io.IOException;
import java.time.LocalDate;


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



/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "ControleurBonbon", 
		description = "Controleur Voyage", 
		urlPatterns = {"/voyages/*"}
		)
public class ControleurVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IServiceFacade iServiceFacade;
	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/Facade!clientServeur.IServiceFacade";
	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(VOYAGE_SERVICE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
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
		affciherTrace("create");
		Voyage voyage;
		try {
			affciherTrace("lancement factory request");
			voyage = createVoyageFactory(request);
			affciherTrace("request to voyage : " + voyage.toString());
			iServiceFacade.createVoyage(voyage);
			affciherTrace(voyage.toString());
		} catch (ExceptionServiceVoyage e) {
			affciherTrace("Exception " + e.getMessage());
			//request.setAttribute("Exception", e.getMessage());	
		}
	}

	private Voyage createVoyageFactory(HttpServletRequest request) throws ExceptionServiceVoyage {
		String nom = "inconnu";
		LocalDate dateDebut = null;
		int nbParticipant = 0;
		try {
			nbParticipant = Integer.parseInt(request.getParameter("quantite"));
			nom = request.getParameter("titre");
			dateDebut = null;

		} catch (Exception e) {
			throw new ExceptionServiceVoyage();
		}
		return new Voyage(0, nom, dateDebut, nbParticipant, null);
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
