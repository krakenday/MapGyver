package clientServeur;

import java.time.LocalDate;
//import java.util.List;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;

public interface IServiceFacade {
	
	//LA Fabrique d'utilisateur
	public Utilisateur creerUtilisateur();
	
	// le modifier apres l'ajout de la classe ville et pays
	public Utilisateur creerUtilisateur(String nom, String prenom, String adresse, String email, String telephone,
			LocalDate dateInscrip, LocalDate dateNaiss, Password motDePasse);
	
	// Gerer l'utilisateur
	public void create(Utilisateur utilisateur);
	
	public Utilisateur read(int id);
	
	public void update(Utilisateur utilisateur);
	
	public void delete(int id);
	
//	// Catalogue utilisateur
//	public List<Utilisateur> listeTousLesUtilisateurs();
}
