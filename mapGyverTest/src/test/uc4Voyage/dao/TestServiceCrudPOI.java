package test.uc4Voyage.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import clientServeur.IServiceFacade;
import clientServeur.exception.ServiceFacadeExceptionVoyage;
import dao.exception.uc4Voyage.DaoVoyageException;
import dao.uc4Voyage.DaoGenericVoyage;
import entity.uc4Voyage.EntityCoordonnee;
import entity.uc4Voyage.EntityLieu;
import entity.uc4Voyage.EntityPays;
import entity.uc4Voyage.EntityVille;

public class TestServiceCrudPOI {
	
	private static final String VOYAGE_SERVICE_LOOKUP = "ejb:/mapGyverEJB/ServiceFacade!clientServeur.IServiceFacade";
	private static Context 			context;
	private static IServiceFacade 	serviceMpg;
	
	private static EntityCoordonnee entityTestCoord1;
	private static EntityPays 		entityTestPays1;
	private static EntityVille 		entityTestVille1;
	private static EntityLieu 		entityTestLieu1;

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
		entityTestCoord1 = new EntityCoordonnee(47.353711, 1.71918);
		entityTestPays1  = new EntityPays("France", entityTestCoord1);
		entityTestVille1 = new EntityVille("Marseille", entityTestCoord1, entityTestPays1);
		entityTestLieu1	 = new EntityLieu("AFPA", entityTestCoord1, entityTestVille1);
		
	}

	@Test
	public void readPOI() throws ServiceFacadeExceptionVoyage {

	}
	

}
