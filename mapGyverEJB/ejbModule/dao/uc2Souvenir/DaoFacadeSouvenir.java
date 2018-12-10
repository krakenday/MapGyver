package dao.uc2Souvenir;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;

@Singleton
@LocalBean
public class DaoFacadeSouvenir {
	
	@EJB
	DaoSouvenirCreatePhoto daoSouvenirCreatePhoto;
	
	@EJB
	DaoSouvenirCreateCommentaire daoSouvenirCreateCommentaire;
	
	
	//redirige vers la bonne fabrique selon qu'il faille persister une Photo ou un Commentaire
	public void createSouvenir(Souvenir souvenir) {
		
		if(souvenir instanceof Photo) {
			daoSouvenirCreatePhoto.createSouvenir(souvenir);
		}
		else if (souvenir instanceof Commentaire) {
			daoSouvenirCreateCommentaire.createSouvenir(souvenir);
		}
		
	}

	

}
