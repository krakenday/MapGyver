package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.exception.uc4Voyage.DaoFacadeExceptionVoyage;
import dao.exception.uc4Voyage.DaoVoyageException;
import dao.uc4Voyage.DaoFacadeVoyage;
import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.uc1Administrer.DaoFacadeAdmin;
import service.exception.uc1Administrer.ServiceInexistantException;


@Singleton
@LocalBean
public class DaoFacade {

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";
	
	@EJB
	private DaoFacadeAdmin daoFacadeAdmin;
	
	@EJB
	private DaoFacadeUtilisateur daoFacadeUtilisateur;
		
	@EJB
	private DaoFacadeVoyage daoFacadeVoyage;

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserById(id);
		}
		catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		
		return user;
	}

	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserByEmail(email);
		}
		catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		
		return user;
	}
	
	//Ici commence le territoire de Djallel
		// Gestion de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) {
			daoFacadeUtilisateur.addUtilisateur(utilisateur);		
	}
	
	public Utilisateur readUtilisateur(int id) {
		return daoFacadeUtilisateur.readUtilisateur(id);
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		daoFacadeUtilisateur.updateUtilisateur(utilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		daoFacadeUtilisateur.deleteUtilisateur(id);
	}
	
	//Gestion du groupe
	public void addGroupe(Groupe groupe) {
		daoFacadeUtilisateur.addGroupe(groupe);
	}
	public Groupe readGroupe(int id) {
		return daoFacadeUtilisateur.readGroupe(id);
	}
	
	public void updateGroupe(Groupe groupe) {
		daoFacadeUtilisateur.updateGroupe(groupe);
	}
	
	public void deleteGroupe(int id) {
		daoFacadeUtilisateur.deleteGroupe(id);
	}
	
	//Gestion de liste de diffusion
	public void addListeDiff(ListeDiffusion listeDiff) {
		daoFacadeUtilisateur.addListeDiff(listeDiff);
	}
	public ListeDiffusion readListeDiff(int id) {
		return daoFacadeUtilisateur.readListeDiff(id);
	}
	
	public void updateListeDiff(ListeDiffusion listeDiff) {
		daoFacadeUtilisateur.updateListeDiff(listeDiff);
	}
	
	public void deleteListeDiff(int id) {
		daoFacadeUtilisateur.deleteListeDiff(id);
	}
	
	//Catalogue
	public List<Utilisateur> listerTousLesUtilisateurs() {
		return daoFacadeUtilisateur.listerTousLesUtilisateurs();
	}

	public List<Groupe> listerTousLesGroupes() {
		return daoFacadeUtilisateur.listerTousLesGroupes();
	}

	public List<ListeDiffusion> listerToutesLesListes() {
		return daoFacadeUtilisateur.listerToutesLesListes();
	}
	//Merci de votre visite
	
	//***************** Voyage
	public void createVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.createVoyage(voyage);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public List<Voyage> readVoyageOrderByID() {
		return daoFacadeVoyage.readVoyageOrderByID();
	}

	public void updateVoyage(Voyage voyage) throws DaoFacadeExceptionVoyage {
		try {
		daoFacadeVoyage.updateVoyage(voyage);	
	} catch (DaoVoyageException e) {
		throw new DaoFacadeExceptionVoyage(e.getCode(),
				ZONE_EXCEPTION_MSG+ e.getMessage());
	}
	}
	
	public void deleteVoyage(int id) throws DaoFacadeExceptionVoyage {
		try {
			daoFacadeVoyage.deleteVoyage(id);
		} catch (DaoVoyageException e) {
			throw new DaoFacadeExceptionVoyage(e.getCode(),
					ZONE_EXCEPTION_MSG+ e.getMessage());
		}
	}

	public Voyage findVoyagebyID(int id) {
		return daoFacadeVoyage.findVoyagebyID(id);
	}

	public void createRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.createRoadBook(roadBook);	
	}

	public List<RoadBook> readRoadBookOrderByID() {
		return daoFacadeVoyage.readRoadBookOrderByID();	
	}

	public void updateRoadBook(RoadBook roadBook) {
		daoFacadeVoyage.updateRoadBook(roadBook);	
	}

	public void deleteRoadBook(int id) {
		daoFacadeVoyage.deleteRoadBook(id);	
	}

	public RoadBook findRoadBookbyID(int id) {
		return daoFacadeVoyage.findRoadBookbyID(id);
	}

	public void createPOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.createPOInteret(pointInteret);
		
	}

	public List<PointInteret> readPOInteretOrderByID() {
		return daoFacadeVoyage.readPOInteretOrderByID();
	}

	public void updatePOInteret(PointInteret pointInteret) {
		daoFacadeVoyage.updatePOInteret(pointInteret);
	}

	public void deletePOInteret(int id) {
		daoFacadeVoyage.deletePOInteret(id);		
	}

	public PointInteret findPOInteretByID(int id) {
		return daoFacadeVoyage.findPOInteretByID(id);	
	}
	//fin ***************** Voyage
	
	
}
