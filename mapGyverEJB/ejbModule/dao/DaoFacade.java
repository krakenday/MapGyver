package dao;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc6Jouer.ReponseElire;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.exception.uc6Jouer.ConvertionException;
import dao.uc1Administrer.DaoFacadeAdmin;
import dao.uc6Jouer.facade.DaoFacadeJouer;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;

@Singleton
@LocalBean
public class DaoFacade {

	@EJB
	private DaoFacadeAdmin daoFacadeAdmin;

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserById(id);
		} catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}

		return user;
	}

	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserByEmail(email);
		} catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}

		return user;
	}

	/**
	 * UC6 Jouer =>interface entre DaoFacade et DaoFaceJouer
	 */

	@EJB
	private DaoFacadeJouer daoFacadeJouer;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {
		try {
			daoFacadeJouer.createReponseElire(reponseElire);
		} catch (ConvertionException e) {
			throw new ExceptionSurDao(e.getMessage(), e.getCause());
		}
	}
}
