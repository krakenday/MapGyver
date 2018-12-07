package business.uc8Utilisateur;

import java.io.Serializable;

/**
 * Projet - MapGyver
 * Cette classe premt d'instancier un objet de type ListeDiffusion, la liste de diffusion est créée par un utilisateur
 * ListeDiffusion hérite de la classe Cercle
 * <Br> 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 * Une liste de diffusion peut contenir un ou plusieurs utilisateurs
 * La liste peut contenir des utilisateurs ou des contacts
 * TODO ajouter un contact dans la liste
 * 
 */
public class ListeDiffusion extends Cercle implements Serializable {

	private static final long serialVersionUID = 1L;

	public ListeDiffusion() {
		super();
	}
	
	public ListeDiffusion(int id, String nom) {
		super(id, nom);
	}
	
	public ListeDiffusion(String nom) {
		super(nom);
	}

	public ListeDiffusion(int id, String nom, Utilisateur utilisateur) {
		super(id, nom, utilisateur);
	}
	
	public ListeDiffusion(String nom, Utilisateur utilisateur) {
		super(nom, utilisateur);
	}
	
	

}
