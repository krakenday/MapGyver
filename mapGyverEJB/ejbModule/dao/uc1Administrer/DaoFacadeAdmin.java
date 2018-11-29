package dao.uc1Administrer;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoFacadeAdmin {

	@EJB
	private DaoAdmin daoAdmin;

// DB modification du code pour le getbyId et getUserByEmail
	public Utilisateur getUserById(int id) throws DaoInexistantException {

		Utilisateur user = null;

		EntityUtilisateur entityUser = daoAdmin.getUserById(id);
		if (entityUser != null) {
			user = new Utilisateur(	entityUser.getId(), 
					entityUser.getNom(), 
					entityUser.getPrenom(),
					entityUser.getAdresse(),
					entityUser.getEmail(),
					entityUser.getTelephone(),
					entityUser.getDateInscrip(),
					entityUser.getDateNaiss()
					);
		}
		return user;
	}

	public Utilisateur getUserByEmail(String email) throws DaoInexistantException {

		Utilisateur user = null;

		EntityUtilisateur entityUser = daoAdmin.getUserByEmail(email);
		if (entityUser != null) {
			user = new Utilisateur(	entityUser.getId(), 
					entityUser.getNom(), 
					entityUser.getPrenom(),
					entityUser.getAdresse(),
					entityUser.getEmail(),
					entityUser.getTelephone(),
					entityUser.getDateInscrip(),
					entityUser.getDateNaiss()
					);
		}
		return user;
	}

}
