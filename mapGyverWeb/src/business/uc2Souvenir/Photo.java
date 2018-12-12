package business.uc2Souvenir;

/**
 * @author Alejandro
 * Le fichier "image" est stocke sur AWS S3,
 * l'acces a l'image se fait en fournissant une url
 * au webBrowser
 * Les autre proprietes sont stockes sur Oracle
 * 
 */

import java.time.LocalDate;
import java.util.Arrays;

import business.uc4Voyage.Voyage;


//TODO must implements "Partageable"

public class Photo extends Souvenir {
	
	private static final long serialVersionUID = 1L;
	
	private String 		nom;
	private String 		url;
	private byte[] 		fileContent;
	private Commentaire commentaire;
	private Long 		length;
	
	
	/**
	 * 
	 * @param dateEnregistre: generer avec LocalDate.now()
	 * @param nom: nom sous lequel sera enregistre la photo
	 * @param fileContent: de type InputStream
	 * @param commentaire: optionnel, il existe un constructeur sans le commentaire
	 * @param length : longueur en bytes du fichier, necessaire pour utilisation de Amazon S3
	 */
	public Photo(	LocalDate 	dateEnregistre,
					Voyage 		voyage,
					String 		nom,
					byte[] 		fileContent,
					Commentaire commentaire,
					Long 		length) {
		
		super(dateEnregistre, voyage);
		this.nom = nom;
		this.fileContent = fileContent;
		this.commentaire = commentaire;
		this.length = length;
	}



	@Override
	public String toString() {
		return "Photo [nom=" + nom + ", url=" + url + ", fileContent=" + Arrays.toString(fileContent) + ", commentaire="
				+ commentaire + ", length=" + length + "]";
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


	public byte[] getFileContent() {
		return fileContent;
	}


	public void setFileContent(byte[] fileContent) {
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
