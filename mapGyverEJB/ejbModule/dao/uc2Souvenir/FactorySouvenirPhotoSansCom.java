package dao.uc2Souvenir;

import business.uc2Souvenir.Souvenir;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;

public class FactorySouvenirPhotoSansCom implements ICreateEntitySouvenir {

	@Override
	public EntityPhoto createEntityPhoto(Souvenir souvenir) {
		System.out.println("*****dao.FactorySouvenirPhotoSansCom-createEntity");
		return null;
	}

	
	//ne dois pas etre utilise
	@Override
	public EntityCommentaire createEntityCommentaire(Souvenir souvenir) {
		return null;
	}

}
