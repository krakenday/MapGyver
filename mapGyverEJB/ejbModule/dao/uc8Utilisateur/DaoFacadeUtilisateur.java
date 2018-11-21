package dao.uc8Utilisateur;

import javax.ejb.EJB;

//import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.uc8Utilisateur.gestion.DaoUtilisateurGestion;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoFacadeUtilisateur {

	@EJB
	DaoUtilisateurGestion daoGestion;
	
	FabriqueEntity fabriqueEntity= new FabriqueEntity();
	
	//Gestion de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) {
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		daoGestion.addUtilisateur(entityUtilisateur);
	}
	
	public Utilisateur readUtilisateur(int id) {
		EntityUtilisateur entityUtilisateur= daoGestion.readUtilisateur(id);
		Utilisateur utilisateur= fabriqueEntity.createUser(entityUtilisateur);
		return utilisateur;
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		EntityUtilisateur entityUtilisateur= fabriqueEntity.createEntityUser(utilisateur);
		daoGestion.updateUtilisateur(entityUtilisateur);
	}
	
	public void deleteUtilisateur(int id) {
		daoGestion.deleteUtilisateur(id);
	}
	
//	public List<Utilisateur> listeUtilisateursById() {
//		
//	}
	
//	public List<Utilisateur> listeUtilisateursByNom() {
//	
//}
}
