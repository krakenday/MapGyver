package business.uc4Voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import business.uc8Utilisateur.Utilisateur;

/**
 * Un roabBook est la liste des voyages d'un utilisateur
 *  
 * @see Voyage
 * @see Utilisateur
 * @author Idriss
 */
public class RoadBook implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 
	 * Identifiant du RoadBook, permet de referencer l'instance 
	 */
	private int id;
	/** 
	 * Utilisateur Proprietaire du roadBook
	 */
	private Utilisateur utilisateur;
	/** 
	 * Liste de voyages composant le roadBook
	 */
	private List<Voyage> voyages = new ArrayList<Voyage>();
	
	/**
	 * @param id Identifiant du RoadBook, permet de referencer l'instance
	 * @param utilisateur Proprietaire du roadBook - {@link Utilisateur}
	 * @param voyages Liste de voyages composant le roadBook - {@link Voyage}
	 */
	public RoadBook(int id, Utilisateur utilisateur, List<Voyage> voyages) {
		super();
		this.id = id;
		this.voyages = voyages;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Voyage> getVoyage() {
		return voyages;
	}

	public void setVoyage(List<Voyage> voyage) {
		this.voyages = voyage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "RoadBook [id=" + id + ", voyages=" + voyages + ", utilisateur=" + utilisateur + "]";
	}
	
}
