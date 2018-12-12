package dao.uc2Souvenir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;

@Singleton
@LocalBean
public class DaoSouvenirGetSouvenirsVoyage {

	public List<Souvenir> getSouvenirsByIdVoyage(String idVoyage) {
		
		System.out.println("je suis dans DaoSouvenirGetSouvenirsVoyage-getSouvenirsByIdVoyage");
		Photo photo;
		 photo = new Photo("succes :D");
		
		 List<Souvenir> catalogueSouv = new ArrayList<Souvenir>();
		 
		 catalogueSouv.add(photo);
		
		return catalogueSouv;
	}

}
