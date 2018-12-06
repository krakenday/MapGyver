package dao.uc4Voyage;

import java.util.List;

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
public class DaoGenericVoyage {

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";

	public <T> T create(T entity) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Insert -> ";
		try {
			em.persist(entity);
			em.flush();
		}
		catch (PersistenceException e) {
			Throwable t = e.getCause();
			while (t != null) {
				if (t instanceof java.sql.SQLIntegrityConstraintViolationException) {
					throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_VIOLATION_CONTRAINT.getId(),
							daoExceptionMsg + DaoVoyageErrorMessage.ERR_VIOLATION_CONTRAINT.getMsg());
				} else {
					t = t.getCause();
				}
			}
			e.printStackTrace();
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INSERT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INSERT.getMsg());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public <T> void delete(int id, Class<T> classe) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Delete -> ";
		try {
			if (em.find(classe, id)==null) 
				throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
			em.remove(em.find(classe, id));
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_DELETE.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_DELETE.getMsg());
		}

	}

	public <T> T update(T entity) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Update -> ";
		try {
			em.merge(entity);
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_UPDATE.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_UPDATE.getMsg());
		}
		return entity;
	}

	public <T> T find(int id, Class<T> classe) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Find -> ";
		T entity = em.find(classe,id);
		try {
			if (entity==null) throw new PersistenceException();
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
		}
		return entity;
	}

	public <T> T getOneToOneBySecondClassId(String className, String joinAttributeName, 
			String idSecondClasseName, int idSecondClasse) {
		T entityT=null;
		@SuppressWarnings("unchecked")
		List<T> listeEntityT = em.createQuery("select o from "+className +" o right join o."
				+ joinAttributeName +" s where s."+ idSecondClasseName +"=" + idSecondClasse)
			.getResultList();
		if (listeEntityT !=null) entityT=listeEntityT.get(0);
		return entityT;
	}

}
