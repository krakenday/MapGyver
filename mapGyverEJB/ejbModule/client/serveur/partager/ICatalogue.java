package client.serveur.partager;

import java.util.List;

import business.uc3Partager.Description;

/**
 * Interface de persistance de l'affichage des descriptions
 */
public interface ICatalogue {
	
	/*
	 * Liste
	 */
	public List<Description> getDescriptionById();
	public List<Description> getDescriptionByDate();
	
	/*
	 * Recherche
	 */
	public List<Description> SearchDescriptionById();
}
