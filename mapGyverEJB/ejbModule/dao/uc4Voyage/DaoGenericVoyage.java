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
import entity.uc4Voyage.EntityRoadBook;
import entity.uc8Utilisateur.EntityUtilisateur;

@Singleton
@LocalBean
public class DaoGenericVoyage {

	//	@PersistenceContext(unitName = "IDMhibernateXE")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;

	private static final String ZONE_EXCEPTION_MSG = ".Voyage";

	public <T> T create(T entity) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Insert -> ";
		try {
			System.out.println("daoVoyage create " + entity);
			em.persist(entity);
			System.out.println("em.persist(entity) ok");
			em.flush();
			System.out.println("em.flush() ok");
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

	public <T> T find(Class<T> classe, int id) {
		return em.find(classe,id);
	}

	public <T> T getOneToOneBySecondClassId(String className, 
			String joinAttributeName, int idSecondClasse) {
		T t=null;
		@SuppressWarnings("unchecked")
		List<T> l = em.createQuery("select f from "+className+" f right join f."
				+ joinAttributeName +" s where s.id=" + idSecondClasse).getResultList();
		if (l !=null) t=l.get(0);
		return t;
	}

}
