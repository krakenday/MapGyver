package service.uc6Jouer.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

//		ElirePhotoEntity jeu = em.find(ElirePhotoEntity.class, 610);
//		EntityPhoto photo = em.find(EntityPhoto.class, 612);
//		EntityUtilisateur utilisateur = em.find(EntityUtilisateur.class, 601);
		daoFacade.createReponseElire(reponseElire);
	}
}
