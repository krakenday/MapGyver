package webApp.uc2Souvenir;

import java.io.InputStream;

import javax.servlet.http.Part;

import business.uc2Souvenir.Souvenir;
import webApp.ApplicationSupport;

public class AdministrerSouvenir extends ApplicationSupport {

	private static final long serialVersionUID = 1L;
	
	//recuperation contenu, titrePhoto, longueurFichier
	private ControlesAjouter 	controles;
	private Souvenir			souvenir;
	private Part 				filePart;
	private String 				nomPhoto;
	private InputStream 		fileContent;
	private Long 				contentLenght;
	private String				comm;
	private String				idVoyage;

}
