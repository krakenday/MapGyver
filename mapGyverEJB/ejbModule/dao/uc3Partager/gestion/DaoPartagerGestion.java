package dao.uc3Partager.gestion;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc3Partager.Description;
import dao.util.partager.UtilBdD;
import entity.partager.DescriptionEntity;

@Singleton
@LocalBean
public class DaoPartagerGestion {
	
	@PersistenceContext(unitName = UtilBdD.PERSISTANCE_UNITNAME)
	private EntityManager em;

	public void addDescription(DescriptionEntity descriptionEntity) {
		try {
			System.out.println(descriptionEntity);
			em.persist(descriptionEntity);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DAO_PARTAGER_GESTION >>> addDescription(Description description) - Erreur Persist");
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
