package business.uc6Jouer;

import java.time.LocalDate;

import business.uc2Souvenir.Photos;
import business.uc8Utilisateur.Utilisateur;

public class ElirePhoto extends Jeu {

	private static final long serialVersionUID = 1L;

	private LocalDate dateFinInscription;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Photos photos;

	public ElirePhoto() {

	}

	public ElirePhoto(int id, String nom, LocalDate dateCreation, Utilisateur utilisateur, LocalDate dateFinInscription,
			LocalDate dateDebut, LocalDate dateFin, Photos photos) {
		super(id, nom, dateCreation, utilisateur);
		this.dateFinInscription = dateFinInscription;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.photos = photos;
	}

	public ElirePhoto(String nom, LocalDate dateCreation, Utilisateur utilisateur, LocalDate dateFinInscription,
			LocalDate dateDebut, LocalDate dateFin, Photos photos) {
		super(nom, dateCreation, utilisateur);
		this.dateFinInscription = dateFinInscription;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.photos = photos;
	}

	public LocalDate getDateFinInscription() {
		return dateFinInscription;
	}

	public void setDateFinInscription(LocalDate dateFinInscription) {
		this.dateFinInscription = dateFinInscription;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Photos getPhotos() {
		return photos;
	}

	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "ElirePhoto [dateFinInscription=" + dateFinInscription + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", photos=" + photos + "]";
	}

	@Override
	public Class<?> getMappingEntity() {
		return ReponseElire.class;
	}
}
