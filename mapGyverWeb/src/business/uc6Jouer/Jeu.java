package business.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import business.uc8Utilisateur.Utilisateur;

public class Jeu implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private LocalDate dateCreation;
	private Utilisateur utilisateur;

	public Jeu() {

	}

	public Jeu(String nom, LocalDate dateCreation, Utilisateur utilisateur) {
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.utilisateur = utilisateur;
	}

	public Jeu(int id, String nom, LocalDate dateCreation, Utilisateur utilisateur) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + "Utilisateur Id"
				+ utilisateur.getId() + "]";
	}
}
