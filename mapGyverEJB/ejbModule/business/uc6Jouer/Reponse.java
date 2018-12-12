package business.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import business.uc8Utilisateur.Utilisateur;

public abstract class Reponse implements Serializable {

	private static final long serialVersionUID = 1L;
	// private GestId id = new GestId(); pas besoin de l'identifiant dans la classe
	// metier vision objet
	private LocalDate dateEmission;
	private Jeu jeu;
	private Utilisateur utilisateur;

	public Reponse() {

	}

//	public ReponseEntity(LocalDate dateEmission, EntityUtilisateur utilisateurEntity, JeuEntity jeuEntity) {
//		this.dateEmission = dateEmission;
//		this.utilisateurEntity = utilisateurEntity;
//		this.jeuEntity = jeuEntity;
//	}

	public Reponse(Jeu jeu, Utilisateur utilisateur, LocalDate dateEmission) {
//		getId().setIdJeu(jeu.getId());
//		getId().setIdJoueur(utilisateur.getId());
		this.dateEmission = dateEmission;
		this.utilisateur = utilisateur;
		this.jeu = jeu;
	}

//	public GestId getId() {
//		return id;
//	}
//
//	public void setId(entity.uc6Jouer.ReponseEntity.GestId gestId) {
//		this.id = gestId;
//	}

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
		return "Reponse [ dateEmission=" + dateEmission + ", utilisateur=" + utilisateur.getId() + ", jeu="
				+ jeu.getId() + "]";
	}

	/**
	 * Va permettre de fournir l'Entity lié au Metier
	 * 
	 * @return
	 */
	public abstract Class<?> getMappingEntity();

//	/**
//	 * Permet la creation de l'identifiant de Reponse compose de l id d un jeu et l
//	 * id d un utilisateur
//	 * 
//	 * @author lours
//	 *
//	 */
//
//	public static class GestId implements Serializable {
//
//		private static final long serialVersionUID = 1L;
//
//		private int idJeu;
//		private int idJoueur;
//
//		public GestId() {
//			super();
//		}
//
//		public GestId(int idJeu, int idJoueur) {
//			super();
//			this.idJeu = idJeu;
//			this.idJoueur = idJoueur;
//		}
//
//		public int getIdJeu() {
//			return idJeu;
//		}
//
//		public void setIdJeu(int idJeu) {
//			this.idJeu = idJeu;
//		}
//
//		public int getIdJoueur() {
//			return idJoueur;
//		}
//
//		public void setIdJoueur(int idJoueur) {
//			this.idJoueur = idJoueur;
//		}
//	}
}
