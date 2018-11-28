package service.uc6Jouer.facade;

import javax.ejb.EJB;

import business.uc6Jouer.ReponseElire;
import dao.DaoFacade;
import service.exception.uc6Jouer.ExceptionSurDao;

/**
 * Facade de Uc6 jouer pour la couche de Dao
 * 
 * {@link service.uc6Jouer.facade.ServiceFacadeJouer#createReponseElire(ReponseElire reponseElire)
 * createReponseElire}
 * 
 * @author lours
 */

public class ServiceFacadeJouer {

	@EJB
	DaoFacade daoFacade;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {
		daoFacade.createReponseElire(reponseElire);
	}
}
