package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;

public class TestServiceCrudPOI {

	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static Context 			context;
	private static IServiceFacade 	serviceMpg;

	private static Coordonnee 	coordonnee;
	private static Pays 		france;
	private static Ville 		marseille;
	private static Lieu 		afpa;

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
		coordonnee = new Coordonnee(47.353711, 1.71918);

		france  = new Pays("France",coordonnee);

		marseille = new Ville("Marseille", coordonnee);
		marseille.setPays(france);

		afpa	 = new Lieu("AFPA",coordonnee);
		afpa.setVille(marseille);
	}


	@Test
	public void createPAYS() throws ServiceFacadeExceptionVoyage {
		Pays poi = (Pays)serviceMpg.createPOInteret(france);
		assertNotNull(poi.getId());
		assertEquals(france.getNom(), poi.getNom());
		assertEquals(france.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(france.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}


	@Test
	public void createVILLE() throws ServiceFacadeExceptionVoyage {
		Pays pays = (Pays)serviceMpg.createPOInteret(france);
		marseille.setPays(pays);
		Ville poi = (Ville)serviceMpg.createPOInteret(marseille);
		System.out.println(poi);
		assertNotNull(poi.getId());
		assertEquals(marseille.getNom(), poi.getNom());
		assertEquals(marseille.getPays().getNom(), poi.getPays().getNom());
		assertEquals(marseille.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(marseille.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}


	@Test
	public void createLIEUoldElement() throws ServiceFacadeExceptionVoyage {
		Pays pays = (Pays)serviceMpg.createPOInteret(france);
		marseille.setPays(pays);
		Ville ville = (Ville)serviceMpg.createPOInteret(marseille);
		afpa.setVille(ville);
		Lieu poi = (Lieu)serviceMpg.createPOInteret(afpa);
		assertTrue(poi.getVille().getPays().getId()!=0);
		assertTrue(poi.getVille().getId()!=0);
		assertTrue(poi.getId()!=0);
		assertEquals(afpa.getNom(), poi.getNom());
		assertEquals(afpa.getVille().getNom(), poi.getVille().getNom());
		assertEquals(afpa.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(afpa.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}

	@Test
	public void createLIEUnewElement() throws ServiceFacadeExceptionVoyage {
		System.out.println(afpa);
		Lieu poi = (Lieu)serviceMpg.createPOInteret(afpa);
		System.out.println(poi);
		assertTrue(poi.getVille().getPays().getId()!=0);
		assertTrue(poi.getVille().getId()!=0);
		assertTrue(poi.getId()!=0);
		assertEquals(afpa.getNom(), poi.getNom());
		assertEquals(afpa.getVille().getNom(), poi.getVille().getNom());
		assertEquals(afpa.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(afpa.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}
	
	@Test
	public void getPOI() throws ServiceFacadeExceptionVoyage {

		System.out.println("afpa "+afpa);
		PointInteret poi1= serviceMpg.createPOInteret(afpa);
		System.out.println("create getPOI "+poi1);
		PointInteret poi = serviceMpg.getPOInteretById(poi1.getId());
		System.out.println("get getPOI "+poi);
		assertEquals(poi1.getId(), poi.getId());
		assertEquals(poi1.getNom(), poi.getNom());
		assertEquals(poi1.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(poi1.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
	}
	
	@Test
	public void deletePOI() throws ServiceFacadeExceptionVoyage {
		Pays poi = (Pays)serviceMpg.createPOInteret(france);
		int idPOI = poi.getId();
		assertNotNull(serviceMpg.getPOInteretById(idPOI));
		assertEquals(idPOI, serviceMpg.getPOInteretById(idPOI).getId());
		serviceMpg.deletePOInteret(idPOI);
		try {
			serviceMpg.getPOInteretById(idPOI);
		} catch (ServiceFacadeExceptionVoyage e) {
			assertEquals(".POI.Dao.Find -> inexistant", e.getMessage());
		}
	}
}
