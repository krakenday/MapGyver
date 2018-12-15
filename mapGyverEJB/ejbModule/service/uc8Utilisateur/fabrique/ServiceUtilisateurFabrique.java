package service.uc8Utilisateur.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;


@Singleton
@LocalBean
public class ServiceUtilisateurFabrique   {

	/**
	 * 
	 * Fabriquer un utilisateur
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param telephone
	 * @param dateInscrip
	 * @param dateNaiss 
	 * @param motDePasse 
	 * @return Utilisateur
	 */
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse) {
		return new Utilisateur (nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
	
	/**
	 * 
	 * Fabriquer un groupe 
	 * @param nom
	 * @param utilisateur
	 * @return Groupe
	 */
	public Groupe creerGroupe(String nom, Utilisateur utilisateur) {
		return new Groupe(nom, utilisateur);
	}
}
