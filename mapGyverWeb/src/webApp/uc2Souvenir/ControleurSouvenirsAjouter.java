package webApp.uc2Souvenir;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import business.uc2Souvenir.Souvenir;
import clientServeur.IServiceFacade;
import utilitaire.Constantes;


/**
 * Servlet en charge du traitement des donnees recus depuis 
 * le formulaire de la jsp (form de consultsouvenirs.jsp)
 * et des requetes d ajout vers le serveur d application
 */
@WebServlet(
		name = "ControleurSouvenirsAjouter", 
		description = "Controleur d ajout pour UC2", 
		urlPatterns = {"/ajouter"}
		)
@MultipartConfig
public class ControleurSouvenirsAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IServiceFacade iServiceFacade;
	
	
	@Override
	public void init() throws ServletException {
		try {
			Context context = new InitialContext();

			iServiceFacade = (IServiceFacade) context.lookup(Constantes.LOOKUP_SOUVENIR_AJOUTER);

		} catch (NamingException e) {
			e.printStackTrace();
			// TODO exception
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("je suis dans ControleurSouvenirAjout-Dans mon POST !!");
		
		 //recuperation contenu, titrePhoto, longueurFichier
		ControlesAjouter 	controles;
		Souvenir			souvenir;
		Part 				filePart;
		String 				nomPhoto;
		InputStream 		fileContent;
		Long 				contentLenght;
		String				comm;
		String				idVoyage;
		
		filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		nomPhoto = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		fileContent = filePart.getInputStream();
		contentLenght =(long) fileContent.available();
		 
		System.out.println("file Name =" + nomPhoto);
		System.out.println("****************ControlSouvenirAjouter-le fileContent= " + fileContent);
		
		//recuperation commentaire
		comm =request.getParameter("com");
		System.out.println("****************ControlSouvenirAjouter- Valeur de commentaire =" + comm);
		
		//TODO valeur en dur pour l instant recuperation idVoyage
		idVoyage = request.getParameter("idVoyage");
		System.out.println("****************ControlSouvenirAjouter- Valeur de idVoyage =" + idVoyage);
		
		//TODO recuperation point Interet: pour V2
		//request.getParameter("pi");
		//System.out.println(request.getParameter("pi"));
		
		
		//Vers méthodes de controle qui renvoient l'objet
		
		controles = new ControlesAjouter();
		
		souvenir = controles.controleDesParametres(nomPhoto, fileContent, contentLenght, comm, idVoyage);
		
		System.out.println("****************ControlSouvenirAjouter- Valeur SOUVENIR =" + souvenir);
		
		//appel de mon service
		iServiceFacade.createSouvenir(souvenir);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	};
}