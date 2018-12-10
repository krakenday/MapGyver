package dao.uc2Souvenir;

/**
 * Les souvenirs a persister peuvent etre de 3 types:
 * 	- photo + commentaire
 * 	- photo (uniquement)
 * 	- commentaire (uniquement) --> sera traite dans DaoSouvenirCreateCommentaire 
 * 		car doit persiste un EntityCommentaire et non un EntityPhoto
 * 
 * Les entitys pour la persistence sont construites avec une fabrique.
 * Cette classe realise les controles necesaires pour savoir quelle est
 * la bonne fabrique a instancier. Les fabriques retournent un EntityPhoto
 * qui sera persiste depuis cette classe.
 */


import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import dao.DaoParam;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;

@Singleton
@LocalBean
public class DaoSouvenirCreatePhoto {
	
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager em;

	private ICreateEntitySouvenirPhoto iCreateEntitySouvenir;
	private EntityPhoto entityPhoto;

	//TODO cette classe se prete bien aux controles + JUnit
	public void createSouvenir(Souvenir souvenir) {

		System.out.println("*****dao.DaoSouvenirCreate-createSouvenir : debut methode");

		//TODO attention je redirige sur le meme pour test
		if(((Photo) souvenir).getCommentaire().getDescription().equals("")) {
			System.out.println("*****dao.DaoSouvenirCreate-createSouvenir: je suis une photo sans commentaire");
			iCreateEntitySouvenir = new FactorySouvenirPhotoSansCom();
		}
		else {
			iCreateEntitySouvenir = new FactorySouvenirPhotoComplet();
			System.out.println("*****dao.DaoSouvenirCreate-createSouvenir: je suis une photo avec commentaire");
		}
		
		entityPhoto =iCreateEntitySouvenir.createEntityPhoto((Photo)souvenir);

		try {
			if(entityPhoto.getCommentaire() != null) {
				em.persist(entityPhoto.getCommentaire());
				System.out.println("*****Commentaire photo persisté");
			}
			System.out.println("*****entityPhoto:" + entityPhoto);
			em.persist(entityPhoto);
			System.out.println("*****APRES PERSIST");
			em.flush();
			System.out.println("*****APRES FLUSH");
			
			
		} catch (Exception e) {
			System.out.println("*****dao.DaoSouvenirCreatePhoto-createSouvenir: dans le catch EXCEPTION de Persistence");
			e.printStackTrace();
		}
		


		
	}



}
