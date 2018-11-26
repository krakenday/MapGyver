package service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc6Jouer.ReponseElire;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;
import service.uc1Administrer.ServiceFacadeAdmin;
import service.uc6Jouer.facade.ServiceFacadeJouer;

@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {

	@EJB
	private ServiceFacadeAdmin serviceFacadeAdmin;

	@Override
	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserById(id);
		return user;
	}

	@Override
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserByEmail(email);
		return user;
	}

	// ********************************************
	// AlexB - UC6 Jouer
	// ********************************************
	@EJB
	private ServiceFacadeJouer serviceFacadeJouer;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ExceptionSurDao
	 */
	@Override
	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao {

		serviceFacadeJouer.createReponseElire(reponseElire);
		System.out.println("tout va bien");
	}
	// ***** Fin AlexB - UC6 Jouer
}
