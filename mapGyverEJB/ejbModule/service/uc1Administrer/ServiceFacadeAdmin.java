package service.uc1Administrer;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Photo;
import business.uc8Utilisateur.Utilisateur;
import dao.DaoFacade;
import service.exception.uc1Administrer.ServiceInexistantException;

@Singleton
@LocalBean
public class ServiceFacadeAdmin {

	@EJB
	private DaoFacade daoFacade;

	public Utilisateur getUserById(int id) throws ServiceInexistantException {
		Utilisateur user = daoFacade.getUserById(id);
		return user;
	}

	public Utilisateur getUserByEmail(String email) throws ServiceInexistantException {

		Utilisateur user = daoFacade.getUserByEmail(email);
		return user;
	}

	public ArrayList<Photo> uc1GetAllPhoto() {
		return daoFacade.uc1GetAllPhoto();
	}

}
