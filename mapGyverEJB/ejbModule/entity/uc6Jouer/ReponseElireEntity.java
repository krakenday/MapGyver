package entity.uc6Jouer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import business.uc2Souvenir.Photo;
import business.uc6Jouer.ReponseElire;

@Entity
public class ReponseElireEntity extends ReponseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "r_pho", nullable = false)
	private Photo photo;

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public Class<?> getMappingMetier() {
		return ReponseElire.class;
	}
}
