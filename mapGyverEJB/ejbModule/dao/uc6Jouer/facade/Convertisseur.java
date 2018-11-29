package dao.uc6Jouer.facade;

import java.lang.reflect.InvocationTargetException;

import business.uc6Jouer.Reponse;
import dao.exception.uc6Jouer.ConvertionException;
import entity.uc6Jouer.ReponseEntity;

public final class Convertisseur {

	/**
	 * Utilisation du design Pattern Singleton
	 * 
	 * @return
	 */
	private static volatile Convertisseur instance = null;

	private Convertisseur() {
		super();
	}

	public final static Convertisseur getInstance() {
		if (Convertisseur.instance == null) {
			synchronized (Convertisseur.class) {
				if (Convertisseur.instance == null) {
					Convertisseur.instance = new Convertisseur();
				}
			}
		}
		return Convertisseur.instance;
	}

	/**
	 * Permet de convertir une ReponseEntity en Reponse
	 * 
	 * @author lours
	 *
	 * @param <T>
	 */

	class ReponseEntityToMetier<T extends ReponseEntity> {

		protected Reponse reponseEntityToMetier(T reponseEntity) throws ConvertionException {
			Class<?> type = reponseEntity.getMappingMetier();
			Object object = null;
			try {
				object = type.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new ConvertionException(e.getMessage(), e.getCause());
			}
			Reponse reponse = null;
			if (object instanceof Reponse) {
				reponse = (Reponse) object;
				reponse.setDateEmission(reponseEntity.getDateEmission());
				reponse.setUtilisateur(reponseEntity.getUtilisateur());
				reponse.setJeu(reponseEntity.getJeu());
			}
			return reponse;
		}
	}

	/**
	 * Permet de convertir une Reponse en ReponseEntity
	 * 
	 * @author lours
	 *
	 * @param <T>
	 */
	class ReponseMetierToEntity<T extends Reponse> {

		protected ReponseEntity reponseMetierToEntity(T reponse) throws ConvertionException {
			Class<?> type = reponse.getMappingEntity();
			Object object = null;
			try {
				object = type.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new ConvertionException(e.getMessage(), e.getCause());
			}
			ReponseEntity reponseEntity = null;
			if (object instanceof ReponseEntity) {
				reponseEntity = (ReponseEntity) object;
				reponseEntity.setDateEmission(reponseEntity.getDateEmission());
				reponseEntity.setUtilisateur(reponseEntity.getUtilisateur());
				reponseEntity.setJeu(reponseEntity.getJeu());
			}
			return reponseEntity;
		}
	}
}
