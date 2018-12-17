package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import service.exception.uc1Administrer.ServiceInexistantException;

public class TestServiceCrudRoadBook {

	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static Context 			context;
	private static IServiceFacade 	serviceMpg;


	private static Utilisateur toto;
	private static Utilisateur bibi;

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
	public void avantTest() throws ServiceInexistantException {
		//En relation avec le jeu d'essai pour eviter eventuelle erreur sur serviceUtilisateur
		// jeu d'essai : toto n'a pas de roadBook
		toto = serviceMpg.getUserById(402);
		toto.setId(402);
		// jeu d'essai : bibi a un roabook avec id 413
		bibi = serviceMpg.getUserById(403);
		bibi.setId(403);
	}

	/**
	 * test : creation d'un roadBook 
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void createRoadBook() throws ServiceFacadeExceptionVoyage {
		RoadBook totoRoadBook = new RoadBook(toto);
		RoadBook roadBook = serviceMpg.createRoadBook(totoRoadBook);
		assertEquals(toto.getId(), roadBook.getUtilisateur().getId());
		serviceMpg.deleteRoadBook(roadBook.getId());
	}

	/**
	 *  test : suppression d'un roadBook existant en base
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void readRoadBook() throws ServiceFacadeExceptionVoyage {
		RoadBook roadBook = serviceMpg.getRoadBookByUser(bibi);
		assertEquals(bibi.getId(), roadBook.getUtilisateur().getId());
	}

	/**
	 * test : suppression d'un roadBook existant en base
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void deleteVoyage() throws ServiceFacadeExceptionVoyage {
		RoadBook totoRoadBook = new RoadBook(toto);
		RoadBook roadBook = serviceMpg.createRoadBook(totoRoadBook);
		int idRoadBook = roadBook.getId();
		assertNotNull(serviceMpg.getRoadBookByUser(toto));
		assertEquals(idRoadBook, serviceMpg.getRoadBookByUser(toto).getId());
		serviceMpg.deleteRoadBook(idRoadBook);
		try {
			serviceMpg.getRoadBookByUser(toto);
		} catch (ServiceFacadeExceptionVoyage e) {
			assertEquals(".RoadBook.Dao.Find -> impossible", e.getMessage());
		}
	}

	/**
	 * test : creation d'un roadBook 
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void updateRoadBook() throws ServiceFacadeExceptionVoyage {
		RoadBook totoRoadBook = new RoadBook(toto);
		Voyage voyageFrance = new Voyage("France", LocalDate.now(), 15,null);
		totoRoadBook.addVoyage(voyageFrance);
		RoadBook roadBook = serviceMpg.createRoadBook(totoRoadBook);
		voyageFrance.setNom("Mada");
		roadBook.addVoyage(voyageFrance);
		roadBook = serviceMpg.updateRoadBook(roadBook);
		assertEquals("France", roadBook.getVoyages().get(0).getNom());
		assertEquals("Mada", roadBook.getVoyages().get(1).getNom());
		serviceMpg.deleteRoadBook(roadBook.getId());
	}

}
