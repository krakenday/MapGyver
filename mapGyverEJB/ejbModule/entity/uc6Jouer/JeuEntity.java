package entity.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityUtilisateur;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class JeuEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 75, nullable = false)
	private String nom;
	@Column(name = "d_crea", nullable = false)
	private LocalDate dateCreation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private EntityUtilisateur utilisateur;

	public JeuEntity() {

	}

	public JeuEntity(String nom, LocalDate dateCreation, Utilisateur utilisateur) {
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.utilisateur = businessToEntity(utilisateur);
	}

	public JeuEntity(int id, String nom, LocalDate dateCreation, Utilisateur utilisateur) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.utilisateur = businessToEntity(utilisateur);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getUtilisateur() {
		return entityToBusiness(utilisateur);
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = businessToEntity(utilisateur);
	}

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + "Utilisateur Id " + "]";
	}

	/**
	 * Va permettre de fournir le Metier lier a l'entity
	 * 
	 * @return
	 */
	public abstract Class<?> getMappingMetier();

	private EntityUtilisateur businessToEntity(Utilisateur user) {
		EntityUtilisateur u = new EntityUtilisateur();
		u.setId(user.getId());
		u.setEmail(user.getEmail());
		return u;
	}

	private Utilisateur entityToBusiness(EntityUtilisateur user) {
		Utilisateur u = new Utilisateur();
		u.setId(user.getId());
		u.setEmail(user.getEmail());
		return u;
	}
}
