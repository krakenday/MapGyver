package webApp.uc1Administrer;

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

import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;



/**
 * Servlet implementation class Controleur
 */
@WebServlet(
		name = "ControleurAdministrer", 
		description = "Controleur administrer", 
		urlPatterns = {"/XXXadmin/*"}
		)
public class ControleurAdministrer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IServiceFacade service;
	
	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();
			service = (IServiceFacade) context.lookup("ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println("*** ControleurAdministrer - doPost - path : " + path);
		
		request.setAttribute("msg", "");
		
		if (path == null || path.equals("/")) 	{
			doAccueil(request, response);
		}
		else if (path.equals("/login")) 	{
			doLogin(request, response);
		}
		else if (path.equals("/logout")) 	{
			doLogout(request, response);
		}
		else {
			doAccueil(request, response);
		}
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("inputEmail");
		String pw    = request.getParameter("inputPassword");
		System.out.println("*** ControleurAdministrer - doLogin - login/pw : " + email + "/" + pw);
		//TODO recup du user par email
		RequestDispatcher 	disp = null;
		try {
			Utilisateur user = service.getUserByEmail(email);
			System.out.println("*** ControleurAdministrer - doLogin - user : " + user);
			
			
			// !!!!!!!!!!!!!!!!!!!!
			// au moment de l'ecriture du code, le pw n'est pas gere dans Utilisateur
			// J'enleve le control
			System.out.println("*** ControleurAdministrer - doLogin - pw   : " + user.getMotDePasse());
//			if (!pw.equals(user.getMotDePasse().getPassword())) throw new ServiceInexistantException();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("inputEmail", user.getEmail());
			session.setAttribute("utilisateur", user);
			System.out.println("session utilisateur = " + user);
			disp = request.getRequestDispatcher("/"); 
		} catch (ServiceInexistantException e) {
			request.setAttribute("msg", "Votre email ou votre password est incorrect.");
			disp = request.getRequestDispatcher("/vue/login.jsp"); 
		}
		disp.forward(request,response);		
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
		response.sendRedirect(request.getContextPath()); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*** ControleurAdministrer - doGet");
		request.setAttribute("msg", "");
		doPost(request, response);
	}

	
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logout(request, response);
		RequestDispatcher 	disp = request.getRequestDispatcher("/"); 
		disp.forward(request,response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("inputEmail");
		session.removeAttribute("utilisateur");
		request.removeAttribute("inputEmail");
		request.removeAttribute("inputPassword");
	}


}
