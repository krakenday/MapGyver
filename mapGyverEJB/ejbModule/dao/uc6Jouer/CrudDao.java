package dao.uc6Jouer;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
public class CrudDao {
	@PersistenceContext(unitName = "MapGyver")
	EntityManager em;

	public <T> void createCrud(T aPersister) {
		em.persist(aPersister);
	}
}
