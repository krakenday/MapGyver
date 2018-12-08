package service.uc2Souvenir;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import business.uc2Souvenir.Souvenir;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceSouvenirCreate {
	
	@EJB
	private DaoFacade daoFacade;

	public void create(Souvenir souvenir) {
		System.out.println("*****service.ServiceSouvenirCreate-create");
		daoFacade.createSouvenir(souvenir);
	}


}
