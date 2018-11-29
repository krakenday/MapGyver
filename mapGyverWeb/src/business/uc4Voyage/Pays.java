
package business.uc4Voyage;

public class Pays extends PointInteret{

	private int 	id;
	private String 	nom;
	private int 	nbTotal;
	
	public Pays(int id, String nom, int nbTotal) {
		super();
		this.id 		= id;
		this.nom 		= nom;
		this.nbTotal 	= nbTotal;
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

	public int getNbTotal() {
		return nbTotal;
	}

	public void setNbTotal(int nbTotal) {
		this.nbTotal = nbTotal;
	}

	@Override
	public String toString() {
		return String.format("Pays [id= %s, nom= %s, nbTotal= %s]",
				id, nom, nbTotal);
	}

	
	
}
