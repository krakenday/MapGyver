package dao.uc4Voyage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.DaoParam;

public class DaoOldGenericVoyage <T> {

//DM	@PersistenceContext(unitName = "IDMhibernateXE")
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager entityManager;
	
	private Class< T > classe;
	
	public DaoOldGenericVoyage(Class<T> classe, EntityManager entityManager) {
		this.classe = classe;
		setEntityManager(entityManager);
	}

	public DaoOldGenericVoyage(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DaoOldGenericVoyage(Class<T> classe) {
		this.classe = classe;
	}

	//DM que fait cette ligne ici!!  
	//IM j'ai essayé de suivre http://qaru.site/questions/174660/hibernate-crud-generic-dao 
	//IM sans succes, j'aurais du supprimer 
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
