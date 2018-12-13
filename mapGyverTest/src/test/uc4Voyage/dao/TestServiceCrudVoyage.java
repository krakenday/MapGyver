package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc4Voyage.Coordonnee;
import business.uc4Voyage.Lieu;
import business.uc4Voyage.Pays;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.Ville;
import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import entity.uc4Voyage.EntityCoordonnee;
import entity.uc4Voyage.EntityLieu;
import entity.uc4Voyage.EntityPays;
import entity.uc4Voyage.EntityPointInteret;
import entity.uc4Voyage.EntityVille;
import entity.uc4Voyage.EntityVoyage;

public class TestServiceCrudVoyage {

	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static Context 			context;
	private static IServiceFacade 	serviceMpg;

	private Voyage voyageFrance;
	private EntityVoyage entityVoyageEspagne;

	private Coordonnee coordonnee;
	private Pays pays;
	private Ville ville;
	private Lieu lieu;
	private ArrayList<PointInteret> listPOI = new ArrayList<>();

	private EntityCoordonnee entityCoordonne;
	private EntityPays entityPays;
	private EntityVille entityVille;
	private EntityLieu entityLieu;
	private ArrayList<EntityPointInteret> listEntityPOI = new ArrayList<>();

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

		coordonnee = new Coordonnee(-50, -60);
		pays = new Pays("France", coordonnee);
		ville = new Ville("Marseille", coordonnee);
		lieu = new Lieu("Velodrome", coordonnee);
		listPOI.add(pays);
		listPOI.add(pays);
//		listPOI.add(ville);
//		listPOI.add(lieu);

		entityCoordonne = new EntityCoordonnee(50, 60);
		entityPays = new EntityPays("Espagne", entityCoordonne);
		entityVille = new EntityVille("Barcelone", entityCoordonne);
		entityLieu = new EntityLieu("Camp Nou", entityCoordonne);
		listEntityPOI.add(entityPays);
		//		listEntityPOI.add(entityVille);
		//		listEntityPOI.add(entityLieu);

		voyageFrance = new Voyage("France", LocalDate.now(), 15,listPOI); 
		entityVoyageEspagne = new EntityVoyage("Espagne", LocalDate.now(), 15,listEntityPOI);

	}


	/**
	 * test : creation d'un voyage 
	 * @throws ServiceFacadeExceptionVoyage
	 */

	@Test
	public void createVoyage() throws ServiceFacadeExceptionVoyage {
		Voyage voyage = serviceMpg.createVoyage(voyageFrance);
		assertEquals(voyage.getNom(), voyageFrance.getNom());
		assertEquals(voyage.getNbParticipant(), voyageFrance.getNbParticipant());
		assertEquals(voyage.getDateDebut(), voyageFrance.getDateDebut());
		for (int i=0; i<voyage.getPointInteret().size();i++) {
			assertEquals(voyage.getPointInteret().get(i).getNom(), voyageFrance.getPointInteret().get(i).getNom());
		}
		serviceMpg.deleteVoyage(voyage.getId());
	}

	/**
	 * test : recuperation d'un voyage selon son ID
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void readVoyage() throws ServiceFacadeExceptionVoyage {
		// voyage du jeu d'essai
		Voyage voyage = serviceMpg.createVoyage(voyageFrance);
		Voyage testVoyage = serviceMpg.getVoyageById(voyage.getId());
		assertEquals(voyageFrance.getNom(), testVoyage.getNom());
		assertEquals(voyageFrance.getNbParticipant(), testVoyage.getNbParticipant());
		assertEquals(voyageFrance.getDateDebut(), testVoyage.getDateDebut());
		for (int i=0; i<voyage.getPointInteret().size();i++) {
			assertEquals(voyageFrance.getPointInteret().get(i).getNom(), voyage.getPointInteret().get(i).getNom());
		}
		serviceMpg.deleteVoyage(voyage.getId());
	}

	/**
	 * test : suppression d'un voyage existant en base
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void deleteVoyage() throws ServiceFacadeExceptionVoyage {
		Voyage voyage = serviceMpg.createVoyage(voyageFrance);
		int idVoyage = voyage.getId();
		assertNotNull(serviceMpg.getVoyageById(idVoyage));
		serviceMpg.deleteVoyage(idVoyage);
		try {
			serviceMpg.getVoyageById(idVoyage);
		} catch (ServiceFacadeExceptionVoyage e) {
			assertEquals(".Voyage.Dao.Find -> inexistant", e.getMessage());
		}
	}

	/**
	 * test : suppression d'un voyage existant en base
	 * @throws ServiceFacadeExceptionVoyage
	 */
	@Test
	public void updateVoyage() throws ServiceFacadeExceptionVoyage {
		System.out.println("local : " + voyageFrance);
		voyageFrance = serviceMpg.createVoyage(voyageFrance);
		System.out.println("getFromBdd : " + voyageFrance);
		voyageFrance.setNom("Madagascar");
		System.out.println("local modif : " + voyageFrance);
		Voyage voyage = serviceMpg.updateVoyage(voyageFrance);
		System.out.println("modifFromBdd modif : " + voyageFrance);
		assertEquals("Madagascar", voyage.getNom());
		assertEquals(voyageFrance.getNbParticipant(), voyage.getNbParticipant());
		assertEquals(voyageFrance.getDateDebut(), voyage.getDateDebut());
		for (int i=0; i<voyage.getPointInteret().size();i++) {
			assertEquals(voyageFrance.getPointInteret().get(i).getNom(), voyage.getPointInteret().get(i).getNom());
		}
	}
	
}
