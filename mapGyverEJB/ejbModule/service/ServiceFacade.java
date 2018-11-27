package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import service.exception.uc4Voyage.ServiceVoyageException;
import service.uc4Voyage.ServiceFacadeVoyage;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {

	@EJB
	private ServiceFacadeVoyage serviceFacadeVoyage;
	
	@EJB
	private ServiceFacadeAdmin serviceFacadeAdmin;
	
	@EJB
	private ServiceFacadeUtilisateur serviceFacadeUtilisateur;
	
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
	
	// Bloc Service Utilisateur
	
	@Override
	public void create(Utilisateur utilisateur) {
		serviceFacadeUtilisateur.create(utilisateur);
		
	}

	@Override
	public Utilisateur read(int id) {
		return serviceFacadeUtilisateur.read(id) ;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		serviceFacadeUtilisateur.update(utilisateur);
	}

	@Override
	public void delete(int id) {
		serviceFacadeUtilisateur.delete(id);
	}
	
	// Fabrique Utilisateur
	@Override
	public Utilisateur creerUtilisateur() {
		return serviceFacadeUtilisateur.creerUtilisateur();
	}

	@Override
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return serviceFacadeUtilisateur.creerUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
	
	// Bloc service Groupe
	@Override
	public void createGroupe(Groupe groupe) {
		serviceFacadeUtilisateur.createGroupe(groupe);
	}

	@Override
	public Groupe readGroupe(int id) {
		return serviceFacadeUtilisateur.readGroupe(id);
	}

	@Override
	public void updateGroupe(Groupe groupe) {
		serviceFacadeUtilisateur.updateGroupe(groupe);
	}

	@Override
	public void deleteGroupe(int id) {
		serviceFacadeUtilisateur.deleteGroupe(id);
	}
	
	// Bloc service Liste diffusion
	@Override
	public void createListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.createListeDiff(listeDiff);
	}

	@Override
	public ListeDiffusion readListeDiff(int id) {
		return serviceFacadeUtilisateur.readListeDiff(id);
	}

	@Override
	public void updateListeDiff(ListeDiffusion listeDiff) {
		serviceFacadeUtilisateur.updateListeDiff(listeDiff);
	}

	@Override
	public void deleteListeDiff(int id) {
		serviceFacadeUtilisateur.deleteListeDiff(id);
	}
	
	// Catalogue 
	@Override
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return serviceFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	@Override
	public List<Groupe> listerTousLesGroupes() {
		return serviceFacadeUtilisateur.listerTousLesGroupes();
	}

	@Override
	public List<ListeDiffusion> listerToutesLesListes() {
		return serviceFacadeUtilisateur.listerToutesLesListes();
	}
	
	// Bloc service voyage
	
	@Override
	public void createVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.createVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}
	}

	@Override
	public List<Voyage> readVoyageOrderByID() {
		//return serviceFacadeVoyage.readVoyageOrderByID();	
		return null;
	}

	@Override
	public void updateVoyage(Voyage voyage) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.updateVoyage(voyage);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}	
	}

	@Override
	public void deleteVoyage(int id) throws ServiceFacadeExceptionVoyage {
		try {
			serviceFacadeVoyage.deleteVoyage(id);
		} catch (ServiceVoyageException e) {
			throw new ServiceFacadeExceptionVoyage(e.getCode(),
					e.getMessage());
		}		
	}

	@Override
	public Voyage findVoyagebyID(int id) {
		//		return serviceFacadeVoyage.findVoyagebyID(id);
		return null;
	}

	@Override
	public void createRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.createRoadBook(roadBook);	
	}

	@Override
	public List<RoadBook> readRoadBookOrderByID() {
		//		return serviceFacadeVoyage.readRoadBookOrderByID();
		return null;
	}

	@Override
	public void updateRoadBook(RoadBook roadBook) {
		//		serviceFacadeVoyage.updateRoadBook(roadBook);	
	}

	@Override
	public void deleteRoadBook(int id) {
		//		serviceFacadeVoyage.deleteRoadBook(id);

	}

	@Override
	public RoadBook findRoadBookbyID(int id) {
		//		return serviceVoyage.findRoadBookbyID(id);
		return null;
	}

	@Override
	public void createPOInteret(PointInteret pointInteret) {
		//		serviceVoyage.createPOInteret(pointInteret);		
	}

	@Override
	public List<PointInteret> readPOInteretOrderByID() {
		//		return serviceVoyage.readPOInteretOrderByID();
		return null;
	}

	@Override
	public void updatePOInteret(PointInteret pointInteret) {
		//		serviceVoyage.updatePOInteret(pointInteret);	

	}

	@Override
	public void deletePOInteret(int id) {
		//		serviceVoyage.deletePOInteret(id);
	}

	@Override
	public PointInteret findPOInteretByID(int id) {
		//		return serviceVoyage.findPOInteretByID(id);
		return null;
	}

	// fin bloc service voyage

}
