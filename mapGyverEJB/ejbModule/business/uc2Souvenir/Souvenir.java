package business.uc2Souvenir;

import java.io.Serializable;

/**
 * Un Souvenir est soit un Commentaire, soit une Photo
 */

import java.time.LocalDate;

public abstract class Souvenir implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate dateEnregistre;
	
	public Souvenir(int id, LocalDate dateEnregistre) {
		this.id = id;
		this.dateEnregistre = dateEnregistre;
	}

	public Souvenir(LocalDate dateEnregistre) {
		this.dateEnregistre = dateEnregistre;
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
	

}
