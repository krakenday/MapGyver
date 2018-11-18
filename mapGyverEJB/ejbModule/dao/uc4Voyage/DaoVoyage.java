package dao.uc4Voyage;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Voyage;
import dao.util.UtilBdD;

@Singleton
@LocalBean
public class DaoVoyage {

	final String persistenceName 	= "IDMhibernateXE";



	public void createVoyage(Voyage voyage) {
		//		System.out.println("create Entity form : " + voyage);
		//		EntityVoyage entityVoyage = entityFactory.createEntityFrom(voyage);
		EntityVoyage entityVoyage = new EntityVoyage(0, "nom", LocalDate.now(), 50);
		System.out.println("Entity : " + entityVoyage);
		try {
			// Unité de persistance
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);

			//récupérer un EntityManagerFactory à partir de l'unité de persistance
			EntityManager em = emf.createEntityManager();
			//début transaction
			EntityTransaction tx = em.getTransaction();

			tx.begin();
			em.persist(entityVoyage);
			//em.flush();
			tx.commit(); // fin transaction
			em.close(); // fin EntityManager
			emf.close(); // fin EntityManagerFactory

		} catch (Exception e) {
			System.out.println("Pb Persist");
		}
	}

	public List<Voyage> readVoyageOrderByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateVoyage(Voyage voyage) {
		// TODO Auto-generated method stub

	}

	public void deleteVoyage(int id) {
		// TODO Auto-generated method stub

	}

	public Voyage findVoyagebyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createRoadBook(RoadBook roadBook) {
		// TODO Auto-generated method stub

	}

	public List<RoadBook> readRoadBookOrderByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateRoadBook(RoadBook roadBook) {
		// TODO Auto-generated method stub

	}

	public void deleteRoadBook(int id) {
		// TODO Auto-generated method stub

	}

	public RoadBook findRoadBookbyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createPOInteret(PointInteret pointInteret) {
		// TODO Auto-generated method stub

	}

	public List<PointInteret> readPOInteretOrderByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePOInteret(PointInteret pointInteret) {
		// TODO Auto-generated method stub

	}

	public void deletePOInteret(int id) {
		// TODO Auto-generated method stub

	}

	public PointInteret findPOInteretByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
