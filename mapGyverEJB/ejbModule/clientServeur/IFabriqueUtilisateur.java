package clientServeur;

import java.time.LocalDate;

import business.uc8Utilisateur.Utilisateur;
import business.uc8Utilisateur.Password;

/**
 * Fabrique un utilisateur
 *
 */
public interface IFabriqueUtilisateur {
	
	public Utilisateur creerUtilisateur();
	
	// le modifier apres l'ajout de la classe ville et pays
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse);
	
}
