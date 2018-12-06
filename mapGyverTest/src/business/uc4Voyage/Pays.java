
package business.uc4Voyage;

public class Pays extends PointInteret{

	private static final long serialVersionUID = 1L;
	
	public static final int NB_TOTAL = 197;
	
	public Pays() {
	}
	
	public Pays(String nom) {
		super(nom);
	}
	
	public Pays(String nom, Coordonnee coordonnee) {
		super(nom, coordonnee);
	}	
	
}
