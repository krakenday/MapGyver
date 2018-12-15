package dao.uc2Souvenir;
/**
 * Classe en charge de supprimer le souvenir selectionne par
 * l utilisateur
 */

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.DaoParam;
import entity.uc2Souvenir.EntitySouvenir;

@Singleton
@LocalBean
public class DaoSouvenirSupprimerSouvenir {
	
	@PersistenceContext(unitName=DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager 		em;
	

	public void supprimeSouvenirById(int idSouvenir) {
		System.out.println("je suis dans DaoSouvenirSupprimerSouvenir");
		System.out.println("idSouvenir = " + idSouvenir);
		
		em.remove(em.find(EntitySouvenir.class, idSouvenir));
		
		//Suppression par requete hql manuelle
		//String hqlSupr = "delete from EntitySouvenir e where e.id = :idSouvenir";
		//Query query = em.createQuery(hqlSupr);
		//query.setParameter("idSouvenir", 8);
		//query.executeUpdate();
		
	}

}
