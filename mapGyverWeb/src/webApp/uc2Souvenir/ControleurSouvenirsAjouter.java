package webApp.uc2Souvenir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.FilenameUtils;

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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("je suis dans ControleurSouvenirAjout-Dans mon POST !!");
		
		 //recuperation contenu, titrePhoto, longueurFichier
		Part 		filePart;
		String 		fileName;
		InputStream fileContent;
		Long 		contentLenght;
		
		filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		fileContent = filePart.getInputStream();
		contentLenght =(long) fileContent.available();
		 
		System.out.println("file Name =" + fileName);
		System.out.println("le fileContent sa donne quoi?" + fileContent);
		
		//recuperation commentaire
		request.getParameter("com");
		System.out.println(request.getParameter("com"));
		
		//recuperation point Interet
		request.getParameter("pi");
		System.out.println(request.getParameter("pi"));
		
		
		//Vers méthodes de controle qui renvoient l'objet
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	};
}