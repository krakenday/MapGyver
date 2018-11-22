package clientServeur;


import business.uc8Utilisateur.Utilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;

public interface IServiceFacade {

	// ********************************************
	//  DM - UC1 Administrer
	// ********************************************

	/**
	 * Retourne un Utilisateur par id
	 * @throws ServiceInexistantException 
	 */
	public Utilisateur getUserById(int id) throws ServiceInexistantException;
	
	// *****  Fin DM - UC1 Administrer
	
}
