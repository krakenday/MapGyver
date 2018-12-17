package business.uc4Voyage;

import java.io.Serializable;
import java.util.Objects;

public class Coordonnee implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private int 	id;
	
	/**
	 *  Tous les points de meme latitude forment un cercle 
	 *  dont le plan est parallèle à celui de l'équateur
	 */
	private double 	latitude;
	/**
	 * Tous les points de meme longitude appartiennent a une ligne 
	 * epousant la courbure terrestre, coupant l'equateur a angle droit 
	 * et reliant le pole Nord au pole Sud.
	 */
	private double 	longitude;
	
	public Coordonnee() {
	}

	public Coordonnee(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Coordonnee [id=" + id + ", lat.=" + latitude + ", long.=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, latitude, longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordonnee))
			return false;
		Coordonnee other = (Coordonnee) obj;
		return id == other.id && Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude);
	}
	
}
