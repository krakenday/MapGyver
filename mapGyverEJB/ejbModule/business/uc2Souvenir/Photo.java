package business.uc2Souvenir;

/**
 * @author Alejandro
 * Le fichier "image" est stocke sur AWS S3,
 * l'acces a l'image se fait en fournissant une url
 * au webBrowser
 * Les autre proprietes sont stockes sur Oracle
 * 
 */

import java.io.InputStream;
import java.time.LocalDate;

//TODO must implements "Partageable"

public class Photo extends Souvenir {
	
	private String nom;
	private String url;
	private InputStream fileContent;
	private Commentaire commentaire;
	private Long length;
	
	
	/**
	 * 
	 * @param dateEnregistre: generer avec LocalDate.now()
	 * @param nom: nom sous lequel sera enregistre la photo
	 * @param fileContent: de type InputStream
	 * @param commentaire: optionnel, il existe un constructeur sans le commentaire
	 * @param length : longueur en bytes du fichier, necessaire pour utilisation de Amazon S3
	 */
	public Photo(	LocalDate 	dateEnregistre,
					String 		nom,
					InputStream fileContent,
					Commentaire commentaire,
					Long 		length) {
		
		super(dateEnregistre);
		this.nom = nom;
		this.fileContent = fileContent;
		this.commentaire = commentaire;
		this.length = length;
	}



	//TODO metre a jour commentaire
	/**
	 * @author Alejandro
	 * 
	 * Constructeur a utiliser dans la couche DAO
	 * (proprietes necessaires au client)
	 * 
	 * @param id (genere par la bdd par autoincrementation)
	 * @param dateEnregistre
	 * @param nom
	 * @param url (permet l acces a la photo enregistre sur AWS S3)
	 */
//	public Photo(int id, LocalDate dateEnregistre, String nom, String url) {
//		super(id, dateEnregistre);
//		this.nom = nom;
//		this.url = url;
//	}


	@Override
	public String toString() {
		return "Photo [nom=" + nom + ", url=" + url + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public InputStream getFileContent() {
		return fileContent;
	}


	public void setFileContent(InputStream fileContent) {
		this.fileContent = fileContent;
	}


	public Commentaire getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}


	public Long getLength() {
		return length;
	}


	public void setLength(Long length) {
		this.length = length;
	}

	

}
