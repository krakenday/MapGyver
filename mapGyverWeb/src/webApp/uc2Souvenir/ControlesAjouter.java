package webApp.uc2Souvenir;

import java.io.IOException;
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
//TODO classe pas tres bien structure a REFACTOR (utiliser variables d'instance)
public class ControlesAjouter {
	
	private Commentaire commentaire;
	private	Voyage voyage;
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
											String idVoyage) {
		
		
		Souvenir souvenir;
		byte[] content;
		int id;
		
		nomPhoto 	= controlNomPhoto	(nomPhoto);
		content 	= controlFileContent(fileContent);
		fileLength 	= controlFileLength	(fileLength);
		comm 		= controlCommentaire(comm);
		id			= controlIdVoyage	(idVoyage);
		
		//Idriss voulait pas me faire de Constructeur juste avec l'ID ( :D c'est une blague)
		voyage = new Voyage(id, null, null, null, null);
		
		if(nomPhoto.equals("")) {
			souvenir = createCommentaire(voyage, comm);
		}
		else {
			commentaire = new Commentaire(comm);
			
			souvenir = new Photo(LocalDate.now(), voyage, nomPhoto, content, commentaire, fileLength);
		}
		
		System.out.println("ControlesAjouter-controleDesParametres: affichage données:");
		System.out.println("valeur de : nomPhoto  =" +nomPhoto );
		System.out.println("valeur de : content  =" +content );
		System.out.println("valeur de : fileLength  =" +fileLength );
		System.out.println("valeur de :  comm =" +comm );
		
		
		//System.out.println("ControlesAjouter-controleDesParametres: AVANT RETURN, souvenir = "+souvenir);
		return souvenir;
	}
	
	
	
	private Souvenir createCommentaire(Voyage voyage, String comm) {
		commentaire = new Commentaire(LocalDate.now(), voyage, comm);
		
		return commentaire;
	}




	//TODO Methodes de controles pour chaque parametre a completer
	private int controlIdVoyage(String idVoyage) {
		int id = Integer.parseInt(idVoyage);
		return id;
	}

	private String controlCommentaire(String comm) {
		// TODO Auto-generated method stub
		return comm;
	}

	private Long controlFileLength(Long fileLength) {
		// TODO Auto-generated method stub
		return fileLength;
	}

	//Transforme l'InputStream en array Byte
	private byte[] controlFileContent(InputStream fileContent) {
		byte[] content = null;
		try {
			content = fileContent.readAllBytes();
		} catch (IOException e) {
			System.out.println("*************ControlesAjouter-controlFileContent: dans le catch !");
			e.printStackTrace();
		}
		
		return content;
	}

	private String controlNomPhoto(String nomPhoto) {
		// TODO Auto-generated method stub
		return nomPhoto;
	}
	
	
	
	

}
