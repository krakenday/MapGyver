package dao.uc4Voyage;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.DaoParam;
import dao.exception.uc4Voyage.DaoVoyageErrorMessage;
import dao.exception.uc4Voyage.DaoVoyageException;

@Singleton
@LocalBean
public class DaoGenericVoyage {

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;

	private static final String ZONE_EXCEPTION_MSG = ".Dao";

	
	/**
	 * Persiste un objet dans la Bdd
	 * @param entity a faire persister
	 * @return l'entity sauvegardé avec son Id
	 * @throws DaoVoyageException
	 */
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
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
		return entity;
	}

	/**
	 * Supprime un element sauvegardé dans la Bdd
	 * @param id de l'element a supprimer
	 * @param classe de l'element a supprimer
	 * @throws DaoVoyageException
	 */
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
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
	}

	/**
	 * Met a jour une entity prealablement sauvegardé dans la Bdd
	 * @param entity déjà sauvegardé, contenant les nouveaux éléments a sauvegardé
	 * @return l'entity mis a jour
	 * @throws DaoVoyageException
	 */
	public <T> T update(T entity) throws DaoVoyageException {
		T newEntity = null;
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Update -> ";
		try {
			newEntity = em.merge(entity);
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_UPDATE.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_UPDATE.getMsg());
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
		return newEntity;
	}

	/**
	 * Récupere un objet sauvegardé, selon son id
	 * @param id de l'objet a recuperer
	 * @param classe de l'objet a recuperer
	 * @return l'objet dont l'id et la classe correspond aux parametres
	 * @throws DaoVoyageException
	 */
	public <T> T find(int id, Class<T> classe) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Find -> ";
		T entity = em.find(classe,id);
		try {
			if (entity==null) throw new PersistenceException();
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
		return entity;
	}

	/**
	 * Recupere un objet d'une classe qui est en relation OneToOne
	 * avec un objet d'une seconde classe dont on connait l'id 
	 * @param className classe de l'objet que l'on souhaite recuperer
	 * @param joinAttributeName attribut qui met en relation les 2 classes
	 * @param idSecondClasseName nom de l'attribut dans la premiere classe
	 *  qui permet de referencer un objet de la seconde classe
	 * @param idSecondClasse numero de l'id du second objet
	 * @return un objet de la premiere classe qui est en relation OneToOne 
	 * avec un objet d'une seconde classe dont on connait l'id.
	 * @throws DaoVoyageException
	 */
	public <T> T getOneToOneBySecondClassId(String className, String joinAttributeName, 
			String idSecondClasseName, int idSecondClasse) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".Find -> ";
		try {
			@SuppressWarnings("unchecked")
			List<T> listeEntityT = em.createQuery("select o from "+className +" o right join o."
					+ joinAttributeName +" s where s."+ idSecondClasseName +"=" + idSecondClasse)
			.getResultList();
			if (listeEntityT.get(0)==null) throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
			return listeEntityT.get(0);		
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
	}

	/**
	 * Liste tous les objets sauvegardés d'une classe
	 * @param classe des objets à retourner
	 * @param requeteName nom de la requete 
	 * @return une liste d'objet retourner par la requete dont la classe 
	 * correspond à la classe indiqué en parametre
	 * @throws DaoVoyageException
	 */
	public <T> List<T> findAll(Class<T> classe, String requeteName) throws DaoVoyageException {
		String daoExceptionMsg = ZONE_EXCEPTION_MSG + ".FindAll -> ";
		try {
			Query query = em.createNamedQuery(requeteName);

			@SuppressWarnings("unchecked")
			List<T> listEntity = query.getResultList();
			if (listEntity.isEmpty()) throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
			return listEntity;
		} catch (PersistenceException e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_INEXISTANT.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_INEXISTANT.getMsg());
		} catch (Exception e) {
			throw new DaoVoyageException(DaoVoyageErrorMessage.ERR_BDD.getId(),
					daoExceptionMsg + DaoVoyageErrorMessage.ERR_BDD.getMsg());
		}
	}

}
