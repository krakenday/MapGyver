
package business.uc4Voyage;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(pays);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Ville))
			return false;
		Ville other = (Ville) obj;
		return Objects.equals(pays, other.pays);
	}

}
