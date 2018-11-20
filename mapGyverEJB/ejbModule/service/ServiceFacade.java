package service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc3Partager.Description;
import client.serveur.partager.IGestion;
import service.uc3Partager.ServiceFacadePartager;

@Stateless
@Remote(IGestion.class)
public class ServiceFacade implements IGestion{
	
	
	/*
	 * UC3_Partager 
	 */
	@EJB
	private ServiceFacadePartager serviceFacadePartager;
	
	
	/*
	 * Création
	 */
	@Override
	public void addDescription(Description description) {
		try {
			serviceFacadePartager.addDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE >>> addDescription(Description description) - Erreur");
		}
	}

	/*
	 * Modification
	 */
	@Override
	public void updateDescription(Description description) {
		try {
			serviceFacadePartager.updateDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE >>> updateDescription(Description description) - Erreur");
		}
	}

	/*
	 * Suppression par Id
	 */
	@Override
	public void deleteDescription(int id) {
		try {
			serviceFacadePartager.deleteDescription(id);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE >>> deleteDescription(int id) - Erreur");
		}
	}

	/*
	 * Suppression description
	 */
	@Override
	public void deleteDescription(Description description) {
		try {
			serviceFacadePartager.deleteDescription(description);
		} catch (Exception e) {
			System.out.println("SERVICE_FACADE >>> deleteDescription(Description description) - Erreur");
		}
	}

}
