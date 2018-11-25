package service;

import java.time.LocalDate;
//import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.uc8Utilisateur.ServiceFacadeUtilisateur;

@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade{
	
	// Bloc Service Utilisateur
	@EJB
	ServiceFacadeUtilisateur serviceFacadeUtilisateur;
	
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
		// A completer
	}

	@Override
	public Groupe readGroupe(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupe(int id) {
		// TODO Auto-generated method stub
		
	}
	
	// Bloc service Liste diffusion
	@Override
	public void createListeDiff(ListeDiffusion listeDiff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListeDiffusion readListeDiff(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateListeDiff(ListeDiffusion listeDiff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteListeDiff(int id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Utilisateur> listeTousLesUtilisateurs() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
