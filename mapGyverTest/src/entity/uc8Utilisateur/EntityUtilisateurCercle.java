package entity.uc8Utilisateur;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;

//@Entity
//@Table(name="UTILISATEUR_CERCLE")
public class EntityUtilisateurCercle implements Serializable{

	// NON UTILISABLE POUR LE MOMENT !!!!!!!!!
	
	
	private static final long serialVersionUID = 1L;
//
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_utilisateur", insertable= false, updatable= false)
//	private EntityUtilisateur utilisateur;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_cercle", insertable= false, updatable= false)
//	private EntityCercle cercle;
//	
//	@EmbeddedId
//	private Id id= new Id();
//	
//	public EntityUtilisateurCercle() {
//		
//	}
//	
//	public EntityUtilisateurCercle(EntityUtilisateur utilisateur, EntityCercle cercle) {
//		
//		getId().setId_utilisateur(utilisateur.getId());
//		getId().setId_cercle(cercle.getId());
//		
//		this.setUtilisateur(utilisateur);
//		this.setCercle(cercle);
//		
//	}
//	
//	/**
//	 * @return the utilisateur
//	 */
//	public EntityUtilisateur getUtilisateur() {
//		return utilisateur;
//	}
//
//	/**
//	 * @param utilisateur the utilisateur to set
//	 */
//	public void setUtilisateur(EntityUtilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}
//
//	/**
//	 * @return the cercle
//	 */
//	public EntityCercle getCercle() {
//		return cercle;
//	}
//
//	/**
//	 * @param cercle the cercle to set
//	 */
//	public void setCercle(EntityCercle cercle) {
//		this.cercle = cercle;
//	}
//
//
//	/**
//	 * @return the id
//	 */
//	public Id getId() {
//		return id;
//	}
//
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Id id) {
//		this.id = id;
//	}
//	
//	// TODO modifier l'affichage
//	@Override
//	public String toString() {
//		return "EntityUtilisateurCercle [utilisateur=" + utilisateur + ", cercle=" + cercle + ", id=" + id + "]";
//	}
//	
//	
//	
//	// La classe Id
//	@Embeddable
//	public static class Id implements Serializable {
//
//		private static final long serialVersionUID = 1L;
//		
//		@Column(name= "id_utilisateur", nullable=false)
//		private int id_utilisateur;
//		
//		@Column(name= "id_cercle", nullable=false)
//		private int id_cercle;
//
//		
//		public Id() {
//			super();
//		}
//		
//		
//		/**
//		 * @param id_utilisateur
//		 * @param id_cercle
//		 */
//		public Id(int id_utilisateur, int id_cercle) {
//			super();
//			this.id_utilisateur = id_utilisateur;
//			this.id_cercle = id_cercle;
//		}
//
//		/**
//		 * @return the id_utilisateur
//		 */
//		public int getId_utilisateur() {
//			return id_utilisateur;
//		}
//
//		/**
//		 * @param id_utilisateur the id_utilisateur to set
//		 */
//		public void setId_utilisateur(int id_utilisateur) {
//			this.id_utilisateur = id_utilisateur;
//		}
//
//		/**
//		 * @return the id_cercle
//		 */
//		public int getId_cercle() {
//			return id_cercle;
//		}
//
//		/**
//		 * @param id_cercle the id_cercle to set
//		 */
//		public void setId_cercle(int id_cercle) {
//			this.id_cercle = id_cercle;
//		}
//		
//		@Override
//		public String toString() {
//			return "Id [id_utilisateur=" + id_utilisateur + ", id_cercle=" + id_cercle + "]";
//		}
//	}

}
