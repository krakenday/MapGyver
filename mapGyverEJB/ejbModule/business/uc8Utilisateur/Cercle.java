package business.uc8Utilisateur;

import java.io.Serializable;

/**
 * Projet - MapGyver
 * 
 * La classe Cercle est abstraite
 * <Br> 
 * Le Cercle à un : 
 * <br> id : référence unique
 * <br> nom : nom du cercle
 * <br> utilisateur : l'utilisateur a qui appartient le cercle 
 * @see Utilisateur
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 */
public abstract class Cercle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private Utilisateur utilisateur;
	
	public Cercle() {
		super();
	}
	
	public Cercle(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Cercle(String nom) {
		super();
		this.nom = nom;
	}	
	
	public Cercle(int id, String nom, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.utilisateur = utilisateur;
	}

	public Cercle(String nom, Utilisateur utilisateur) {
		super();
		this.nom = nom;
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
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Cercle [id=" + id + ", nom=" + nom + ", utilisateur=" + utilisateur + "]";
	}


		
}
