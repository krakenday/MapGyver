package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		entityCoordonne.setId(100);
		entityPays = new EntityPays("Espagne", entityCoordonne);
		entityPays.setId(200);
		entityVille = new EntityVille("Barcelone", entityCoordonne);
		entityVille.setEntityPays(entityPays);
		entityVille.setId(300);
		entityLieu = new EntityLieu("Camp Nou", entityCoordonne);
		entityLieu.setEntityVille(entityVille);
		entityLieu.setId(400);
		listEntityPOI.add(entityPays);
		listEntityPOI.add(entityVille);
		listEntityPOI.add(entityLieu);

		voyageFrance = new Voyage("France", LocalDate.now(), 15,listPOI); 
		
		entityVoyageEspagne = new EntityVoyage("Espagne", LocalDate.now(), 15,listEntityPOI);
		entityVoyageEspagne.setId(500);
	}

	@Test
	public void createFromEntityVoyage() {
		Voyage voyage = factoryEntity.createFromEntity(entityVoyageEspagne);
		assertEquals(3, voyage.getPointInteret().size());
		assertEquals(entityVoyageEspagne.getEntityPointInterets().get(0).getNom(),
				voyage.getPointInteret().get(0).getNom());
		assertEquals(entityVoyageEspagne.getNom(), voyage.getNom());
		assertEquals(entityVoyageEspagne.getDateDebut(), voyage.getDateDebut());
		assertEquals(entityVoyageEspagne.getNbParticipant(), voyage.getNbParticipant());
	}	

	@Test
	public void createEntityFromVoyage() {
		EntityVoyage voyage = factoryEntity.createEntityFrom(voyageFrance);
		assertEquals(3, voyage.getEntityPointInterets().size());
		assertEquals(voyageFrance.getPointInteret().get(0).getNom(),
				voyage.getEntityPointInterets().get(0).getNom());
		assertEquals(voyageFrance.getNom(), voyage.getNom());
		assertEquals(voyageFrance.getDateDebut(), voyage.getDateDebut());
		assertEquals(voyageFrance.getNbParticipant(), voyage.getNbParticipant());
	}
	
	@Test
	public void listPOICreateFromListEntityPOI() {
		List<PointInteret> list = factoryEntity.createFromEntityPOI(listEntityPOI);
		assertEquals(3, list.size());
		assertEquals(listEntityPOI.get(0).getNom(), list.get(0).getNom());
		assertEquals(listEntityPOI.get(0).getEntityCoordonnee().getLatitude(), list.get(0).getCoordonnee().getLatitude(), 0.0f);
		assertEquals(listEntityPOI.get(0).getEntityCoordonnee().getLongitude(), list.get(0).getCoordonnee().getLongitude(), 0.0f);
	}	
	
	@Test
	public void listPOICreateEntityFromListPOI() {
		List<EntityPointInteret> list = factoryEntity.createEntityFromPOI(listPOI);
		assertEquals(3, list.size());
		assertEquals(listPOI.get(0).getNom(), list.get(0).getNom());
		assertEquals(listPOI.get(0).getCoordonnee().getLatitude(), list.get(0).getEntityCoordonnee().getLatitude(), 0.0f);
		assertEquals(listPOI.get(0).getCoordonnee().getLongitude(), list.get(0).getEntityCoordonnee().getLongitude(), 0.0f);
	}
	
	@Test
	public void lieuCreateFromEntity() {
		Lieu lieu1 = factoryEntity.createFromEntity(entityLieu);
		assertEquals(entityLieu.getId(), lieu1.getId());
		assertEquals(entityLieu.getNom(), lieu1.getNom());
		assertEquals(entityLieu.getEntityVille().getNom(), lieu1.getVille().getNom());
		assertEquals(entityLieu.getEntityCoordonnee().getLatitude(), lieu1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityLieu.getEntityCoordonnee().getLongitude(), lieu1.getCoordonnee().getLongitude(), 0.0f);
		Ville ville1 = lieu1.getVille();
		assertEquals(entityVille.getId(), ville1.getId());
		assertEquals(entityVille.getNom(), ville1.getNom());
		assertEquals(entityVille.getEntityCoordonnee().getId(), ville1.getCoordonnee().getId());
		assertEquals(entityVille.getEntityCoordonnee().getLatitude(), ville1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityVille.getEntityCoordonnee().getLongitude(), ville1.getCoordonnee().getLongitude(), 0.0f);
		Pays pays1 = ville1.getPays();
		assertEquals(entityPays.getId(), pays1.getId());
		assertEquals(entityPays.getNom(), pays1.getNom());
		assertEquals(entityPays.getEntityCoordonnee().getId(), pays1.getCoordonnee().getId());
		assertEquals(entityPays.getEntityCoordonnee().getLatitude(), pays1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityPays.getEntityCoordonnee().getLongitude(), pays1.getCoordonnee().getLongitude(), 0.0f);
	}
	
	@Test
	public void villeCreateFromEntity() {
		Ville ville1 = factoryEntity.createFromEntity(entityVille);
		assertEquals(entityVille.getId(), ville1.getId());
		assertEquals(entityVille.getNom(), ville1.getNom());
		assertEquals(entityVille.getEntityCoordonnee().getId(), ville1.getCoordonnee().getId());
		assertEquals(entityVille.getEntityCoordonnee().getLatitude(), ville1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityVille.getEntityCoordonnee().getLongitude(), ville1.getCoordonnee().getLongitude(), 0.0f);
		Pays pays1 = ville1.getPays();
		assertEquals(entityPays.getId(), pays1.getId());
		assertEquals(entityPays.getNom(), pays1.getNom());
		assertEquals(entityPays.getEntityCoordonnee().getId(), pays1.getCoordonnee().getId());
		assertEquals(entityPays.getEntityCoordonnee().getLatitude(), pays1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityPays.getEntityCoordonnee().getLongitude(), pays1.getCoordonnee().getLongitude(), 0.0f);
	}
	
	
	@Test
	public void paysCreateFromEntity() {
		Pays pays1 = factoryEntity.createFromEntity(entityPays);
		assertEquals(entityPays.getId(), pays1.getId());
		assertEquals(entityPays.getNom(), pays1.getNom());
		assertEquals(entityPays.getEntityCoordonnee().getId(), pays1.getCoordonnee().getId());
		assertEquals(entityPays.getEntityCoordonnee().getLatitude(), pays1.getCoordonnee().getLatitude(), 0.0f);
		assertEquals(entityPays.getEntityCoordonnee().getLongitude(), pays1.getCoordonnee().getLongitude(), 0.0f);

	}
	
	
	@Test
	public void coordonneeCreateFromEntity() {
		Coordonnee coordonnee1 = factoryEntity.createFromEntity(entityCoordonne);
		assertEquals(entityCoordonne.getId(), coordonnee1.getId());
		assertEquals(entityCoordonne.getLatitude(), coordonnee1.getLatitude(), 0.0f);
		assertEquals(entityCoordonne.getLongitude(), coordonnee1.getLongitude(), 0.0f);
	}
	
	@Test
	public void lieuCreateEntityFrom() {
		EntityLieu entitylieu1 = factoryEntity.createEntityFrom(lieu);
		assertEquals(lieu.getNom(), entitylieu1.getNom());
		assertEquals(lieu.getId(), entitylieu1.getId());
		assertEquals(lieu.getCoordonnee().getLatitude(), entitylieu1.getEntityCoordonnee().getLatitude(), 0.0f);
		assertEquals(lieu.getCoordonnee().getLongitude(), entitylieu1.getEntityCoordonnee().getLongitude(), 0.0f);	
		EntityVille entityVille1 = entitylieu1.getEntityVille();
		assertEquals(ville.getId(), entityVille1.getId());
		assertEquals(ville.getNom(), entityVille1.getNom());
		assertEquals(ville.getCoordonnee().getId(), entityVille1.getEntityCoordonnee().getId());
		assertEquals(ville.getCoordonnee().getLatitude(), entityVille1.getEntityCoordonnee().getLatitude(), 0.0f);
		assertEquals(ville.getCoordonnee().getLongitude(), entityVille1.getEntityCoordonnee().getLongitude(), 0.0f);
		EntityPays entityPays1 = entityVille1.getEntityPays();
		assertEquals(pays.getId(), entityPays1.getId());
		assertEquals(pays.getNom(), entityPays1.getNom());
		assertEquals(pays.getCoordonnee().getId(), entityPays1.getEntityCoordonnee().getId());
		assertEquals(pays.getCoordonnee().getLatitude(), entityPays1.getEntityCoordonnee().getLatitude(), 0.0f );
		assertEquals(pays.getCoordonnee().getLongitude(), entityPays1.getEntityCoordonnee().getLongitude(),  0.0f);
	}
	
	@Test
	public void villeCreateEntityFrom() {
		EntityVille entityVille1 = factoryEntity.createEntityFrom(ville);
		assertEquals(ville.getNom(), entityVille1.getNom());
		assertEquals(ville.getCoordonnee().getId(), entityVille1.getEntityCoordonnee().getId());
		assertEquals(ville.getCoordonnee().getLatitude(), entityVille1.getEntityCoordonnee().getLatitude(), 0.0f);
		assertEquals(ville.getCoordonnee().getLongitude(), entityVille1.getEntityCoordonnee().getLongitude(), 0.0f);
		EntityPays entityPays1 = entityVille1.getEntityPays();
		assertEquals(pays.getId(), entityPays1.getId());
		assertEquals(pays.getNom(), entityPays1.getNom());
		assertEquals(pays.getCoordonnee().getId(), entityPays1.getEntityCoordonnee().getId());
		assertEquals(pays.getCoordonnee().getLatitude(), entityPays1.getEntityCoordonnee().getLatitude(), 0.0f );
		assertEquals(pays.getCoordonnee().getLongitude(), entityPays1.getEntityCoordonnee().getLongitude(),  0.0f);
		
	}
	
	@Test
	public void paysCreateEntityFrom() {
		EntityPays entityPays1 = factoryEntity.createEntityFrom(pays);
		assertEquals(pays.getNom(), entityPays1.getNom());
		assertEquals(pays.getCoordonnee().getId(), entityPays1.getEntityCoordonnee().getId());
		assertEquals(pays.getCoordonnee().getLatitude(), entityPays1.getEntityCoordonnee().getLatitude(), 0.0f );
		assertEquals(pays.getCoordonnee().getLongitude(), entityPays1.getEntityCoordonnee().getLongitude(),  0.0f);
	}

	@Test
	public void coordonneeCreateEntityFrom()  {
		EntityCoordonnee entityCoordonnee1 = factoryEntity.createEntityFrom(coordonnee);
		assertEquals(coordonnee.getLatitude(), entityCoordonnee1.getLatitude(), 0.0f);
		assertEquals(coordonnee.getLongitude(), entityCoordonnee1.getLongitude(), 0.0f);
	}

}
