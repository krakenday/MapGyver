package service.uc2Souvenir;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Souvenir;

@Singleton
@LocalBean
public class ServiceFacadeSouvenir {

	@EJB
	private ServiceSouvenirCreate serviceSouvenirCreate;
	
	public void createSouvenir(Souvenir souvenir) {
		serviceSouvenirCreate.create(souvenir);
		
	}

}
