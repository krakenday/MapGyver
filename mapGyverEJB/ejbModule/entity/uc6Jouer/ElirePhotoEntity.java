package entity.uc6Jouer;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import business.uc8Utilisateur.Utilisateur;
import entity.uc2Souvenir.EntityPhoto;

@Entity
@Table(name = "elir_pho")
public class ElirePhotoEntity extends JeuEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "d_f_insc", nullable = false)
	private LocalDate dateFinInscription;
	@Column(name = "d_deb", nullable = false)
	private LocalDate dateDebut;
	@Column(name = "d_fin", nullable = false)
	private LocalDate dateFin;

	@ManyToMany
	@JoinTable(name = "pho_jeu_elir", joinColumns = @JoinColumn(name = "id_jeu"), inverseJoinColumns = @JoinColumn(name = "id_pho"))
	private Collection<EntityPhoto> photosEntity;

	public ElirePhotoEntity() {

	}

	public ElirePhotoEntity(int id, String nom, LocalDate dateCreation, Utilisateur utilisateur,
			LocalDate dateFinInscription, LocalDate dateDebut, LocalDate dateFin,
			Collection<EntityPhoto> photosEntity) {
		super(id, nom, dateCreation, utilisateur);
		this.dateFinInscription = dateFinInscription;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.photosEntity = photosEntity;
	}

	public ElirePhotoEntity(String nom, LocalDate dateCreation, Utilisateur utilisateur, LocalDate dateFinInscription,
			LocalDate dateDebut, LocalDate dateFin, Collection<EntityPhoto> photosEntity) {
		super(nom, dateCreation, utilisateur);
		this.dateFinInscription = dateFinInscription;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.photosEntity = photosEntity;
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

	@Override
	public String toString() {
		return "ElirePhoto=>" + super.toString() + "[dateFinInscription=" + dateFinInscription + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}

	@Override
	public Class<?> getMappingMetier() {
		// TODO Auto-generated method stub
		return null;
	}

}
