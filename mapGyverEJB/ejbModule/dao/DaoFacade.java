package dao;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc3Partager.Description;
import dao.uc3Partager.DaoFacadePartager;

@Singleton
@LocalBean
public class DaoFacade {
	
	
	@EJB
	private DaoFacadePartager daoFacadePartager;

	/*
	 * Création
	 */
	public void addDescription(Description description) {
		try {
			daoFacadePartager.addDescription(description);
		} catch (Exception e) {
			System.out.println("DAO_FACADE >>> addDescription(Description description) - Erreur");
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

}
