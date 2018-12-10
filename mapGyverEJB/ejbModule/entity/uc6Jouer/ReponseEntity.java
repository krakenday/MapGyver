package entity.uc6Jouer;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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

import business.uc6Jouer.Jeu;
import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityUtilisateur;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "reponse")
public abstract class ReponseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GestId id = new GestId();

	@Column(name = "d_emis", nullable = false)
	private LocalDate dateEmission;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_jeu", insertable = false, updatable = false, nullable = false)
	private JeuEntity jeuEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_joueur", insertable = false, updatable = false, nullable = false)
	private EntityUtilisateur utilisateurEntity;

	public ReponseEntity() {

	}

//	public ReponseEntity(LocalDate dateEmission, EntityUtilisateur utilisateurEntity, JeuEntity jeuEntity) {
//		this.dateEmission = dateEmission;
//		this.utilisateurEntity = utilisateurEntity;
//		this.jeuEntity = jeuEntity;
//	}

	public ReponseEntity(JeuEntity jeuEntity, EntityUtilisateur utilisateurEntity, LocalDate dateEmission) {
		getId().setIdJeu(jeuEntity.getId());
		getId().setIdJoueur(utilisateurEntity.getId());
		this.dateEmission = dateEmission;
		this.utilisateurEntity = utilisateurEntity;
		this.jeuEntity = jeuEntity;
	}

	public GestId getId() {
		return id;
	}

	public void setId(GestId id) {
		this.id = id;
	}

	public LocalDate getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	public EntityUtilisateur getUtilisateurEntity() {
		return utilisateurEntity;
	}

	public void setUtilisateurEntity(EntityUtilisateur utilisateurEntity) {
		this.utilisateurEntity = utilisateurEntity;
	}

	public JeuEntity getJeuEntity() {
		return jeuEntity;
	}

	public void setJeuEntity(JeuEntity jeuEntity) {
		this.jeuEntity = jeuEntity;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", dateEmission=" + dateEmission + ", utilisateur=" + utilisateurEntity.getId()
				+ ", jeu=" + jeuEntity.getId() + "]";
	}

	/**
	 * Va permettre de fournir le Metier lier a l'entity
	 * 
	 * @return
	 */
	public abstract Class<?> getMappingMetier();

	/**
	 * Permet la creation de l'identifiant de ReponseEntity compose de l id d un jeu
	 * et l id d un utilisateur
	 * 
	 * @author lours
	 *
	 */

	@Embeddable
	public static class GestId implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "id_jeu", nullable = false)
		private int idJeu;

		@Column(name = "id_joueur", nullable = false)
		private int idJoueur;

		public GestId() {
			super();
		}

		public GestId(int idJeu, int idJoueur) {
			super();
			this.idJeu = idJeu;
			this.idJoueur = idJoueur;
		}

		public int getIdJeu() {
			return idJeu;
		}

		public void setIdJeu(int idJeu) {
			this.idJeu = idJeu;
		}

		public int getIdJoueur() {
			return idJoueur;
		}

		public void setIdJoueur(int idJoueur) {
			this.idJoueur = idJoueur;
		}
	}
}
