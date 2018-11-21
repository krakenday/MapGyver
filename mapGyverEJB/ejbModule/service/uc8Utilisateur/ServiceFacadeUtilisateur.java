package service.uc8Utilisateur;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import service.uc8Utilisateur.fabrique.ServiceUtilisateurFabrique;
import service.uc8Utilisateur.gestion.ServiceUtilisateurGestion;

@Singleton
@LocalBean
public class ServiceFacadeUtilisateur {
	
	@EJB
	ServiceUtilisateurGestion serviceUtilisateurGestion;
	
	@EJB
	ServiceUtilisateurFabrique serviceUtilisateurFabrique;
	
	
	public void create(Utilisateur utilisateur) {
		serviceUtilisateurGestion.create(utilisateur);
	}
	
	public Utilisateur read(int id) {
		return serviceUtilisateurGestion.read(id);
	}
	
	public void update(Utilisateur utilisateur) {
		serviceUtilisateurGestion.update(utilisateur);
	}

	public void delete(int id) {
		serviceUtilisateurGestion.delete(id);
	}
	// Fabrique Utilisateur
	public Utilisateur creerUtilisateur() {
		return serviceUtilisateurFabrique.creerUtilisateur();
	}

	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return serviceUtilisateurFabrique.creerUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
}
