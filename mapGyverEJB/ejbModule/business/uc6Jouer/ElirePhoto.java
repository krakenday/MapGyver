package business.uc6Jouer;

import java.time.LocalDate;
import java.util.Collection;

import business.uc2Souvenir.Photo;
import business.uc8Utilisateur.Utilisateur;
import entity.uc6Jouer.ElirePhotoEntity;

public class ElirePhoto extends Jeu {

	private static final long serialVersionUID = 1L;

	private LocalDate dateFinInscription;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Collection<Photo> photos;

	public ElirePhoto() {

	}

	public ElirePhoto(int id, String nom, LocalDate dateCreation, Utilisateur utilisateur, LocalDate dateFinInscription,
			LocalDate dateDebut, LocalDate dateFin, Collection<Photo> photos) {
		super(id, nom, dateCreation, utilisateur);
		this.dateFinInscription = dateFinInscription;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.photos = photos;
	}

	public ElirePhoto(String nom, LocalDate dateCreation, Utilisateur utilisateur, LocalDate dateFinInscription,
			LocalDate dateDebut, LocalDate dateFin, Collection<Photo> photos) {
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

	public Collection<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "ElirePhoto=>" + super.toString() + "[dateFinInscription=" + dateFinInscription + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}

	@Override
	public Class<?> getMappingEntity() {
		return ElirePhotoEntity.class;
	}
}
