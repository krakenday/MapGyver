package service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

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

//	@Override
//	public List<Utilisateur> listeTousLesUtilisateurs() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
