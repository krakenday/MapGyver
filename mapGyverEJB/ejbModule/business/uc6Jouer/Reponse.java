package business.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

public class Reponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate dateEmission;
	
	public Reponse() {
		
	}

	public Reponse(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Reponse(int id, LocalDate dateEmission) {
		this.id = id;
		this.dateEmission = dateEmission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", dateEmission=" + dateEmission + "]";
	}
}
