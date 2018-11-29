package clientServeur;

import business.uc6Jouer.ReponseElire;
import business.uc8Utilisateur.Utilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.exception.uc6Jouer.ExceptionSurDao;

public interface IServiceFacade {

	// ********************************************
	// DM - UC1 Administrer
	// ********************************************

	/**
	 * Retourne un Utilisateur a partir de son id
	 * 
	 * @throws ServiceInexistantException
	 */
	public Utilisateur getUserById(int id) throws ServiceInexistantException;

	/**
	 * Retourne un Utilisateur a partir de son email
	 * 
	 * @throws ServiceInexistantException
	 */
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException;

	// ***** Fin DM - UC1 Administrer

	// ********************************************
	// AlexB - UC6 Jouer
	// ********************************************

	public void createReponseElire(ReponseElire reponseElire) throws ExceptionSurDao;

	// ***** Fin AlexB - UC6 Jouer
}
