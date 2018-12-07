
package business.uc4Voyage;

public class Lieu extends PointInteret{

	private static final long serialVersionUID = 1L;
	
	private Ville 	ville;

	public Lieu() {
	}

	public Lieu(String nom) {
		super(nom);
	}
	
	public Lieu(String nom, Coordonnee coordonnee) {
		super(nom, coordonnee);
	}

	public Lieu(String nom, Coordonnee coordonnee, Ville ville) {
		super(nom, coordonnee);
		this.ville = ville;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Lieu " + super.toString() + String.format("[ville=%s]", ville);
	}





}
