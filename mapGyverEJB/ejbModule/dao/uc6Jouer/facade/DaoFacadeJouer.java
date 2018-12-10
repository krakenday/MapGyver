package dao.uc6Jouer.facade;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc6Jouer.Jeu;
import business.uc6Jouer.Reponse;
import business.uc6Jouer.ReponseElire;
import dao.DaoParam;
import dao.exception.uc6Jouer.ConvertionException;
import entity.uc6Jouer.JeuEntity;
import entity.uc6Jouer.ReponseElireEntity;

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

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ConvertionException
	 */

	public void createReponseElire(ReponseElire reponseElire) throws ConvertionException {
		System.out.println("je suis bien dans la face daoJouer");
		JeuEntity jeu = em.find(JeuEntity.class, 610);
		System.out.println("jeu=" + jeu);
		// Convertisseur convert = Convertisseur.getInstance();
		// Convertisseur.ReponseMetierToEntity<Reponse> conversion = convert.new
		// ReponseMetierToEntity<>();
		// ReponseElireEntity reponseEntity = (ReponseElireEntity)
		// conversion.reponseMetierToEntity(reponseElire);

	}
}
