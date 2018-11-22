package dao;

<<<<<<< HEAD
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.PersistenceException;

import business.uc3Partager.Description;
import dao.exception.ViolationPersistenceException;
import dao.uc3Partager.DaoFacadePartager;

=======

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc8Utilisateur.Utilisateur;
import dao.exception.uc1Administrer.DaoInexistantException;
import dao.uc1Administrer.DaoFacadeAdmin;
import service.exception.uc1Administrer.ServiceInexistantException;
>>>>>>> dev

@Singleton
@LocalBean
public class DaoFacade {
	
	@EJB
<<<<<<< HEAD
	private DaoFacadePartager daoFacadePartager;

	/*
	 * Création
	 */
	public void addDescription(Description description) throws service.exception.ViolationPersistenceException {
		try {
			daoFacadePartager.addDescription(description);
		} catch (ViolationPersistenceException e) {
			System.out.println("DAO_FACADE >>> addDescription(Description description) - Erreur");
			throw new service.exception.ViolationPersistenceException();
		}
	}

	/*
	 * Modification
	 */
	public void updateDescription(Description description) {
		try {
			daoFacadePartager.updateDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> updateDescription(Description description) - Erreur");
		}
	}

	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id) {
		try {
			daoFacadePartager.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> deleteDescription(int id) - Erreur");
		}
	}

	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description) {
		try {
			daoFacadePartager.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> deleteDescription(Description description) - Erreur");
		}
	}

=======
	private DaoFacadeAdmin daoFacadeAdmin;

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = null;
		try {
			user = daoFacadeAdmin.getUserById(id);
		}
		catch (DaoInexistantException e) {
			throw new ServiceInexistantException();
		}
		
		return user;
	}
>>>>>>> dev
}
