package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc4Voyage.Coordonnee;
import business.uc4Voyage.Lieu;
import business.uc4Voyage.Pays;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.Ville;
import business.uc4Voyage.Voyage;
import entity.uc4Voyage.EntityCoordonnee;
import entity.uc4Voyage.EntityLieu;
import entity.uc4Voyage.EntityPays;
import entity.uc4Voyage.EntityPointInteret;
import entity.uc4Voyage.EntityVille;
import entity.uc4Voyage.EntityVoyage;
import entity.uc4Voyage.FactoryEntity;

public class TestFactoryEntity {

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

	private FactoryEntity factoryEntity = new FactoryEntity();

	@BeforeClass
	public static void init() {

	}

	@Before
	public void avantTest() {

		coordonnee = new Coordonnee(-50, -60);
		pays = new Pays("France", coordonnee);
		ville = new Ville("Marseille", coordonnee);
		ville.setPays(pays);
		lieu = new Lieu("Velodrome", coordonnee);
		lieu.setVille(ville);
		listPOI.add(pays);
		listPOI.add(ville);
		listPOI.add(lieu);

		entityCoordonne = new EntityCoordonnee(50, 60);
		entityPays = new EntityPays("Espagne", entityCoordonne);
		entityVille = new EntityVille("Barcelone", entityCoordonne);
		entityVille.setPays(entityPays);
		entityLieu = new EntityLieu("Camp Nou", entityCoordonne);
		entityLieu.setVille(entityVille);
		listEntityPOI.add(entityPays);
		listEntityPOI.add(entityVille);
		listEntityPOI.add(entityLieu);

		voyageFrance = new Voyage("France", LocalDate.now(), 15,listPOI); 
		entityVoyageEspagne = new EntityVoyage("Espagne", LocalDate.now(), 15,listEntityPOI);
	}

	@Test
	public void createFromEntityVoyage() {
		Voyage voyage = factoryEntity.createFromEntity(entityVoyageEspagne);
		System.out.println(entityVoyageEspagne.getEntityPointInteret());
		System.out.println(voyage.getPointInteret());
		assertEquals(3, voyage.getPointInteret().size());
		assertEquals(entityVoyageEspagne.getEntityPointInteret().get(0).getNom(),
				voyage.getPointInteret().get(0).getNom());
		assertEquals(entityVoyageEspagne.getNom(), voyage.getNom());
		assertEquals(entityVoyageEspagne.getDateDebut(), voyage.getDateDebut());
		assertEquals(entityVoyageEspagne.getNbParticipant(), voyage.getNbParticipant());
	}	

	@Test
	public void ListPOICreateFromListEntityPOI() {
		List<PointInteret> list = factoryEntity.createFromEntityPOI(listEntityPOI);
		assertEquals(3, list.size());
		assertEquals(listEntityPOI.get(0).getNom(), list.get(0).getNom());
		assertEquals(listEntityPOI.get(0).getCoordonnee().getLatitude(), list.get(0).getCoordonnee().getLatitude(), 0.0f);
		assertEquals(listEntityPOI.get(0).getCoordonnee().getLongitude(), list.get(0).getCoordonnee().getLongitude(), 0.0f);
	}	

	@Test
	public void LieuCreateFromEntity() {
		Lieu lieu = factoryEntity.createFromEntity(entityLieu);
		assertEquals(entityLieu.getNom(), lieu.getNom());
		assertEquals(entityLieu.getVille().getNom(), lieu.getVille().getNom());
		assertEquals(entityLieu.getCoordonnee().getLatitude(), lieu.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityLieu.getCoordonnee().getLongitude(), lieu.getCoordonnee().getLongitude(), 0.0f);
	}

	@Test
	public void VilleCreateFromEntity() {
		Ville ville = factoryEntity.createFromEntity(entityVille);
		assertEquals(entityVille.getNom(), ville.getNom());
		assertEquals(entityVille.getPays().getNom(), ville.getPays().getNom());
		assertEquals(entityVille.getCoordonnee().getLatitude(), ville.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityVille.getCoordonnee().getLongitude(), ville.getCoordonnee().getLongitude(), 0.0f);
	}

	@Test
	public void PaysCreateFromEntity() {
		Pays pays = factoryEntity.createFromEntity(entityPays);
		assertEquals(entityPays.getNom(), pays.getNom());
		assertEquals(entityPays.getCoordonnee().getLatitude(), pays.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityPays.getCoordonnee().getLongitude(), pays.getCoordonnee().getLongitude(), 0.0f);
	}

	@Test
	public void CoordonneeCreateFromEntity() {
		Coordonnee coord = factoryEntity.createFromEntity(entityCoordonne);
		assertEquals(entityCoordonne.getLatitude(), coord.getLatitude(), 0.0f);
		assertEquals(entityCoordonne.getLongitude(), coord.getLongitude(), 0.0f);
	}

	@Test
	public void CoordonneeCreateFromEntityWithId() {
		entityCoordonne.setId(10);
		Coordonnee coord = factoryEntity.createFromEntityWithId(entityCoordonne);
		assertEquals(entityCoordonne.getId(), coord.getId());
		assertEquals(entityCoordonne.getLatitude(), coord.getLatitude(), 0.0f);
		assertEquals(entityCoordonne.getLongitude(), coord.getLongitude(), 0.0f);
	}

	@Test
	public void CoordonneeCreateEntityFrom()  {
		EntityCoordonnee entitycoord = factoryEntity.createEntityFrom(coordonnee);
		assertEquals(coordonnee.getLatitude(), entitycoord.getLatitude(), 0.0f);
		assertEquals(coordonnee.getLongitude(), entitycoord.getLongitude(), 0.0f);
	}

	@Test
	public void CoordonneeCreateWithIdEntityFrom() {
		coordonnee.setId(10);
		EntityCoordonnee entitycoord = factoryEntity.createEntityWithIdFrom(coordonnee);
		assertEquals(coordonnee.getId(), entitycoord.getId());
		assertEquals(coordonnee.getLatitude(), entitycoord.getLatitude(), 0.0f);
		assertEquals(coordonnee.getLongitude(), entitycoord.getLongitude(), 0.0f);
	}

}
