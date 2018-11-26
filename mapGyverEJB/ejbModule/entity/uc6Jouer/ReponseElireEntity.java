package entity.uc6Jouer;

import javax.persistence.Column;
import javax.persistence.Entity;

import business.uc2Souvenir.Photo;
import business.uc6Jouer.ReponseElire;

@Entity
public class ReponseElireEntity extends ReponseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "r_pho", nullable = false)
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
