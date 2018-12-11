package business.uc2Souvenir;

/**
 * @author Alejandro
 * Le fichier "image" est stocke sur AWS S3,
 * l'acces a l'image se fait en fournissant une url
 * au webBrowser
 * Les autre proprietes sont stockes sur Oracle
 * 
 */

import java.io.File;
import java.time.LocalDate;

//TODO must implements "Partageable"

public class Photo extends Souvenir {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String url;
	private File file;

	/**
	 * Constructeur a utiliser par le clientWeb pour passer l'objet Photo au
	 * service(ejb)
	 * 
	 * @param dateEnregistre
	 * @param nom
	 * @param file           (necessaire pour persister photo sur AWS S3)
	 */
	public Photo(LocalDate dateEnregistre, String nom, File file) {
		super(dateEnregistre);
		this.nom = nom;
		this.file = file;
	}

	/**
	 * @author Alejandro
	 * 
	 *         Constructeur a utiliser dans la couche DAO (proprietes necessaires au
	 *         client)
	 * 
	 * @param id             (genere par la bdd par autoincrementation)
	 * @param dateEnregistre
	 * @param nom
	 * @param url            (permet l acces a la photo enregistre sur AWS S3)
	 */
	public Photo(int id, LocalDate dateEnregistre, String nom, String url) {
		super(id, dateEnregistre);
		this.nom = nom;
		this.url = url;
	}

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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
