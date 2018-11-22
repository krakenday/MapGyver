package clientServeur;

import java.util.List;

import business.uc4Voyage.Document;
import business.uc8Utilisateur.Utilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;

public interface IServiceFacade {

	// ********************************************
	//  DM - UC1 Administrer
	// ********************************************

	/**
	 * Retourne un Utilisateur a partir de son id
	 * @throws ServiceInexistantException 
	 */
	public Utilisateur getUserById(int id) 			throws ServiceInexistantException;
	/**
	 * Retourne un Utilisateur a partir de son email
	 * @throws ServiceInexistantException 
	 */
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException;
	
	// *****  Fin DM - UC1 Administrer

	public void create(Document document);
	public List<Document> readbyName();
	public void update(Document document);
	public void delete(int ref);
	public List<Document> readbyRef();
	public void deleteAll();
	public Document findbyRef(int ref);

}
