package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;

public class TestServiceCrudVoyage {

	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static Context 			context;
	private static IServiceFacade 	serviceMpg;

	private Voyage voyageLondres;
	private Voyage voyageBrasil;

	@BeforeClass
	public static void initConnexion() {
		try {
			context = new InitialContext();
			serviceMpg = (IServiceFacade) context.lookup(VOYAGE_SERVICE_LOOKUP);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void avantTest() {
		voyageLondres = new Voyage("Londres", LocalDate.now(), 15,null); 
		voyageBrasil = new Voyage("Brasil", LocalDate.now(), 15,null);
	}


	/**
	 * test : creation d'un voyage 
	 * @throws ServiceFacadeExceptionVoyage
	 */

	@Test
	public void createVoyage() throws ServiceFacadeExceptionVoyage {
		Voyage voyage = serviceMpg.createVoyage(voyageLondres);
		assertEquals(voyage.getNom(), voyageLondres.getNom());
		assertEquals(voyage.getNbParticipant(), voyageLondres.getNbParticipant());
		assertEquals(voyage.getDateDebut(), voyageLondres.getDateDebut());
		assertEquals(voyage.getPointInteret(), voyageLondres.getPointInteret());
		serviceMpg.deleteVoyage(voyage.getId());
	}

	/**
	 * test : recuperation d'un voyage selon son ID
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void readVoyage() throws ServiceFacadeExceptionVoyage {
		// voyage du jeu d'essai
		Voyage voyage = serviceMpg.createVoyage(voyageLondres);
		Voyage testVoyage = serviceMpg.getVoyageById(voyage.getId());
		assertEquals(voyageLondres.getNom(), testVoyage.getNom());
		assertEquals(voyageLondres.getNbParticipant(), testVoyage.getNbParticipant());
		assertEquals(voyageLondres.getDateDebut(), testVoyage.getDateDebut());
		assertEquals(voyageLondres.getPointInteret(), testVoyage.getPointInteret());
		serviceMpg.deleteVoyage(voyage.getId());
	}
	
	/**
	 * test : suppression d'un voyage existant en base
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void deleteVoyage() throws ServiceFacadeExceptionVoyage {
		Voyage voyage = serviceMpg.createVoyage(voyageBrasil);
		int idVoyage = voyage.getId();
		assertNotNull(serviceMpg.getVoyageById(idVoyage));
		serviceMpg.deleteVoyage(idVoyage);
		try {
			serviceMpg.getVoyageById(idVoyage);
		} catch (ServiceFacadeExceptionVoyage e) {
			assertEquals(".Voyage.Dao.Find -> inexistant", e.getMessage());
		}
	}

}
