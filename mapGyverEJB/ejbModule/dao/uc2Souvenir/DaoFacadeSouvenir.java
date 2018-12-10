package dao.uc2Souvenir;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import business.uc4Voyage.Voyage;

@Singleton
@LocalBean
public class DaoFacadeSouvenir {
	
	@EJB
	DaoSouvenirCreatePhoto daoSouvenirCreatePhoto;
	
	@EJB
	DaoSouvenirCreateCommentaire daoSouvenirCreateCommentaire;
	
	
	//redirige vers la bonne fabrique selon qu'il faille persister une Photo ou un Commentaire
	public void createSouvenir(Souvenir souvenir) {
		
		System.out.println("*****Je suis au niveau de DaoFacadeSouvenir *****");
		System.out.println("*****affichage de souvenir = *****" + souvenir);
		System.out.println("*****class de souvenir = *****" +souvenir.getClass().getName());
		
		
		
		if(souvenir instanceof Photo) {
			daoSouvenirCreatePhoto.createSouvenir(souvenir);
			System.out.println("*****DaoFacadeSouvenir-createSouvenir: je suis une instance de Photo");
		}
		else if (souvenir instanceof Commentaire) {
			System.out.println("*****DaoFacadeSouvenir-createSouvenir: je suis une instance de Commentaire");
			daoSouvenirCreateCommentaire.createSouvenir(souvenir);
		}
		
	}

	

}
