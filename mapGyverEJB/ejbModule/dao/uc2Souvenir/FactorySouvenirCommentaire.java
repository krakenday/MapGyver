package dao.uc2Souvenir;

import business.uc2Souvenir.Souvenir;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;

public class FactorySouvenirCommentaire implements ICreateEntitySouvenir {


	@Override
	public EntityCommentaire createEntityCommentaire(Souvenir souvenir) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//ne dois pas etre utilise
	@Override
	public EntityPhoto createEntityPhoto(Souvenir souvenir) {
		// TODO Auto-generated method stub
		return null;
	}

}
