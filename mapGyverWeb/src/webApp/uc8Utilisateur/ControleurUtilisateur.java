package webApp.uc8Utilisateur;

import java.io.IOException;
import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;


/**
 * Servlet implementation class ControleurUtilisateur
 */
@WebServlet(		name = "ControleurUtilisateur", 
					description = "Controleur utilisateur", 
					urlPatterns = {"/utilisateur/*"})

public class ControleurUtilisateur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String SERVICE_FACADE_LOOKUP= "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	
	private IServiceFacade iServiceFacade;
	
// Initialiser le context	
	@Override
	public void init() throws ServletException {
		
		try {
			InitialContext context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(SERVICE_FACADE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}
	
//La methode GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path= request.getPathInfo();
		System.out.println("path :" + path);
		
		if (path == null || path.equals("/")) 	{
			doAccueil(request, response);
		}
		else if (path.equals("/gererUtilisateur")) 	{
			getMesinfos(request, response);
		}
		else {
			doAccueil(request, response);
		}
		
		//doPost(request, response);
	}

//La methode POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path= request.getPathInfo();
		System.out.println("path :" + path);
		
		
		if (path == null || path.equals("/")) 	{
			doAccueil(request, response);
		}
		else if (path.equals("/inscription")) 	{  // ajouter les exceptions un peu partout
			
			doCreate(request, response);
				doCongrate(request, response);
		}
		else {
			doAccueil(request, response);
		}
					
	}
	
// Définir le chemin de la page d'accueil
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/vue/index.jsp");
		disp.forward(request,response);	
	}
	
	private void getMesinfos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher("/vue/uc8Utilisateur/getinfo.jsp"); 
		disp.forward(request,response);	
	}
	private void doCongrate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher("/vue/uc8Utilisateur/inscriptionOK.jsp"); 
		disp.forward(request,response);	
	}
	
//initialisation d'un utilisateur Appel à la creation d'un utilisateur
	private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("initialisation");
		Utilisateur utilisateur= creerUtilisateur(request);
		iServiceFacade.create(utilisateur);	
	}
	
// La methode de creation d'un utilisateur
	private Utilisateur creerUtilisateur(HttpServletRequest request) {
		
		String inputNom= request.getParameter("inputNom");
		String inputPrenom= request.getParameter("inputPrenom");
		String email= request.getParameter("inputEmail");
		String password= request.getParameter("inputPassword");
		String tel= request.getParameter("inputTelephone");
		String dateNaiss= request.getParameter("inputDateNaiss");
		LocalDate dateInscrip= LocalDate.now();
		String adresse= request.getParameter("inputAdresse");
		System.out.println(adresse.toLowerCase());
		//String ville= request.getParameter("inputVille");
		Password motDePasse= new Password(password);
		//String pays= request.getParameter("inputPays");
		
		String nom= inputNom.toLowerCase();
		String prenom= inputPrenom.toLowerCase();
		
		LocalDate dateNaissance = null;
		if (!dateNaiss.isEmpty())
			dateNaissance= LocalDate.parse(dateNaiss);
		
		return iServiceFacade.creerUtilisateur(nom, prenom, adresse, email, tel, dateInscrip, dateNaissance, motDePasse);
	}
}
