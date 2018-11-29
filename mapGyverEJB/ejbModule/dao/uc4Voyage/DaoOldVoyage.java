package dao.uc4Voyage;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import dao.DaoParam;
import dao.exception.uc4Voyage.DaoVoyageErrorMessage;
import dao.exception.uc4Voyage.DaoVoyageException;
import entity.uc4Voyage.EntityVoyage;

@Singleton
@LocalBean
public class DaoOldVoyage {

	//DM @PersistenceContext(unitName = "IDMhibernateXE")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;
	
	private static final String ZONE_EXCEPTION_MSG = ".Voyage";
	
	public void create(EntityVoyage entityVoyage) throws DaoVoyageException {
		String doExceptionMsg = ZONE_EXCEPTION_MSG + ".Insert -> ";
		try {
			System.out.println(entityVoyage);
			em.persist(entityVoyage);
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

	
	

}
