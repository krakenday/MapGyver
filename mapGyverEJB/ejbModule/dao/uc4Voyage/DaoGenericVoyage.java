package dao.uc4Voyage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.DaoParam;

public class DaoGenericVoyage <T> {

//DM	@PersistenceContext(unitName = "IDMhibernateXE")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager entityManager;
	
	private Class< T > classe;
	
	public DaoGenericVoyage(Class<T> classe, EntityManager entityManager) {
		this.classe = classe;
		setEntityManager(entityManager);
	}

	public DaoGenericVoyage(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DaoGenericVoyage(Class<T> classe) {
		this.classe = classe;
	}

	//DM que fait cette ligne ici!!
//	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}

	public void create(T entity) {
	    entityManager.persist(entity);
	    entityManager.flush();
	}
	
	public Boolean delete(int id) {
	    try {
	         entityManager.remove(find(id));
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public T update(T entity) {
	    try{
	       return entityManager.merge(entity);
	    } catch(Exception e) {
	        return null;
	    }
	}
	
	public T find(int id) {
		return (T) entityManager.find(classe,id);
	}
	
	
}
