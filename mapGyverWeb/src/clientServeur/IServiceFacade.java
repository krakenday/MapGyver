package clientServeur;

<<<<<<< HEAD
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

=======
import java.time.LocalDate;
import java.util.List;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;

public interface IServiceFacade {
	
	//LA Fabrique d'utilisateur
	public Utilisateur creerUtilisateur();
	
	// le modifier apres l'ajout de la classe ville et pays
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse);
	
	// Gerer l'utilisateur
	public void create(Utilisateur utilisateur);
	
	public Utilisateur read(int id);
	
	public void update(Utilisateur utilisateur);
	
	public void delete(int id);
	
	// Catalogue utilisateur
	public List<Utilisateur> listerTousLesUtilisateurs();
	
	// Gerer un groupe
	public void createGroupe(Groupe groupe);
	
	public Groupe readGroupe(int id);
	
	public void updateGroupe (Groupe groupe);
	
	public void deleteGroupe(int id);
	
	// Catalogue groupe
	public List<Groupe> listerTousLesGroupes();
	
	// Gerer une Liste Diffusion
	public void createListeDiff(ListeDiffusion listeDiff);
	
	public ListeDiffusion readListeDiff(int id);
	
	public void updateListeDiff (ListeDiffusion listeDiff);
	
	public void deleteListeDiff(int id);
	
	// Catalogue Liste diffusion
	public List<ListeDiffusion> listerToutesLesListes();
>>>>>>> featuc8
}
