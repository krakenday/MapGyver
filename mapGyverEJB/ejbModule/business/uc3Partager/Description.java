package business.uc3Partager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import business.uc8Utilisateur.Utilisateur;

public class Description implements Serializable{

	private static final long serialVersionUID = 4779091453136945489L;
	
	private int id;
	private String libelleCommentaire;
	private LocalDate dateEdition;
	private int nbLike;
	private Utilisateur utilisateur;
	private TypeCommentaire typeCommentaire;
	private Partageable partageable;
	private List<Avis> avis;
	
	public Description(int id, String libelleCommentaire, LocalDate dateEdition, int nbLike) {
		super();
		this.id = id;
		this.libelleCommentaire = libelleCommentaire;
		this.dateEdition = dateEdition;
		this.nbLike = nbLike;
	}
	
	public Description(String libelleCommentaire, LocalDate dateEdition, int nbLike) {
		super();
		this.libelleCommentaire = libelleCommentaire;
		this.dateEdition = dateEdition;
		this.nbLike = nbLike;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleCommentaire() {
		return libelleCommentaire;
	}

	public void setLibelleCommentaire(String libelleCommentaire) {
		this.libelleCommentaire = libelleCommentaire;
	}

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TypeCommentaire getTypeCommentaire() {
		return typeCommentaire;
	}

	public void setTypeCommentaire(TypeCommentaire typeCommentaire) {
		this.typeCommentaire = typeCommentaire;
	}

	public Partageable getPartageable() {
		return partageable;
	}

	public void setPartageable(Partageable partageable) {
		this.partageable = partageable;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	@Override
	public String toString() {
		return "CLASSE METIER DESCRIPTION >>> Description [id=" + id + ", libelleCommentaire=" + libelleCommentaire + ", dateEdition=" + dateEdition
				+ ", nbLike=" + nbLike + "]";
	}
	
	
}
