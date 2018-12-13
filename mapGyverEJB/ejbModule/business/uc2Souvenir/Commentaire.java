package business.uc2Souvenir;

import java.time.LocalDate;

import business.uc4Voyage.Voyage;

public class Commentaire extends Souvenir {
	
	private static final long serialVersionUID = 1L;
	private String description;

	
	/**
	 * Constructeur a utiliser lors de la creation d'un Souvenir
	 * ,quand le commentaire est associé a une photo.
	 * @param description
	 */
	public Commentaire(String description) {
		super();
		this.setDescription(description);
	}
	
	
	public Commentaire(int id, LocalDate dateEnregistre, Voyage voyage, String description) {
		super(id, dateEnregistre, voyage);
		this.description = description;
	}




	public Commentaire() {
		super();
	}


	

	@Override
	public String toString() {
		return "Commentaire [description=" + description +super.toString()+ "]";
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
