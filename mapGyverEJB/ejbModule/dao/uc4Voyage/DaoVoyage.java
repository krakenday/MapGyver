package dao.uc4Voyage;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import dao.DaoParam;
import dao.exception.uc4Voyage.DaoVoyageErrorMessage;
import dao.exception.uc4Voyage.DaoVoyageException;

@Singleton
@LocalBean
public class DaoVoyage {

//	@PersistenceContext(unitName = "IDMhibernateXE")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;
	
	private static final String ZONE_EXCEPTION_MSG = ".Voyage";

	public <T> void create(T entity) throws DaoVoyageException {
		String doExceptionMsg = ZONE_EXCEPTION_MSG + ".Insert -> ";
		try {
			em.persist(entity);
			em.flush();
		}
		catch (PersistenceException e) {
			Throwable t = e.getCause();
			while (t != null) {
				if (t instanceof java.sql.SQLIntegrityConstraintViolationException) {
					throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_VIOLATION_CONTRAINT.getId(),
							doExceptionMsg + DaoVoyageErrorMessage.ERR_VIOLATION_CONTRAINT.getMsg());
				} else {
					t = t.getCause();
				}
			}
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INSERT.getId(),
					doExceptionMsg + DaoVoyageErrorMessage.ERR_INSERT.getMsg());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public <T> void delete(int id, Class<T> classe) throws DaoVoyageException {
		String doExceptionMsg = ZONE_EXCEPTION_MSG + ".Delete -> ";
		try {
			em.remove(em.find(classe, id));
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_DELETE.getId(),
					doExceptionMsg + DaoVoyageErrorMessage.ERR_DELETE.getMsg());
		}
		
	}

	public <T> void update(T entity) throws DaoVoyageException {
		String doExceptionMsg = ZONE_EXCEPTION_MSG + ".Update -> ";
		try {
			em.merge(entity);
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_UPDATE.getId(),
					doExceptionMsg + DaoVoyageErrorMessage.ERR_UPDATE.getMsg());
		}
		
	}

	

}
