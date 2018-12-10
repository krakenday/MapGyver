package entity.uc6Jouer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import business.uc6Jouer.ReponseElire;
import entity.uc2Souvenir.EntityPhoto;
import entity.uc8Utilisateur.EntityUtilisateur;

@Entity
@Table(name = "rep_elir")
public class ReponseElireEntity extends ReponseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "r_pho", nullable = false)
	private EntityPhoto photoEntity;

	public ReponseElireEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReponseElireEntity(JeuEntity jeuEntity, EntityUtilisateur utilisateurEntity, LocalDate dateEmission,
			EntityPhoto photoEntity) {
		super(jeuEntity, utilisateurEntity, dateEmission);
		this.photoEntity = photoEntity;
	}

//	public ReponseElireEntity(LocalDate dateEmission, EntityUtilisateur utilisateurEntity, JeuEntity jeuEntity) {
//		super(dateEmission, utilisateurEntity, jeuEntity);
//	}

	public EntityPhoto getPhoto() {
		return photoEntity;
	}

	public void setPhoto(EntityPhoto photoEntity) {
		this.photoEntity = photoEntity;
	}

	@Override
	public String toString() {
		return "ReponseElireEntity [photoEntity=" + photoEntity + "]";
	}

	@Override
	public Class<?> getMappingMetier() {
		return ReponseElire.class;
	}
}
