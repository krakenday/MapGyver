package service.uc6Jouer.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc6Jouer.Jeu;
import business.uc6Jouer.Jeux;
import business.uc6Jouer.ReponseElire;
import dao.DaoFacade;
import dao.DaoParam;
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

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {

		daoFacade.createReponseElire(reponseElire);
	}

	public Jeu getJeuById(int idJeu) throws ExceptionSurDao {
		return daoFacade.getJeuById(idJeu);
	}

	public Jeux listJeu() throws ExceptionSurDao {
		return daoFacade.listJeu();
	}

	public void removeJeu(Jeu jeu) throws ExceptionSurDao {
		daoFacade.removeJeu(jeu);
	}
}
