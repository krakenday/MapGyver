package dao.uc2Souvenir;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import business.uc4Voyage.Voyage;
import dao.exception.uc2Souvenir.DaoSouvenirException;

@Singleton
@LocalBean
public class DaoFacadeSouvenir {
	
	@EJB
	DaoSouvenirCreatePhoto daoSouvenirCreatePhoto;
	
	@EJB
	DaoSouvenirCreateCommentaire daoSouvenirCreateCommentaire;
	
	@EJB
	DaoSouvenirGetSouvenirsVoyage daoSouvenirGetSouvenirsVoyage;
	
	@EJB
	DaoSouvenirSupprimerSouvenir daoSouvenirSupprimerSouvenir;
	
	
	//redirige vers la bonne fabrique selon qu'il faille persister une Photo ou un Commentaire
	public void createSouvenir(Souvenir souvenir) throws DaoSouvenirException {
		
		System.out.println("*****Je suis au niveau de DaoFacadeSouvenir *****");
		System.out.println("*****affichage de souvenir = *****" + souvenir);
		System.out.println("*****class de souvenir = *****" +souvenir.getClass().getName());
		
		
		
		if(souvenir instanceof Photo) {
			System.out.println("*****DaoFacadeSouvenir-createSouvenir: je suis une instance de Photo");
			daoSouvenirCreatePhoto.createSouvenir(souvenir);
			
		}
		else if (souvenir instanceof Commentaire) {
			System.out.println("*****DaoFacadeSouvenir-createSouvenir: je suis une instance de Commentaire");
			daoSouvenirCreateCommentaire.createSouvenir(souvenir);
		}
		
	}


	public List<Souvenir> getSouvenirsByIdVoyage(String idVoyage) {
		System.out.println("*****DaoFacadeSouvenir-getSouvenirsByIdVoyage");
		return daoSouvenirGetSouvenirsVoyage.getSouvenirsByIdVoyage(idVoyage);
	}


	public void supprimeSouvenirById(int idSouvenir) {
		System.out.println("*****DaoFacadeSouvenir-supprimeSouvenirById");
		daoSouvenirSupprimerSouvenir.supprimeSouvenirById(idSouvenir);
		
	}

	

}
