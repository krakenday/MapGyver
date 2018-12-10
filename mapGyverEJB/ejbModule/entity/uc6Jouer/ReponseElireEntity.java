package entity.uc6Jouer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import business.uc6Jouer.ReponseElire;
import entity.uc2Souvenir.EntityPhoto;

@Entity
@Table(name = "rep_elir_pho")
public class ReponseElireEntity extends ReponseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "r_pho", nullable = false)
	private EntityPhoto photoEntity;

	public EntityPhoto getPhoto() {
		return photoEntity;
	}

	public void setPhoto(EntityPhoto photoEntity) {
		this.photoEntity = photoEntity;
	}

	@Override
	public Class<?> getMappingMetier() {
		return ReponseElire.class;
	}
}
