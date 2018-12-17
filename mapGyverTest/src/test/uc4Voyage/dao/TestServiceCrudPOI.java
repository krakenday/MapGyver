package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	private static Coordonnee 	coordonnee4;
	private static Coordonnee 	coordonnee5;
	private static Coordonnee 	coordonnee6;
	private static Coordonnee 	coordonnee7;
	private static Pays 		france;
	private static Pays 		espagne;
	private static Pays 		mada;
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
		coordonnee4 = new Coordonnee(4, 4);
		coordonnee5 = new Coordonnee(5, 5);
		coordonnee6 = new Coordonnee(6, 6);
		coordonnee7 = new Coordonnee(7, 7);

		france  = new Pays("France",coordonnee);
		espagne  = new Pays("Espagne",coordonnee4);
		mada  = new Pays("Mada",coordonnee5);
		
		marseille = new Ville("Marseille", coordonnee6);
		marseille.setPays(france);

		afpa	 = new Lieu("AFPA",coordonnee7);
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
	public void updatePAYS() throws ServiceFacadeExceptionVoyage {
		Pays pays1 = (Pays)serviceMpg.createPOInteret(france);
		pays1.setNom("Champion du monde");
		Pays poi  = (Pays)serviceMpg.updatePOInteret(pays1);
		assertEquals(pays1.getId(), poi.getId());
		assertEquals("Champion du monde", poi.getNom());
		assertEquals(france.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(france.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
	}

	@Test
	public void createVILLEoldElement() throws ServiceFacadeExceptionVoyage {
		System.out.println(france);
		Pays pays = (Pays)serviceMpg.createPOInteret(france);
		System.out.println(pays);
		marseille.setPays(pays);
		System.out.println(marseille);
		Ville poi = (Ville)serviceMpg.createPOInteret(marseille);
		System.out.println(marseille);
		assertNotNull(poi.getId());
		assertEquals(marseille.getNom(), poi.getNom());
		assertEquals(marseille.getPays().getNom(), poi.getPays().getNom());
		assertEquals(marseille.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(marseille.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}
	
	@Test
	public void createVILLEnewElement() throws ServiceFacadeExceptionVoyage {
		marseille.setPays(france);
		Ville poi = (Ville)serviceMpg.createPOInteret(marseille);
		assertNotNull(poi.getId());
		assertEquals(marseille.getNom(), poi.getNom());
		assertTrue(poi.getPays().getId()!=0);
		assertEquals(marseille.getPays().getNom(), poi.getPays().getNom());
		assertEquals(marseille.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(marseille.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}
	
	@Test
	public void updateVILLE() throws ServiceFacadeExceptionVoyage {
		Pays pays1 = (Pays)serviceMpg.createPOInteret(france);
		Pays pays2 = (Pays)serviceMpg.createPOInteret(espagne);
		marseille.setPays(pays1);
		Ville ville = (Ville)serviceMpg.createPOInteret(marseille);
		ville.setPays(pays2);
		ville =  (Ville)serviceMpg.updatePOInteret(ville);
		assertNotNull(ville.getId());
		assertEquals(marseille.getNom(), ville.getNom());
		assertEquals("Espagne", ville.getPays().getNom());
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
		assertTrue(poi.getVille().getPays().getId()!=0);
		assertTrue(poi.getVille().getId()!=0);
		assertTrue(poi.getId()!=0);
		assertEquals(afpa.getNom(), poi.getNom());
		assertEquals(afpa.getVille().getNom(), poi.getVille().getNom());
		assertEquals(afpa.getCoordonnee().getLatitude(), poi.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(afpa.getCoordonnee().getLongitude(), poi.getCoordonnee().getLongitude(), 0.0f);
		//serviceMpg.deletePOInteret(poi.getId());
	}
	
	//TODO decommenter les methodes dans l'EJB service
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
	
	@Test
	public void findAllPOI() throws ServiceFacadeExceptionVoyage {
		Pays poiEspagne = (Pays)serviceMpg.createPOInteret(espagne);
		Ville poiMarseille = (Ville)serviceMpg.createPOInteret(marseille);
		List<PointInteret> listPOI = new ArrayList<>();
		listPOI = serviceMpg.readPOInteretOrderById();
		assertNotNull(listPOI);
		assertTrue(listPOI.contains(poiEspagne));
		assertTrue(listPOI.contains(poiMarseille));
	}
}
