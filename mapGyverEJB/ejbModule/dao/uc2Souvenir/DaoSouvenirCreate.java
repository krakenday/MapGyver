package dao.uc2Souvenir;

/**
 * Les souvenirs a persister peuvent etre de 3 types:
 * 	- photo + commentaire
 * 	- photo (uniquement)
 * 	- commentaire (uniquement)
 * 
 * Les entitys pour la persistence sont construites avec une fabrique.
 * Cette classe realise les controles necesaires pour savoir quelle est
 * la bonne fabrique a instancier. Les fabriques retournent un EntitySouvenir
 * qui sera persiste depuis cette classe.
 */


import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;

@Singleton
@LocalBean
public class DaoSouvenirCreate {
	
	private ICreateEntitySouvenir iCreateEntitySouvenir;
	private EntityPhoto entityPhoto;
	private EntityCommentaire entityCommentaire;
	
//TODO cette classe se prete bien aux controles + JUnit
	public void createSouvenir(Souvenir souvenir) {
		
		System.out.println("*****dao.DaoSouvenirCreate-createSouvenir : debut methode");
		
		if(souvenir instanceof Photo) {
			if(((Photo) souvenir).getCommentaire() == null) {
				iCreateEntitySouvenir = new FactorySouvenirPhotoSansCom();
			}
			else {
				iCreateEntitySouvenir = new FactorySouvenirPhotoComplet();
			}
			entityPhoto =iCreateEntitySouvenir.createEntityPhoto(souvenir);
		}
		
		//TODO Ici le retour attendu est EntityCommentaire et non EntityPhoto
		//peut etre plus interessant de faire une autre fabrique
		else if (souvenir instanceof Photo) {
			iCreateEntitySouvenir = new FactorySouvenirCommentaire();
			iCreateEntitySouvenir.createEntityCommentaire(souvenir);
			
		}
		
		else System.out.println("*****dao.DaoSouvenirCreate-createSouvenir: dans le else -->hoho un souci!!");
		
		
		//TODO ici prevoir context et persist !!!
		entityPhoto.persist(); //TODO la facade DaoSouvenir doit evaluer l'instance de Souvenir pour rediriger au bon endroit
		//pas mettre entity commentaire ICI
	}
	
	

}
