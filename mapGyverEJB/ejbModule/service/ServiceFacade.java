package service;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import service.exception.uc1Administrer.ServiceInexistantException;
import service.uc1Administrer.ServiceFacadeAdmin;

@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade {
	
	@EJB
	private ServiceFacadeAdmin serviceFacadeAdmin;
	
	@Override
	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserById(id);
		return user;
	}

	@Override
	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {
		Utilisateur user = serviceFacadeAdmin.getUserByEmail(email);
		return user;
	}

}
