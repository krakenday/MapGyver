package service.uc2Souvenir;

/**
 * Classe de controles et de redirection
 * vers toutes les fonctionalites concernant l'UC2 Souvenirs
 */

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Souvenir;
import dao.uc2Souvenir.DaoSouvenirCreatePhoto;

@Singleton
@LocalBean
public class ServiceFacadeSouvenir {

	@EJB
	private DaoSouvenirCreatePhoto daoSouvenirCreate;
	
	public void createSouvenir(Souvenir souvenir) {
		daoSouvenirCreate.createSouvenir(souvenir);
		
	}

}
