package dao.uc2Souvenir;

import business.uc2Souvenir.Souvenir;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;

public interface ICreateEntitySouvenir {
	
	public EntityPhoto createEntityPhoto(Souvenir souvenir);

	public EntityCommentaire createEntityCommentaire(Souvenir souvenir);

}
