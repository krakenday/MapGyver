package business.uc6Jouer;

import java.time.LocalDate;

public class Jeu {
	
	private int id;
	private String nom;
	private LocalDate dateCreation;
	
	
	
	public Jeu() {
		super();
	}







	public Jeu(String nom, LocalDate dateCreation) {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
	}







	public Jeu(int id, String nom, LocalDate dateCreation) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
	}

}
