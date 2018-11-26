package entity.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import business.uc6Jouer.Jeu;
import business.uc8Utilisateur.Utilisateur;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "reponse")
public abstract class ReponseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "d_emis", nullable = false)
	private LocalDate dateEmission;
	@Column(nullable = false)
	private Utilisateur utilisateur;
	@Column(nullable = false)
	private Jeu jeu;

	public ReponseEntity() {

	}

	public ReponseEntity(LocalDate dateEmission, Utilisateur utilisateur, Jeu jeu) {
		this.dateEmission = dateEmission;
		this.utilisateur = utilisateur;
		this.jeu = jeu;
	}

	public ReponseEntity(int id, LocalDate dateEmission, Utilisateur utilisateur, Jeu jeu) {
		this.id = id;
		this.dateEmission = dateEmission;
		this.utilisateur = utilisateur;
		this.jeu = jeu;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", dateEmission=" + dateEmission + ", utilisateur=" + utilisateur.getId()
				+ ", jeu=" + jeu.getId() + "]";
	}

	/**
	 * Va permettre de fournir le Metier lier a l'entity
	 * 
	 * @return
	 */
	public abstract Class<?> getMappingMetier();
}
