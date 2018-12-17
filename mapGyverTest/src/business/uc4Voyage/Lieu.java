
package business.uc4Voyage;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Lieu))
			return false;
		Lieu other = (Lieu) obj;
		return Objects.equals(ville, other.ville);
	}

}
