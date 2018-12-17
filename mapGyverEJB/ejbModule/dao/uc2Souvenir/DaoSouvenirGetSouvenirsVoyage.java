package dao.uc2Souvenir;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import business.uc2Souvenir.Commentaire;
import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import business.uc4Voyage.Voyage;
import dao.DaoParam;
import entity.uc2Souvenir.EntityCommentaire;
import entity.uc2Souvenir.EntityPhoto;
import entity.uc2Souvenir.EntitySouvenir;

@Singleton
@LocalBean
public class DaoSouvenirGetSouvenirsVoyage {
	
	@PersistenceContext(unitName=DaoParam.CONTEXT_PERSISTANCE)
	private EntityManager 		em;
	private Photo				photo;
	private Commentaire			commentaire;
	private List<Souvenir>		catalogueSouv;
	private Voyage				voyage;

	public List<Souvenir> getSouvenirsByIdVoyage(String idVoyage) {
		
		System.out.println("je suis dans DaoSouvenirGetSouvenirsVoyage-getSouvenirsByIdVoyage");
		
		Query query = em.createQuery("select s from EntitySouvenir s "
										+ "where s.entityVoyage.id = :entityVoyage "
										+ "and not exists (select p.commentaire.id from EntityPhoto p "
										+ "where p.commentaire is not null "
										+ "and s.id = p.commentaire.id) "
										+ "order by s.id ");

				
//				("select s from EntitySouvenir s "
//						+ "where s.entityVoyage.id =:entityVoyage order by s.id asc");
		query.setParameter("entityVoyage", Integer.parseInt(idVoyage));
		List<EntitySouvenir> liste = query.getResultList();
		
		System.out.println("*****DaoSouvenirGetSouvenirsVoyage: Avant d'iterer sur EntitySouvenir" + liste);
		
		//Contiens les souvenirs de type Photo et Commentaire
		catalogueSouv = new ArrayList<Souvenir>();
		
		//TODO Fonction un peu lourde, forte necessite de refactor
		for (EntitySouvenir entitySouvenir : liste) {
			if(entitySouvenir instanceof EntityPhoto) {
				EntityPhoto entPhoto = (EntityPhoto) entitySouvenir;
				photo = new Photo();
				photo.setUrl(entPhoto.getUrl());
				photo.setNom(entPhoto.getNom());
				photo.setId(entPhoto.getId());
				
				if(entPhoto.getCommentaire() != null) {
					commentaire = new Commentaire();
					commentaire.setDescription(entPhoto.getCommentaire().getDescription());
					photo.setCommentaire(commentaire);
				}
				
				if(entPhoto.getEntityVoyage() != null) {
					voyage = new Voyage();
					voyage.setId(entPhoto.getEntityVoyage().getId());
					voyage.setNom(entPhoto.getEntityVoyage().getNom());
					photo.setVoyage(voyage);
				}
			
				catalogueSouv.add(photo);
			}
			
			else if (entitySouvenir instanceof EntityCommentaire) {
				EntityCommentaire entComm = (EntityCommentaire) entitySouvenir;
				commentaire = new Commentaire();
				
				commentaire.setDescription(entComm.getDescription());
				commentaire.setId(entComm.getId());
				
				if(entComm.getEntityVoyage() != null) {
					voyage = new Voyage();
					voyage.setId(entComm.getEntityVoyage().getId());
					voyage.setNom(entComm.getEntityVoyage().getNom());
					commentaire.setVoyage(voyage);
				}
				
				catalogueSouv.add(commentaire);
			}
			
		}

		System.out.println("Avant RETURN: catalogueSouv = " + catalogueSouv);
		return catalogueSouv;
	}

}
