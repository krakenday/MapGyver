package dao.uc3Partager.gestion;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import business.uc3Partager.Description;
import dao.exception.ViolationPersistenceException;
import dao.util.partager.UtilBdD;
import entity.partager.DescriptionEntity;

@Singleton
@LocalBean
public class DaoPartagerGestion {
	
	@PersistenceContext(unitName = UtilBdD.PERSISTANCE_UNITNAME)
	private EntityManager em;

	public void addDescription(DescriptionEntity descriptionEntity) throws ViolationPersistenceException {
		try {
			descriptionEntity.setId(1);
			System.out.println(descriptionEntity);								//TODO:A supprimer
			em.persist(descriptionEntity);
			em.flush();															
		} catch (PersistenceException e) {
			System.out.println("DAO_PARTAGER_GESTION >>> addDescription(Description description) - Erreur Persist");//TODO:A supprimer
			throw new ViolationPersistenceException();
//			//La méthode getCause() permet de rechercher le causeBy
//			Throwable cause = e.getCause();
//			
//			while (cause != null && !(cause instanceof SQLIntegrityConstraintViolationException)) {
//				cause = cause.getCause();
//			}
			
		}
	}

	public void updateDescription(DescriptionEntity descriptionEntity) { //TODO:NE fonctionne pas
		try {
			descriptionEntity.setLibelleCommentaire("MODIFICATION OK");
			em.find(entity.partager.DescriptionEntity.class, descriptionEntity.getId());
			em.merge(descriptionEntity);
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> updateDescription(DescriptionEntity descriptionEntity) - Erreur Modification");
		}
	}

	public void deleteDescription(int id) {
		try {
			em.remove(em.find(entity.partager.DescriptionEntity.class, id)); //Mettre id dans main pour tester
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> deleteDescription(int id) - Erreur Suppression");
		}		
	}

	public void deleteDescription(Description description) {
		try {
			em.remove(em.find(entity.partager.DescriptionEntity.class, description.getId()));
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> deleteDescription(Description description) - Erreur Suppression par un objet");
		}
	} 
}
