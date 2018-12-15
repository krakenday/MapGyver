package service.uc2Souvenir;

import java.util.List;

/**
 * Classe de controles et de redirection
 * vers toutes les fonctionalites concernant l'UC2 Souvenirs
 */

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Souvenir;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceFacadeSouvenir {

	@EJB
	private DaoFacade daoFacade;
	
	public void createSouvenir(Souvenir souvenir) {
		System.out.println("*****Dans Service Facade Souvenir*****");
		daoFacade.createSouvenir(souvenir);
		
	}

	public List<Souvenir> getSouvenirsByIdVoyage(String idVoyage) {
		System.out.println("*****Dans Service Facade Souvenir- getSouvenirByIdVoyage*****");
		return daoFacade.getSouvenirsByIdVoyage(idVoyage);
	}

	public void supprimeSouvenirById(int idSouvenir) {
		daoFacade.supprimeSouvenirById(idSouvenir);
		
	}

}
