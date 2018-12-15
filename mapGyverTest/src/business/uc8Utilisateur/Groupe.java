package business.uc8Utilisateur;

import java.io.Serializable;

/**
 * Projet - MapGyver
 * Cette classe premt d'instancier un objet de type Groupe,  le groupe est créé par un utilisateur
 * Groupe hérite de la classe Cercle
 * <Br> 
 * @see Cercle
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 * Un groupe peut contenir un ou plusieurs utilisateurs
 * Un groupe appartient à un seul utilisateur
 * 
 */
public class Groupe extends Cercle implements Serializable {

	private static final long serialVersionUID = 1L;
	

	public Groupe() {
		super();
	}
	
	/**
	 * 
	 * @param id : identifiant du groupe
	 * @param nom : nom du groupe
	 */	
	public Groupe(int id, String nom) {
		super(id, nom);
	}
	
	public Groupe(String nom) {
		super(nom);
	}
	
	/**
	 * 
	 * @param id : identifiant du groupe
	 * @param nom : nom du groupe
	 * @param utilisateur : utilisateur de l'application
	 */
	public Groupe(int id, String nom, Utilisateur utilisateur) {
		super(id, nom, utilisateur);
	}
	
	public Groupe(String nom, Utilisateur utilisateur) {
		super(nom, utilisateur);
	}
	
}
