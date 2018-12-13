package business.uc4Voyage;

import java.io.Serializable;

public abstract class PointInteret implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int 		id;
	private String  	nom;
	private Coordonnee 	coordonnee;
	
	public PointInteret() {
	}

	public PointInteret(String nom) {
		this.nom = nom;
	}

	public PointInteret(String nom, Coordonnee coordonnee) {
		this.nom = nom;
		this.coordonnee = coordonnee;
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

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	@Override
	public String toString() {
		return "PointInteret [id=" + id + ", nom=" + nom + ", coordonnee=" + coordonnee + "]";
	}
	
}
