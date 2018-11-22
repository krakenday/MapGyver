package business.uc8Utilisateur;

/**
 * @author Djallal
 * 
 * Classe metier Cercle
 */
public abstract class Cercle {

	private int id;
	private String nom;
	
	public Cercle() {
		super();
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
