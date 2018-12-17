package dao.uc6Jouer.facade;

import java.sql.SQLException;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRolledbackException;

import business.uc6Jouer.ElirePhoto;
import business.uc6Jouer.Jeu;
import business.uc6Jouer.Jeux;
import business.uc6Jouer.ReponseElire;
import dao.DaoParam;
import dao.exception.uc6Jouer.ConvertionException;
import dao.uc6Jouer.CrudDao;
import entity.uc6Jouer.ElirePhotoEntity;
import entity.uc6Jouer.JeuEntity;
import entity.uc6Jouer.JeuxEntity;
import entity.uc6Jouer.ReponseElireEntity;
import service.exception.uc6Jouer.ExceptionSurDao;

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
	 * @throws SQLException
	 * @throws TransactionRolledbackException
	 */

	public void createReponseElire(ReponseElire reponseElire)
			throws ConvertionException, TransactionRolledbackException, SQLException, PersistenceException {
		Convertisseur convert = Convertisseur.getInstance();

		crudao.createCrud(convert.transformReponse(reponseElire));
	}

	/**
	 * Retourne un jeu en fonction de l'id jeu fournis
	 * 
	 * @param idJeu
	 * @return
	 * @throws ConvertionException
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 * @throws EJBTransactionRolledbackException
	 */

	public Jeu getJeuById(int idJeu)
			throws ConvertionException, EJBTransactionRolledbackException, IllegalArgumentException, SQLException {
		JeuEntity jeuEntity = crudao.getJeuById(idJeu);
		Convertisseur convert = Convertisseur.getInstance();
		Jeu jeu = convert.transformJeu((ElirePhotoEntity) jeuEntity);
		return jeu;
	}

	/**
	 * Fait la liste de tout les jeux
	 * 
	 * @return
	 * @throws ConvertionException
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 * @throws EJBTransactionRolledbackException
	 */
	public Jeux listJeu()
			throws ConvertionException, EJBTransactionRolledbackException, IllegalArgumentException, SQLException {
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

	/**
	 * Supprime un jeu en fonction du jeu Fournis
	 * 
	 * @param jeu
	 * @throws ExceptionSurDao
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 * @throws EJBTransactionRolledbackException
	 */

	public void removeJeu(Jeu jeu)
			throws ExceptionSurDao, EJBTransactionRolledbackException, IllegalArgumentException, SQLException {
		int idJeu = jeu.getId();
		JeuEntity jeuEntity = crudao.getJeuById(idJeu);
		crudao.removeJeu(jeuEntity);
	}
}
