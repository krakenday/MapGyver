package dao.uc8Utilisateur;

import javax.ejb.EJB;

//import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dao.uc8Utilisateur.gestion.DaoGestion;

@Singleton
@LocalBean
public class Facade {

	@EJB
	DaoGestion daoGestion;
	
	//Gestion de l'utilisateur
	public void addUtilisateur() {
		
	}
	
	public void updateUtilisateur() {
		
	}
	
//	public IUtilisateur readUtilisateur() {
//		
//	}
	
	public void deleteUtilisateur() {
		
	}
	
//	public List<> listeUtilisateursById() {
//		
//	}
	
//	public List<> listeUtilisateursByNom() {
//	
//}
}
