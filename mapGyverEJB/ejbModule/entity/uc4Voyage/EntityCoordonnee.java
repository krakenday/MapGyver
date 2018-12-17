package entity.uc4Voyage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.util.UtilBdD;

@Embeddable
public class EntityCoordonnee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private int 	id;
	
	/**
	 *  Tous les points de meme latitude forment un cercle 
	 *  dont le plan est parallèle à celui de l'équateur
	 */
	@Column(name="lat_Crd", nullable=false)
	private double 	latitude;
	
	/**
	 * Tous les points de meme longitude appartiennent a une ligne 
	 * epousant la courbure terrestre, coupant l'equateur a angle droit 
	 * et reliant le pole Nord au pole Sud.
	 */
	@Column(name="long_Crd", nullable=false)
	private double 	longitude;

	public EntityCoordonnee() {
	}

	public EntityCoordonnee(double latitude, double longitude) {
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
		return "EntityCoordonnee [id=" + id + ", lat.=" + latitude + ", long.=" + longitude + "]";
	}


	
}
