package dao.uc6Jouer.facade;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc6Jouer.Jeu;
import business.uc6Jouer.Reponse;
import business.uc6Jouer.ReponseElire;
import dao.DaoFacade;
import dao.DaoParam;
import dao.exception.uc6Jouer.ConvertionException;
import dao.uc6Jouer.CrudDao;
import entity.uc2Souvenir.EntityPhoto;
import entity.uc6Jouer.ElirePhotoEntity;
import entity.uc6Jouer.JeuEntity;
import entity.uc6Jouer.ReponseElireEntity;
import entity.uc8Utilisateur.EntityUtilisateur;

/**
 * Facade de Uc6 jouer pour la couche de Dao
 * 
 * {@link dao.uc6Jouer.facade.DaoFacadeJouer#createReponseElire(ReponseElire reponseElire)
 * createReponseElire}
 * 
 * @author lours
 */
@Singleton
@LocalBean
public class DaoFacadeJouer {
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em;

	@EJB
	CrudDao crudao;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ConvertionException
	 */

	public void createReponseElire(ReponseElire reponseElire) throws ConvertionException {
		System.out.println("je suis bien dans la face daoJouer");
		ElirePhotoEntity jeu = em.find(ElirePhotoEntity.class, 610);
		EntityPhoto photo = em.find(EntityPhoto.class, 612);
		EntityUtilisateur utilisateur = em.find(EntityUtilisateur.class, 601);
		ReponseElireEntity reponse = new ReponseElireEntity(jeu, utilisateur, LocalDate.now(), photo);
		crudao.createCrud(reponse);

		// Convertisseur convert = Convertisseur.getInstance();
		// Convertisseur.ReponseMetierToEntity<Reponse> conversion = convert.new
		// ReponseMetierToEntity<>();
		// ReponseElireEntity reponseEntity = (ReponseElireEntity)
		// conversion.reponseMetierToEntity(reponseElire);

	}
}
