package business.uc6Jouer;

import java.time.LocalDate;

import business.uc2Souvenir.Photo;
import business.uc8Utilisateur.Utilisateur;

public class ReponseElire extends Reponse {

	private static final long serialVersionUID = 1L;

	private Photo photo;

	public ReponseElire() {
		super();
	}

	public ReponseElire(Jeu jeu, Utilisateur utilisateur, LocalDate dateEmission, Photo photo) {
		super(jeu, utilisateur, dateEmission);
		this.photo = photo;
	}

//	public ReponseElireEntity(LocalDate dateEmission, EntityUtilisateur utilisateurEntity, JeuEntity jeuEntity) {
//		super(dateEmission, utilisateurEntity, jeuEntity);
//	}

	public Photo getPhoto() {
		return photo;
	}

	public void Photo(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ReponseElireEntity [photoEntity=" + photo + "]";
	}

}
