package service.uc3Partager.gestion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc3Partager.Description;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServicePartagerGestion {
	
	//TODO: Tester sans faire un constructeur par défaut
	
	@EJB
	private DaoFacade daoFacade;
	
	/*
	 * Création
	 */
	public void addDescription(Description description) {
		try {
			daoFacade.addDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_PARTAGER_GESTION >>> addDescription(Description description) - Erreur");
		}
	}

	/*
	 * Modification
	 */
	public void updateDescription(Description description) {
		try {
			daoFacade.updateDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_PARTAGER_GESTION >>> updateDescription(Description description) - Erreur");
		}
	}

	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id) {
		try {
			daoFacade.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("SERVICE_PARTAGER_GESTION >>> deleteDescription(int id) - Erreur");
		}
	}

	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description) {
		try {
			daoFacade.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_PARTAGER_GESTION >>> deleteDescription(Description description) - Erreur");
		}
	}

}
