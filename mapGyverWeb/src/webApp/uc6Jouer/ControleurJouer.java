//package webApp.uc6Jouer;
//
//import java.io.IOException;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import business.uc6Jouer.ReponseElire;
//import clientServeur.IServiceFacade;
//import service.exception.uc6Jouer.ExceptionSurDao;
//
///**
// * Servlet implementation class ControleurJouer
// */
//@WebServlet(name = "/ControleurJouer", description = "Controleur utilisateur", urlPatterns = { "/xx/jouer/*" })
//public class ControleurJouer extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ControleurJouer() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	private static final String SERVICE_FACADE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
//
//	private IServiceFacade iServiceFacade;
//
//// Initialiser le context	
//	@Override
//	public void init() throws ServletException {
//
//		try {
//			InitialContext context = new InitialContext();
//			iServiceFacade = (IServiceFacade) context.lookup(SERVICE_FACADE_LOOKUP);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		RequestDispatcher disp = request.getRequestDispatcher("/vue/jouer.jsp");
//		disp.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		ReponseElire reponseElire = new ReponseElire();
//		reponseElire.setId(Integer.parseInt(request.getParameter("radioId")));
//		System.out.println(reponseElire.getId());
//		try {
//			iServiceFacade.createReponseElire(reponseElire);
//		} catch (ExceptionSurDao e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		RequestDispatcher disp = request.getRequestDispatcher("/vue/jouer.jsp");
//		disp.forward(request, response);
//
//	}
//
//}
