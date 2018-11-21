package dao.uc8Utilisateur;

import java.time.LocalDate;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityPassword;
import entity.uc8Utilisateur.EntityUtilisateur;


public class FabriqueEntity {

	public FabriqueEntity() {
		super();
	}
	
	//Fabriquer un Entity Password
	public EntityPassword createEntityPassword(Password password) { 
		String passe= password.getPassword();
		return new EntityPassword(passe);
	}
	
	//Fabriquer un Password
	public Password createPassword(EntityPassword password) { 
		String passe= password.getPassword();
		return new Password(passe);
	}
	
	// Fabriquer une entity utilisateur
	public EntityUtilisateur createEntityUser(Utilisateur utilisateur) {
		
		String nom = utilisateur.getNom();
		String prenom= utilisateur.getPrenom();
		String adresse= utilisateur.getAdresse();
		String email= utilisateur.getEmail();
		String telephone= utilisateur.getTelephone();
		LocalDate dateInscrip= utilisateur.getDateInscrip();
		LocalDate dateNaiss= utilisateur.getDateNaiss();
		Password motDePasse= utilisateur.getMotDePasse();
		
		return new EntityUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, createEntityPassword(motDePasse));
	}
	
	// Fabriquer une utilisateur
	public Utilisateur createUser(EntityUtilisateur utilisateur) {
		
		String nom = utilisateur.getNom();
		String prenom= utilisateur.getPrenom();
		String adresse= utilisateur.getAdresse();
		String email= utilisateur.getEmail();
		String telephone= utilisateur.getTelephone();
		LocalDate dateInscrip= utilisateur.getDateInscrip();
		LocalDate dateNaiss= utilisateur.getDateNaiss();
		EntityPassword motDePasse= utilisateur.getMotDePasse();
		
		return new Utilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, createPassword(motDePasse));
	}
}
