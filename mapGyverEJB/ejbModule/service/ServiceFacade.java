package service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.uc1Administrer.ServiceFacadeAdmin;
import service.uc8Utilisateur.ServiceFacadeUtilisateur;

@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {
	
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

}
