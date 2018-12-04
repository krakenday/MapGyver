package business.uc2Souvenir;

import java.io.Serializable;

/**
 * Un Souvenir est soit un Commentaire, soit une Photo
 */

import java.time.LocalDate;

import business.uc4Voyage.Voyage;

public abstract class Souvenir implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int 		id;
	private LocalDate 	dateEnregistre;
	private Voyage 		voyage;
	
	public Souvenir(int id, LocalDate dateEnregistre, Voyage voyage) {
		this.id = id;
		this.dateEnregistre = dateEnregistre;
		this.voyage = voyage;
	}

	public Souvenir(LocalDate dateEnregistre, Voyage voyage) {
		this.dateEnregistre = dateEnregistre;
		this.voyage			= voyage;
	}

	//constructeur par defaut
	public Souvenir() {
	}

	@Override
	public String toString() {
		return "Souvenir [id=" + id + ", dateEnregistre=" + dateEnregistre + "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateEnregistre() {
		return dateEnregistre;
	}

	public void setDateEnregistre(LocalDate dateEnregistre) {
		this.dateEnregistre = dateEnregistre;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	

}
