package dao.uc2Souvenir;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc2Souvenir.Photo;
import dao.DaoParam;
import entity.uc2Souvenir.EntityPhoto;

/**
 * Classe permetant de recuperer l'url d'une photo
 * a partir de son ID. Utile pour l'UC6 jouer.
 * @author alejandro
 *
 */
@Singleton
@LocalBean
public class DaoSouvenirGetPhoto {
	
	@PersistenceContext(unitName=DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager 		em;
	private EntityPhoto			entityPhoto;
	private Photo				photo;

	public Photo getPhotoById(int idPhoto) {
		
		entityPhoto =em.find(EntityPhoto.class, idPhoto);
		
		photo = new Photo();
		photo.setId(entityPhoto.getId());
		photo.setUrl(entityPhoto.getUrl());
		
		return photo;
		
		
	}

}
