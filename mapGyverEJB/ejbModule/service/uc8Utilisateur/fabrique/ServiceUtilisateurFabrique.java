package service.uc8Utilisateur.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;


@Singleton
@LocalBean
public class ServiceUtilisateurFabrique   {

	
	public Utilisateur creerUtilisateur() {
		return new Utilisateur();
	}

	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return new Utilisateur (nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
	
}
