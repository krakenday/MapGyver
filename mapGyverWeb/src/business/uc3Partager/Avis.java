package business.uc3Partager;

import java.io.Serializable;
import java.time.LocalDate;

public class Avis implements Serializable{

	private static final long serialVersionUID = -8270835856266001451L;

	private int id;
	private LocalDate dateEdition;
	private String libelleCommentaire;
	private int nbLike;
	
	public Avis(int id, LocalDate dateEdition, String libelleCommentaire, int nbLike) {
		super();
		this.id = id;
		this.dateEdition = dateEdition;
		this.libelleCommentaire = libelleCommentaire;
		this.nbLike = nbLike;
	}
	
	public Avis(LocalDate dateEdition, String libelleCommentaire, int nbLike) {
		super();
		this.dateEdition = dateEdition;
		this.libelleCommentaire = libelleCommentaire;
		this.nbLike = nbLike;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public String getLibelleCommentaire() {
		return libelleCommentaire;
	}

	public void setLibelleCommentaire(String libelleCommentaire) {
		this.libelleCommentaire = libelleCommentaire;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	@Override
	public String toString() {
		return "CLASSE METIER AVIS >>> Avis [id=" + id + ", dateEdition=" + dateEdition + ", libelleCommentaire=" + libelleCommentaire
				+ ", nbLike=" + nbLike + "]";
	}
	
	
}
