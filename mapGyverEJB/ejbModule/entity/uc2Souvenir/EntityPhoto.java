package entity.uc2Souvenir;

/**
 * @author Alejandro
 * Le fichier "image" est stocke sur AWS S3,
 * l'acces a l'image se fait en fournissant une url
 * au webBrowser
 * Les autre proprietes sont stockes sur Oracle
 * 
 */

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


//TODO must implements "Partageable" A voir!!!

@Entity
@Table(name="photo")
public class EntityPhoto extends EntitySouvenir {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="nom", length=50)
	private String nom;
	@Column(name="url", length=150, nullable=true)
	private String url;
	
	
	public EntityPhoto(LocalDate dateEnregistre, String nom) {
		super(dateEnregistre);
		this.nom = nom;
	}
	
	//cc par defaut necessaire a hibernate
	public EntityPhoto() {
		super();
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

	

}
