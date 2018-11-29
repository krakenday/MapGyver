package dao.uc6Jouer;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.DaoParam;

@Singleton
@LocalBean
public class CrudDao {
//	@PersistenceContext(unitName = "MapGyver")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em;

	public <T> void createCrud(T aPersister) {
		em.persist(aPersister);
	}
}
