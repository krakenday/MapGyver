package dao.uc2Souvenir;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Souvenir;
import business.uc4Voyage.Voyage;
import dao.DaoParam;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc4Voyage.EntityVoyage;

@Singleton
@LocalBean
//TODO dans cette classe beaucoup de choses en commun avec
//DaoSouvenirCreatePhoto et les Factorys
//Voir si possible de factoriser.
public class DaoSouvenirCreateCommentaire {

	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;
	
	private EntityCommentaire 	entityCommentaire;
	private Commentaire 		commentaire;
	private EntityVoyage		entityVoyage;
	
	public void createSouvenir(Souvenir souvenir) {
		
		System.out.println("*****/////////Je suis dans DaoSouvenirCreateCommentaire");
		commentaire = (Commentaire) souvenir;
		System.out.println("*****/////////Je suis dans DaoSouvenirCreateCommentaire--Etape 2");
		entityVoyage = new EntityVoyage(commentaire.getVoyage().getId(), null, null, null);
		System.out.println("*****/////////Je suis dans DaoSouvenirCreateCommentaire--Etape 3");
		entityCommentaire = new EntityCommentaire(entityVoyage, LocalDate.now(),
				commentaire.getDescription());
		System.out.println("*****/////////Je suis dans DaoSouvenirCreateCommentaire--EntityCommentaire OK");
		try {
			
			System.out.println("*****entityCommentaire:" + entityCommentaire);
			em.persist(entityCommentaire);
			System.out.println("*****APRES PERSIST Commentaire");
			em.flush();
			System.out.println("*****APRES FLUSH Commentaire");
			
			
		} catch (Exception e) {
			System.out.println("*****dao.DaoSouvenirCreatePhoto-createCommentaire: dans le catch EXCEPTION de Persistence");
			e.printStackTrace();
		}
	}

}
