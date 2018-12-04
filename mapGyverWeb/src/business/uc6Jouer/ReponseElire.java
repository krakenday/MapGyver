package business.uc6Jouer;

import business.uc2Souvenir.Photo;

public class ReponseElire extends Reponse {

	private static final long serialVersionUID = 1L;

	private Photo photo;

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public Class<?> getMappingEntity() {
		return ReponseElire.class;
	}

}
