package business.uc2Souvenir;


import java.time.LocalDate;

public class Commentaire extends Souvenir {
	
	private String description;

	public Commentaire(int id, LocalDate dateEnregistre, String description) {
		super(id, dateEnregistre);
		this.description = description;
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
