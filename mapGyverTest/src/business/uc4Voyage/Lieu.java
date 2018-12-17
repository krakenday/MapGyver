
package business.uc4Voyage;

public class Lieu extends PointInteret{

	private int 	id;
	private String 	nom;
	/**
	 * Tous les points de meme longitude appartiennent a une ligne 
	 * epousant la courbure terrestre, coupant l'equateur a angle droit 
	 * et reliant le pole Nord au pole Sud.
	 */
	private float 	longitude;
	
	/**
	 *  Tous les points de meme latitude forment un cercle 
	 *  dont le plan est parallèle à celui de l'équateur
	 */
	private float 	latitude;
		
	/**
	 * @param id		: numero de reference du lieu
	 * @param nom		: nom du lieu
	 * @param longitude	: longitude du lieu
	 * @param lattitude : latitude du lieu
	 */
	public Lieu(int id, String nom, float longitude, float lattitude) {
		super();
		this.id 		= id;
		this.nom 		= nom;
		this.longitude 	= longitude;
		this.latitude 	= lattitude;
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

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLattitude() {
		return latitude;
	}

	public void setLattitude(float lattitude) {
		this.latitude = lattitude;
	}

	@Override
	public String toString() {
		return String.format("Lieu [id= %s, nom= %s, longitude= %s, lattitude= %s]",
				id, nom, longitude, latitude);
	}
	
}
