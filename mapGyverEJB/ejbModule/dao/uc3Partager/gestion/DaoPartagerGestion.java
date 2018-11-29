package dao.uc3Partager.gestion;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import business.uc3Partager.Description;
import dao.exception.uc3Partager.ViolationPersistenceException;
import dao.util.partager.UtilBdD;
import entity.uc3Partager.DescriptionEntity;

@Singleton
@LocalBean
public class DaoPartagerGestion {
	
	@PersistenceContext(unitName = UtilBdD.PERSISTANCE_UNITNAME)
	private EntityManager em;

	public void addDescription(DescriptionEntity descriptionEntity) throws ViolationPersistenceException {
		try {
//			descriptionEntity.setId(1);
			em.find(entity.uc8Utilisateur.EntityUtilisateur.class , descriptionEntity.getUtilisateur().getId());
			System.out.println(descriptionEntity);								//TODO:A supprimer
			em.persist(descriptionEntity);
			em.flush();															
		} catch (PersistenceException e) {
			System.out.println("DAO_PARTAGER_GESTION >>> addDescription(Description description) - Erreur Persist");//TODO:A supprimer
			throw new ViolationPersistenceException(null, e);			//TODO: Supprimer arguement
		}
	}

	public void updateDescription(DescriptionEntity descriptionEntity) { 		//TODO:NE fonctionne pas
		try {
			descriptionEntity.setLibelleCommentaire("MODIFICATION OK");
			em.find(entity.uc3Partager.DescriptionEntity.class, descriptionEntity.getId());
			em.merge(descriptionEntity);
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> updateDescription(DescriptionEntity descriptionEntity) - Erreur Modification");
		}
	}

	public void deleteDescription(int id) {
		try {
			em.remove(em.find(entity.uc3Partager.DescriptionEntity.class, id)); //Mettre id dans main pour tester
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> deleteDescription(int id) - Erreur Suppression");	
		}		
	}

	public void deleteDescription(Description description) {
		try {
			em.remove(em.find(entity.uc3Partager.DescriptionEntity.class, description.getId()));
		} catch (Exception e) {
			System.out.println("DAO_PARTAGER_GESTION >>> deleteDescription(Description description) - Erreur Suppression par un objet");
		}
	} 
}
