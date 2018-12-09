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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entity.uc4Voyage.EntityVoyage;


//TODO must implements "Partageable" A voir!!!

@Entity
@Table(name="MPG_photo")
public class EntityPhoto extends EntitySouvenir {
	
	private static final long serialVersionUID = 1L;
	
	//Pas de CascadeType Delete, car le commentaire peut exister sans photo associe
	//fetch de type EAGER pour l'instant. Lazy plus approprie car pas besoin de 
	//remonter systemetiquement un commentaire.
	@OneToOne(cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="id_com",nullable=true)
	private EntityCommentaire commentaire;
	
	@Column(name="nom", length=50)
	private String nom;
	@Column(name="url", length=150, nullable=true)
	private String url;
	
	
	
	
	
	/**
	 * Constructeur pour persister Photo
	 * @param id
	 * @param entityVoyage
	 * @param dateEnregistre
	 * @param commentaire
	 * @param nom
	 */
	public EntityPhoto(EntityVoyage entityVoyage, LocalDate dateEnregistre, EntityCommentaire commentaire,
			String nom) {
		super(entityVoyage, dateEnregistre);
		this.commentaire = commentaire;
		this.nom = nom;
	}
	
	/**
	 * Constructeur pour persister Photo sans commentaire
	 * @param id
	 * @param entityVoyage
	 * @param localDate
	 * @param commentaire
	 * @param nom
	 */
	public EntityPhoto(EntityVoyage entityVoyage,String nom) {
		super(entityVoyage);
		this.nom = nom;
	}
	
	


	//cc par defaut necessaire a hibernate
	public EntityPhoto() {
		super();
	}






	@Override
	public String toString() {
		return "EntityPhoto [commentaire=" + commentaire + ", nom=" + nom + ", url=" + url + "]";
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

	public EntityCommentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(EntityCommentaire commentaire) {
		this.commentaire = commentaire;
	}

	

}
