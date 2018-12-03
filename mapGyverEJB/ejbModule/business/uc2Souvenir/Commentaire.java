package business.uc2Souvenir;

import java.time.LocalDate;

public class Commentaire extends Souvenir {
	
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
	
	
	@Override
	public String toString() {
		return "Commentaire [description=" + description + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
