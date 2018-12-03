package webApp.uc2Souvenir;

import java.io.InputStream;
import java.time.LocalDate;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import business.uc4Voyage.Voyage;

/**
 * Classe en charge de controler les donnees recuperees depuis la JSP
 * et de construire les objets a envoyer au Service
 * @author Alejandro
 *
 */
public class ControlesAjouter {
	
	
	/**
	 * 
	 * @param nomPhoto
	 * @param fileContent
	 * @param fileLength 
	 * @param comm : commentaire 
	 * @param idVoyage
	 * @return Object de type Souvenir pour transmission au Service EJB
	 */
	public Souvenir controleDesParametres(	String nomPhoto, InputStream fileContent,
											Long fileLength, String comm,
											int idVoyage) {
		
		Voyage voyage;
		Commentaire commentaire;
		Souvenir souvenir;
		
		
		nomPhoto 	= controlNomPhoto	(nomPhoto);
		fileContent = controlFileContent(fileContent);
		fileLength 	= controlFileLength	(fileLength);
		comm 		= controlCommentaire(comm);
		idVoyage 	= controlIdVoyage	(idVoyage);
		
		//Idriss voulait pas me faire de Constructeur juste avec l'ID ( :D c'est une blague)
		voyage = new Voyage(idVoyage, null, null, null, null);
		
		commentaire = new Commentaire(comm);
		
		souvenir = new Photo(LocalDate.now(), voyage, nomPhoto, fileContent, commentaire, fileLength);
		
		return souvenir;
	}
	
	
	

	//TODO Methodes de controles pour chaque parametre a completer
	private int controlIdVoyage(int idVoyage) {
		// TODO Auto-generated method stub
		return idVoyage;
	}

	private String controlCommentaire(String comm) {
		// TODO Auto-generated method stub
		return comm;
	}

	private Long controlFileLength(Long fileLength) {
		// TODO Auto-generated method stub
		return fileLength;
	}

	private InputStream controlFileContent(InputStream fileContent) {
		// TODO Auto-generated method stub
		return fileContent;
	}

	private String controlNomPhoto(String nomPhoto) {
		// TODO Auto-generated method stub
		return nomPhoto;
	}
	
	
	
	

}
