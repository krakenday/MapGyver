package business.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

public class Jeu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private LocalDate dateCreation;
	
	public Jeu() {
		
	}

	public Jeu(String nom, LocalDate dateCreation) {
		this.nom = nom;
		this.dateCreation = dateCreation;
	}

	public Jeu(int id, String nom, LocalDate dateCreation) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
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

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + "]";
	}
}
