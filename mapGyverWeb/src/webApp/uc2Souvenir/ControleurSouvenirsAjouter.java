package webApp.uc2Souvenir;

import java.io.File;
import java.io.IOException;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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
		
		//ok
		//request.getParameter("com");
		//System.out.println(request.getParameter("com"));
		
		//ok
		//request.getParameter("pi");
		//System.out.println(request.getParameter("pi"));
		
		//RecupPhoto (FILE)***********************************************
		//****************************************************************
		
		// on prépare pour l'envoie par la mise en oeuvre en mémoire
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		List<FileItem> items = null;
		
			try {
				items = (List<FileItem>) uploadHandler.parseRequest(request);
			} catch (FileUploadException e) {
				System.out.println("ControleurSouvenirAjout-Catch fileUpload Exception");
				e.printStackTrace();
			}
			System.out.println("*** Controller - doRecupPhotoClient - items : " + items );
			
			String dossierUpload = "D:\\temp\\testUpload\\";
			//String dossierUpload = "\\\\CDIdmNAS\\partage17288\\Travail\\dm\\fileUpload\\";
			
			// Creation du repertoire
			new File(dossierUpload).mkdirs();
			
			// recup de l'image
			FileItem item = items.get(0);
			
			// recuperation de l'extension du fichier : jpg png ...
			// String fileName = item.getName();
			String fileExtensionName = item.getName();
			fileExtensionName = FilenameUtils.getExtension(fileExtensionName);
			
			// creation d'une date avec les nanosecondes pour creer le nom du fichier
			LocalDateTime time = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd_kkmmssnnnnnnnnn");
			
			// creation du nom du fichier avec la date et l'extension
			String fileName = time.format(formatter) + "." + fileExtensionName;
			System.out.println(fileName);
			
			
			File file = new File(dossierUpload + fileName);
			System.out.println("*** Controller - doRecupPhotoClient - file : " + file );
			
			try {
				item.write(file);
			} catch (Exception e) {
				System.out.println("ControleurSouvenirAjout-Catch item.write()");
				e.printStackTrace();
			}
		
		//****************************************************************
		//****************************************************************
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	};
}