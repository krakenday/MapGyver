
package business.uc4Voyage;

public class Ville extends PointInteret{

	private int 	id;
	private String 	nom;
	
	public Ville(int id, String nom) {
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
		return String.format("Ville [id=%s, nom=%s]", id, nom);
	}

}
