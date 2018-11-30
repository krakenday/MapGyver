package business.uc8Utilisateur;

import java.io.Serializable;

/**
 * @author Djallal
 * 
 * Classe metier Cercle
 */
public abstract class Cercle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	
	public Cercle() {
		super();
	}
	
	public Cercle(String nom) {
		super();
		this.nom = nom;
	}
	
	public Cercle(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Cercle [id=" + id + ", nom=" + nom + "]";
	}
		
}
