package test.uc8Utilisateur;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionUtilisateur;

class TestServiceUtilisateur {

	private static final String LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static InitialContext context;
	private static IServiceFacade iServiceFacade;
	
	private Password pw;
	private Utilisateur user;
	
	@BeforeClass
	public void getContext() {
		try {
			context = new InitialContext();
			iServiceFacade = (IServiceFacade) context.lookup(LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void preparation() {
		pw= new Password("000");
		user= new Utilisateur("djallel", "bensehil","12 rue du sucre", "mon@cdi.fr", "0651703754", LocalDate.now(), LocalDate.now(), pw);

	}
	
	@Test
	public void creerUtilisateur() throws ServiceFacadeExceptionUtilisateur {
		iServiceFacade.create(user);
		
		
	}
	
}
