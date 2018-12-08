package dao.uc2Souvenir;

import business.uc2Souvenir.Photo;
import entity.uc2Souvenir.EntityPhoto;

public class FactorySouvenirPhotoComplet extends FactorySouvenirPhoto implements ICreateEntitySouvenirPhoto {

	@Override
	public EntityPhoto createEntityPhoto(Photo photo) {
		System.out.println("*****dao.FactorySouvenirPhotoComplet-createEntity");
		
		//permet de stocker l'image au format jpeg su aws S3
		sauvegardeImageCloud(photo);
		
		return null;
	}


}
