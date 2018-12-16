package service.uc2Souvenir;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import business.uc2Souvenir.Souvenir;
import dao.DaoFacade;
import dao.exception.uc2Souvenir.DaoSouvenirException;
import service.exception.uc2Souvenir.ServiceSouvenirErrorMessage;
import service.exception.uc2Souvenir.ServiceSouvenirException;

@Singleton
@LocalBean
public class ServiceSouvenirCreate {
	
	@EJB
	private DaoFacade daoFacade;

	public void createSouvenir(Souvenir souvenir) throws ServiceSouvenirException {
		System.out.println("*****service.ServiceSouvenirCreate-create");
		try {
			daoFacade.createSouvenir(souvenir);
		} catch (DaoSouvenirException e) {
			if(e.getCode() == 203) {
				System.out.println("ServiceSouvenirCreate-Avant de throws");
				throw new ServiceSouvenirException(ServiceSouvenirErrorMessage.ERR_LONGUEUR);
			}
		}
	}


}
