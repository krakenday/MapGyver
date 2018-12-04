package service.uc6Jouer.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

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

//DM il manque les annotations localbean ...
@LocalBean
@Singleton
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
		System.out.println("je suis dans la ServiceFacadeJouer");
		daoFacade.createReponseElire(reponseElire);
	}
}
