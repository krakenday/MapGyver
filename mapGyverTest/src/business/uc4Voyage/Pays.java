
package business.uc4Voyage;

public class Pays extends PointInteret{

	private int 		id;
	private String 		nom;
	private String		capitale;
	public final int 	NB_TOTAL = 197;
	
	public Pays(int id, String nom) {
		super();
		this.id 	= id;
		this.nom 	= nom;
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

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	
	@Override
	public String toString() {
		return String.format("Pays [id = %s, nom = %s, capitale = %s]",
				id, nom, capitale);
	}
	
}
