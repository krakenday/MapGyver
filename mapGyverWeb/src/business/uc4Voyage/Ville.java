
package business.uc4Voyage;

public class Ville extends PointInteret{

	private static final long serialVersionUID = 1L;
	
	private Pays pays;
	
	public Ville() {
	}
	
	public Ville(String nom) {
		super(nom);
	}

	public Ville(String nom, Coordonnee coordonnee) {
		super(nom, coordonnee);
	}

	public Ville(String nom, Coordonnee coordonnee, Pays pays) {
		super(nom, coordonnee);
		this.pays = pays;
	}
	
	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Ville " + super.toString() + String.format("[Pays=%s]", pays);
	}

}
