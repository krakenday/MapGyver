package dao.uc6Jouer.facade;

import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import business.uc6Jouer.Jeu;
import business.uc6Jouer.Jeux;
import business.uc6Jouer.ReponseElire;
import dao.DaoParam;
import dao.exception.uc6Jouer.ConvertionException;
import dao.uc6Jouer.CrudDao;
import entity.uc6Jouer.ElirePhotoEntity;
import entity.uc6Jouer.JeuEntity;
import entity.uc6Jouer.JeuxEntity;

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

	@EJB
	CrudDao crudao;
	@PersistenceContext(unitName = DaoParam.CONTEXT_PERSISTANCE)
	EntityManager em;

	/**
	 * Permet de creer une reponseElire en Bdd
	 * 
	 * @param reponseElire {@link business.uc6Jouer.ReponseElire ReponseElire}
	 * @throws ConvertionException
	 */

	public void createReponseElire(ReponseElire reponseElire) throws ConvertionException {

		// Convertisseur convert = Convertisseur.getInstance();
		// ReponseMetierToEntity<Reponse> conversionMetier = convert.new
		// ReponseMetierToEntity<>();
		// ReponseElireEntity aPersister = (ReponseElireEntity)
		// conversionMetier.reponseMetierToEntity(reponseElire);
		// crudao.createCrud(aPersister);

		// ReponseEntityToMetier<ReponseEntity> conversionEntity = convert.new
		// ReponseEntityToMetier<>();
		// Convertisseur.ReponseMetierToEntity<Reponse> conversion = convert.new
		// ReponseMetierToEntity<>();
		// ReponseElireEntity reponseEntity = (ReponseElireEntity)
		// conversion.reponseMetierToEntity(reponseElire);
	}

	public Jeu getJeuById(int idJeu) throws ConvertionException {

		JeuEntity jeuEntity = crudao.getJeuById(idJeu);
		Convertisseur convert = Convertisseur.getInstance();
		Jeu jeu = convert.transformJeu((ElirePhotoEntity) jeuEntity);
		return jeu;
	}

	public Jeux listJeu() throws ConvertionException {
		Iterator<JeuEntity> it = crudao.listJeu().iterator();
		Jeux jeux = new Jeux();
		Convertisseur convert = Convertisseur.getInstance();
		while (it.hasNext()) {
			JeuEntity jeuEntity = it.next();
			if (jeuEntity instanceof ElirePhotoEntity)
				jeux.add(convert.transformJeu((ElirePhotoEntity) jeuEntity));
		}
		return jeux;
	}
}
