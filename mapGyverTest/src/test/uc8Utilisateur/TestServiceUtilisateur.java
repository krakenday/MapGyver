package test.uc8Utilisateur;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionUtilisateur;
import service.exception.uc1Administrer.ServiceInexistantException;

public class TestServiceUtilisateur {

	private static final String SERVICE_FACADE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade"; 	
	private static InitialContext context;
	private static IServiceFacade iServiceFacade;
	
	private Password pw;
	private Utilisateur user;
	private Utilisateur user2;
	private String nom;
	public String email;
	public String email2;

	@BeforeClass
	public static void getContext() {
		try {
			context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(SERVICE_FACADE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void preparation() {
		nom = "djallel";
		email= "mon@cdi.fr";
		email2= "ton@cdi.fr";
		pw= new Password("000");
		user= new Utilisateur(nom, "bensehil","12 rue du sucre",email, "0651703754", LocalDate.now(), LocalDate.now(), pw);
		user2= new Utilisateur(nom, "bensehil","12 rue du sucre",email2, "0651703754", LocalDate.now(), LocalDate.now(), pw);
	}
	
	@Test
	public void creerUtilisateur() throws ServiceFacadeExceptionUtilisateur, ServiceInexistantException {
		System.out.println(user.getAdresse());
		assertEquals("djallel", user.getNom());
		iServiceFacade.create(user);
		System.out.println("apres le create user");
		Utilisateur unUser= iServiceFacade.getUserByEmail(email);
		assertNotNull(unUser);
		assertEquals(unUser.getNom(), user.getNom());
		assertEquals(unUser.getEmail(), email);	
		iServiceFacade.delete(unUser.getId());
	}
	
	@Test
	public void readUtilisateur() throws ServiceInexistantException, ServiceFacadeExceptionUtilisateur {
		iServiceFacade.create(user2);
		Utilisateur unUser= iServiceFacade.getUserByEmail(email2);
		System.out.println(unUser.getAdresse());
		Utilisateur utilisateur= iServiceFacade.read(unUser.getId());
		assertNotNull(utilisateur);
		assertEquals(nom, utilisateur.getNom());
		assertEquals(unUser.getEmail(), utilisateur.getEmail());
		
	}
	
}
