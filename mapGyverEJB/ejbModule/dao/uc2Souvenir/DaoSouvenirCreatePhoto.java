package dao.uc2Souvenir;

import java.sql.SQLException;

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
import javax.persistence.PersistenceException;
import javax.transaction.Transaction;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import dao.DaoParam;
import dao.exception.uc2Souvenir.DaoSouvenirErrorMessage;
import dao.exception.uc2Souvenir.DaoSouvenirException;
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
	public void createSouvenir(Souvenir souvenir) throws DaoSouvenirException {

		System.out.println("*****dao.DaoSouvenirCreatePhoto-createSouvenir : debut methode");

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
			
		//je recupere le code erreur SQL 12899 qui correspond a une valeur trop importante
		//Ici l'exception declenche si le commentaire depasse les 500 caracteres. 
		} catch (PersistenceException e) {
			Throwable t = e.getCause();
			while (t != null) {
				if (t instanceof java.sql.SQLException) {
					System.out.println("je suis une instance de SQL Exception");
					System.out.println("Error code = " + ((java.sql.SQLException) t).getErrorCode());
					if(((java.sql.SQLException) t).getErrorCode()== 12899) {
						System.out.println("je suis un code erreur 12899");
						throw new DaoSouvenirException(DaoSouvenirErrorMessage.ERR_LONGUEUR);
					}
				} else {
					t = t.getCause();
				}
			}
		}
		


		
	}



}
