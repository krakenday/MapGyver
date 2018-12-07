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
import javax.servlet.http.HttpSession;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionUtilisateur;


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
//			iServiceFacade.deleteGroupe(15);
			// Test des read 
//			try {
//				HttpSession session = request.getSession();
//				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
//				Utilisateur user= (Utilisateur) iServiceFacade.read(utilisateur.getId());
//				user.setId(utilisateur.getId());
//				System.out.println("*************** Controle utilisateur " + user.getId());
//				System.out.println("**** controle utilisateur " + user.toString());
//				System.out.println("********* Le groupe= " + creeGroupe(request).toString());
//				
//				Groupe gp= (Groupe) iServiceFacade.readGroupe(3);
//				System.out.println("********* Le groupe read que je recup= " + gp.toString());
//			} catch (ServiceFacadeExceptionUtilisateur e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else {
			doAccueil(request, response);
		}
	}

//La methode POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path= request.getPathInfo();
		System.out.println("path :" + path);
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		RequestDispatcher 	disp = null;
		
		if (path == null || path.equals("/")) 	{
			doAccueil(request, response);
		}
		else if (path.equals("/inscription")) 	{  
			try {
				System.out.println("initialisation");
				Utilisateur user= creerUtilisateur(request);
				iServiceFacade.create(user);	
				request.setAttribute("success", "Utilisateur enregistré");
				doFeliciter(request, response);
			} catch (ServiceFacadeExceptionUtilisateur e) {
				request.setAttribute("messageErreur", "<strong>ATTENTION!</strong> email existant!!");
				disp= request.getRequestDispatcher("/vue/register.jsp");
				
				System.out.println("tu rentres dans l'exception de controleur utilisateur");			
			}
			disp.forward(request, response);
		}
		else if (path.equals("/delete")) 	{ 
			System.out.println("controleur utilisateur delete user");
			try {

				System.out.println(utilisateur.getId());
				iServiceFacade.delete(utilisateur.getId());
				logout(request, response);
			} catch (ServiceFacadeExceptionUtilisateur e) {
				e.printStackTrace();
			}
		}
		else if (path.equals("/addGroupe")) 	{  // ajouter les exceptions un peu partout
			System.out.println("******************** "+ creeGroupe(request));
			iServiceFacade.createGroupe(creeGroupe(request));
			getMesinfos(request, response);
		}
		else if (path.equals("/addListe")) 	{  // ajouter les exceptions un peu partout
			System.out.println("******************** "+ creeGroupe(request));
			iServiceFacade.createListeDiff(creeListeDiffusion(request));
			getMesinfos(request, response);
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
	// Définir le chemin de la page de config et les informations utilisateurs	
	private void getMesinfos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher("/vue/uc8Utilisateur/getinfo.jsp"); 
		disp.forward(request,response);	
	}
	// Définir le chemin de la page de confirmation d'inscription
	private void doFeliciter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher 	disp = request.getRequestDispatcher("/vue/uc8Utilisateur/inscriptionOK.jsp"); 
		disp.forward(request,response);	
	}

	// Methode emprunté pour effacer la session suite à la suppression du compte
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("inputEmail");
		session.removeAttribute("utilisateur");
		request.removeAttribute("inputEmail");
		request.removeAttribute("inputPassword");
		doAccueil(request, response);
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
	// La methode de creation d'un groupe
	private Groupe creeGroupe(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String inputNomGroupe= request.getParameter("inputNomGroupe");
		Groupe groupe= new Groupe(inputNomGroupe, utilisateur);
		System.out.println("Je suis dans le controleur créer groupe" + utilisateur.toString());
		return groupe;
	}
	// La methode de creation d'une liste
	private ListeDiffusion creeListeDiffusion(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String inputNomListe= request.getParameter("inputNomListe");
		ListeDiffusion liste= new ListeDiffusion(inputNomListe, utilisateur);
		return liste;
	}

}
