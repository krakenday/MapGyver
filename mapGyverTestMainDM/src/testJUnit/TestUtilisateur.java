package testJUnit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import ressources.Param;
import service.exception.uc1Administrer.ServiceInexistantException;

/**
 * Att : 
 * 1 - il faut vider les tables avant de lancer le tests
 * 2 - J'ai creer un service uc1CreerUserPourTest(Utilisateur user)
 * car j'ai besoin de l'id du user cree. 
 * Il est genere avec une sequence et la creation codee dans uc8 
 * ne fait pas remonter l'id
 * Cette methode positionne en dur le pw, l'adresse ...
 * 
 * @author Moi
 *
 */
public class TestUtilisateur {

	private static Context context;
	private static IServiceFacade serviceFacade;


	@BeforeClass
	public static void avantTout() {

		try {
			context = new InitialContext();
			serviceFacade = (IServiceFacade) context.lookup(Param.EJB_SERVICE_FACADE);
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	// getUserById - cas nominal
	@Test
	public void r1getUserById() throws ServiceInexistantException {

		Utilisateur user = new Utilisateur("Muller", "Domi", "m.d1@afpa.fr");
		Utilisateur user2 = null;

		user  = serviceFacade.uc1CreerUserPourTest(user);
		user2 = serviceFacade.getUserById(user.getId());
		assertEquals("getUserById : ",user.getId(),  user2.getId());	
		assertEquals("getUserById : ","Muller",   	 user2.getNom());
		assertEquals("getUserById : ","Domi",   	 user2.getPrenom());
		assertEquals("getUserById : ","m.d1@afpa.fr",user2.getEmail());

	}

	// getUserById - inexistant
	@Test(expected = ServiceInexistantException.class)
	public void r2getUserByIdInexistant() throws ServiceInexistantException {
		serviceFacade.getUserById(199);
	}

	// getUserByEmail - cas nominal
	@Test
	public void r1getUserByEmail() throws ServiceInexistantException {

		Utilisateur user = new Utilisateur("Muller", "Domi", "m.d2@afpa.fr");

		Utilisateur user2 = null;

		user  = serviceFacade.uc1CreerUserPourTest(user);
		user2 = serviceFacade.getUserByEmail("m.d2@afpa.fr");
		assertEquals("getUserById : ",user.getId(),  user2.getId());	
		assertEquals("getUserById : ","Muller",   	 user2.getNom());
		assertEquals("getUserById : ","Domi",   	 user2.getPrenom());
		assertEquals("getUserById : ","m.d2@afpa.fr",user2.getEmail());

	}

	// getUserByEmail - inexistant
	@Test(expected = ServiceInexistantException.class)
	public void r2getUserByEmailInexistant() throws ServiceInexistantException {
		serviceFacade.getUserByEmail("toto@titi.fr");
	}
}
