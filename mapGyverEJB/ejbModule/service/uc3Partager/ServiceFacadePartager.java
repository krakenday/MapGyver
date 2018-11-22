package service.uc3Partager;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc3Partager.Description;
import service.exception.ViolationPersistenceException;
import service.uc3Partager.gestion.ServicePartagerGestion;

@Singleton
@LocalBean
public class ServiceFacadePartager {
	
	@EJB
	private ServicePartagerGestion servicePartagerGestion; 
	
	
	/*
	 * Création
	 */
	public void addDescription(Description description) throws ViolationPersistenceException{
		servicePartagerGestion.addDescription(description);
	}
	
	/*
	 * Modification
	 */
	public void updateDescription(Description description) {
		try {
			servicePartagerGestion.updateDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE_PARTAGER >>> updateDescription(Description description) - Erreur");
		}
	}
	
	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id) {
		try {
			servicePartagerGestion.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE_PARTAGER >>> deleteDescription(int id) - Erreur");
		}
	}
	
	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description) {
		try {
			servicePartagerGestion.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("servicePartagerGestion >>> deleteDescription(Description description) - Erreur");
		}
	}

}
