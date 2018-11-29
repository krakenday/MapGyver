package webApp.uc3Partager;

import java.io.IOException;
import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.uc3Partager.Description;
import business.uc3Partager.TypeCommentaire;
import business.uc8Utilisateur.Utilisateur;
import client.serveur.partager.IGestion;
import client.serveur.partager.exception.UserException;
import utilitaire.partager.Parametre;

/**
 * Servlet implementation class ControleurPartager
 */
@WebServlet(
		name = "ControleurPartager",
		description = "Controleur de gestion du partage de souvenir",
		urlPatterns = {"/partager/*"}
		)
public class ControleurPartager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp;
	private IGestion serviceGestion;

	/*
	 * Init est exécuté lors de l'instanciation de la servlet, ensuite il ne l'est plus.
	 */
	@Override
	public void init() {

		// initialisation de l'acces au service EJB
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();
			serviceGestion  = (IGestion) initialContext.lookup(Parametre.CRUD_DESCRIPTION);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/*
	 * Méthode allant chercher la valeur du service sélectionné par l'utilisateur	
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans POST Controlleur Partager");	//TODO:A supprimer
		String path = request.getPathInfo();
		System.out.println("SECOND================  dans ControleurPartager action=" + path );
		
		
		if (path == null || path.equals("/")) 	doAccueil(request, response);
		else if (path.equals("/Creer"))			creerDescription(request, response);
		else if (path.equals("/Modifier"))		ModifierDescription(request, response);
		else if (path.equals("/Supprimer"))		SupprimerDescription(request, response);
		else									messageError(request, response);
	}


	/*
	 * Méthode qui gère le traitement des erreurs de creerDescription()
	 */
	private void creerDescription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = " ";
		try {
			addDescription(request, response);
			message = "La création de votre description a été effectué";					//TODO: Constante à mettre en place
		} catch (UserException e) { 														//TODO:Faire remonte l'erreur par un message dans la page
			message = "Un problème est survenu lors de la crétion de votre description";	//TODO: Constante à mettre en place
		} 

		System.out.println(message);
		request.setAttribute("erreur", message);
		disp = request.getRequestDispatcher("/vue/vue.partager/partageable.jsp");
	}
	
	/*
	 * Méthode qui gère le traitement des erreurs de ModifierDescription()
	 */
	private void ModifierDescription(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("Je vais modifier ma description dans serveur APP");
		
	}
	
	/*
	 * Méthode qui gère le traitement des erreurs de SupprimerDescription()
	 */
	private void SupprimerDescription(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("Je vais supprimer ma description dans serveur APP");
	}

	/*
	 * Méthode dirigeant vers la page d'acceuil de UC3_Partager
	 */
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/vue/vue.partager/partageable.jsp").forward( request,response);	
	}

	/*
	 * Méthode qui appelle le service création d'une description
	 */
	private void addDescription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException {
		System.out.println("************CONSTRUCTION************	 addDescription controleur Partager");
		
		String commentaire = request.getParameter("txtAreaDescription");
		System.out.println(commentaire);
		
		String groupe = request.getParameter("group1");
		System.out.println(groupe);

		String typeDescription = request.getParameter("lblTypeDescription");
		System.out.println(typeDescription);

		
		Description description = new Description(commentaire, LocalDate.now(), 17); 
		
		//TODO: recupérer l'utilisateur en session
		Utilisateur user =  new Utilisateur(" ", " ", " ");
		user.setId(1);
		
		
		
		description.setUtilisateur(user);
//		description.setTypeCommentaire();
		serviceGestion.addDescription(description);
		doAccueil(request, response);
	}

	/*
	 * Méthode qui appelle le service modification d'une description
	 */
	private void updateDescription(HttpServletRequest request, HttpServletResponse response) {

	}

	/*
	 * Méthode qui appelle le service suppression d'une description par id
	 */
	private void deleteDescription(HttpServletRequest request, HttpServletResponse response) throws UserException {
		System.out.println("************ deleteDescription controleur Partager");

		//TODO: Jeu d'essai à supprimer 
		Description d1 = new Description("description1", LocalDate.now(), 17);
		Description d2 = new Description("description2", LocalDate.now(), 450);
		serviceGestion.addDescription(d1);
		serviceGestion.addDescription(d2);


		serviceGestion.deleteDescription(d2.getId());
	}

	private void messageError(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		//		request.setAttribute("msgErreur", "Gestion Bonbon : Vous avez tripatouill&eacute; l'url!!! ");
		//		disp = request.getRequestDispatcher("/");  	    	
		//		disp.include(request,response);
	}	
}
