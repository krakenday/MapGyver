package business.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import business.uc8Utilisateur.Utilisateur;

public abstract class Reponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate dateEmission;
	private Utilisateur utilisateur;
	private Jeu jeu;

	public Reponse() {

	}

	public Reponse(LocalDate dateEmission, Utilisateur utilisateur, Jeu jeu) {
		this.dateEmission = dateEmission;
		this.utilisateur = utilisateur;
		this.jeu = jeu;
	}

	public Reponse(int id, LocalDate dateEmission, Utilisateur utilisateur, Jeu jeu) {
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
	 * Va permettre de fournir l Entity lier au Metier
	 * 
	 * @return
	 */
	public abstract Class<?> getMappingEntity();

}
