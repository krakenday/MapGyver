package dao.uc2Souvenir;

import org.joda.time.LocalDate;

import business.uc2Souvenir.Photo;
import business.uc4Voyage.Voyage;
import entity.uc2Souvenir.EntityPhoto;
import entity.uc4Voyage.EntityVoyage;

public class FactorySouvenirPhotoSansCom extends FactorySouvenirPhoto implements ICreateEntitySouvenirPhoto {

	@Override
	public EntityPhoto createEntityPhoto(Photo photo) {
		System.out.println("*****dao.FactorySouvenirPhotoSansCom-createEntity");
		
		EntityPhoto 	entityPhoto;
		EntityVoyage 	entityVoyage;
		Voyage 			voyage;

		//permet de stocker l'image au format jpeg su aws S3
		sauvegardeImageCloud(photo);
		
		
		//TODO essayer ici de transformer mon voyage en entityVoyage
		//TODO voir pour mettre la methode de recup de voyage entity dans classe mere
		
		voyage = photo.getVoyage();
		entityVoyage = new EntityVoyage(voyage.getId(), null, null, null);
		
		entityPhoto =new EntityPhoto(entityVoyage,photo.getNom());
		
		
		return entityPhoto;
	}


}
