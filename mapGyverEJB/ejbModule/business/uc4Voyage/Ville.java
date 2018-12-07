
package business.uc4Voyage;

public class Ville extends PointInteret{

	private static final long serialVersionUID = 1L;
	
	private int 	id;
	private String 	nom;
	private Pays pays;
	
	public Ville(String nom) {
		this.nom 	= nom;
	}

	public Ville(String nom, Coordonnee coordonnee) {
		super(nom, coordonnee);
		// TODO Auto-generated constructor stub
	}

	public Ville(String nom, Coordonnee coordonnee, Pays pays) {
		super(nom, coordonnee);
		this.pays = pays;
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

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", pays=" + pays + "]";
	}

}
