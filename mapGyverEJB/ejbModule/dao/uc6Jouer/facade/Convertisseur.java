package dao.uc6Jouer.facade;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import business.uc2Souvenir.Photo;
import business.uc6Jouer.ElirePhoto;
import business.uc6Jouer.Jeu;
import business.uc6Jouer.Reponse;
import dao.exception.uc6Jouer.ConvertionException;
import dao.uc8Utilisateur.FabriqueEntity;
import entity.uc2Souvenir.EntityPhoto;
import entity.uc6Jouer.ElirePhotoEntity;
import entity.uc6Jouer.JeuEntity;
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
	 * Permet la conversion d'un ElirePhotoEntity en ElirePhoto
	 * 
	 * @param jeuElireEntity
	 * @return
	 * @throws ConvertionException
	 */

	protected Jeu transformJeu(ElirePhotoEntity jeuElireEntity) throws ConvertionException {

		ElirePhoto jeu = (ElirePhoto) new JeuEntityToMetier<>().jeuEntityToMetier(jeuElireEntity);
		jeu.setDateFinInscription(jeuElireEntity.getDateFinInscription());
		jeu.setDateDebut(jeuElireEntity.getDateDebut());
		jeu.setDateFin(jeuElireEntity.getDateFin());

		Collection<EntityPhoto> photosEntity = jeuElireEntity.getPhotosEntity();
		ArrayList<Photo> convPhotos = new ArrayList<Photo>();
		EntityPhoto photoEntity = new EntityPhoto();
		Iterator<EntityPhoto> it = photosEntity.iterator();

		while (it.hasNext()) {
			photoEntity = it.next();
			Photo convPhoto = new Photo();
			convPhoto.setId(photoEntity.getId());
			convPhoto.setNom(photoEntity.getNom());
			convPhoto.setUrl(photoEntity.getUrl());
			convPhotos.add(convPhoto);
		}
		jeu.setPhotos(convPhotos);
		return jeu;
	}
}

/**
 * Permet de convertir une ReponseEntity en Reponse
 * 
 * @author lours
 *
 * @param <T>
 */

class ReponseEntityToMetier<T extends ReponseEntity> {

	/**
	 * Permet de convertir une ReponseEntity en Reponse Metier
	 * 
	 * @author lours
	 *
	 * @param <T>
	 */
	protected Reponse reponseEntityToMetier(T reponseEntity) throws ConvertionException {
		FabriqueEntity fabriqueEntity = new FabriqueEntity();
		Class<?> type = reponseEntity.getMappingMetier();
		Object object = null;
		try {
			object = type.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ConvertionException(e.getMessage(), e.getCause());
		}
		Reponse reponse = null;
		if (object instanceof Reponse) {
			reponse = (Reponse) object;

			reponse.setDateEmission(reponseEntity.getDateEmission());
			reponse.setUtilisateur(fabriqueEntity.createUser(reponseEntity.getUtilisateurEntity()));
		}

		return reponse;
	}
}

/**
 * Permet de convertir une Reponse Metier en ReponseEntity
 * 
 * @author lours
 *
 * @param <T>
 */
class ReponseMetierToEntity<T extends Reponse> {

	protected ReponseEntity reponseMetierToEntity(T reponse) throws ConvertionException {

		FabriqueEntity fabriqueEntity = new FabriqueEntity();
		Class<?> type = reponse.getMappingEntity();
		Object object = null;
		try {
			object = type.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ConvertionException(e.getMessage(), e.getCause());
		}
		ReponseEntity reponseEntity = null;
		if (object instanceof ReponseEntity) {
			reponseEntity = (ReponseEntity) object;
			reponseEntity.setDateEmission(reponseEntity.getDateEmission());
			reponseEntity.setUtilisateurEntity(fabriqueEntity.createEntityUser(reponse.getUtilisateur()));
		}
		return reponseEntity;
	}
}

/**
 * Permet de convertir un JeuEntity en Jeu Metier
 * 
 * @author lours
 *
 * @param <T>
 */
class JeuEntityToMetier<T extends JeuEntity> {

	/**
	 * Permet de convertir un JeuEntity en Jeu Metier
	 * 
	 * @author lours
	 *
	 * @param <T>
	 */
	protected Jeu jeuEntityToMetier(T jeuEntity) throws ConvertionException {

		Class<?> type = jeuEntity.getMappingMetier();
		Object object = null;
		try {
			object = type.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ConvertionException(e.getMessage(), e.getCause());
		}

		Jeu jeu = null;
		if (object instanceof Jeu) {
			jeu = (Jeu) object;
			jeu.setId(jeuEntity.getId());
			jeu.setNom(jeuEntity.getNom());
			jeu.setDateCreation(jeuEntity.getDateCreation());
			jeu.setUtilisateur(jeuEntity.getUtilisateur());
		}
		return jeu;
	}
}
