package dao.uc8Utilisateur.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Groupe;
import business.uc8Utilisateur.ListeDiffusion;
import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityGroupe;
import entity.uc8Utilisateur.EntityListeDiffusion;
import entity.uc8Utilisateur.EntityPassword;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
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
		EntityPassword motDePasse= createEntityPassword(utilisateur.getMotDePasse());
		
		return new EntityUtilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss,motDePasse );
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
		Password motDePasse= createPassword(utilisateur.getMotDePasse());
		
		return new Utilisateur(nom, prenom, adresse, email, telephone, dateInscrip, dateNaiss, motDePasse);
	}
	
	// Fabriquer un groupe
	public Groupe createGroupe(EntityGroupe groupe, EntityUtilisateur entityUntilisateur) {
		Utilisateur utilisateur= createUser(entityUntilisateur);
		String nom= groupe.getNom();
		return new Groupe(nom, utilisateur);
	}
	
	// Fabriquer une entity groupe
	public EntityGroupe createEntityGroupe(Groupe groupe) {
		EntityUtilisateur entityUtilisateur= createEntityUser(groupe.getUtilisateur());
//		String nom= groupe.getNom();
		return new EntityGroupe(groupe.getNom(), entityUtilisateur);
	}
	
	// Fabriquer une liste de diffusion
	public ListeDiffusion creeListeDiff(EntityListeDiffusion listeDiff) {
		String nom= listeDiff.getNom();
		return new ListeDiffusion(nom);
	}
	
	// Fabriquer une entity liste diffusion
	public EntityListeDiffusion creeEntityListeDiff(ListeDiffusion listeDiff) {
		String nom= listeDiff.getNom();
		return new EntityListeDiffusion(nom);
	}
}
