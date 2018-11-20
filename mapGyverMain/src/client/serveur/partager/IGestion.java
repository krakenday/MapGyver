package client.serveur.partager;

import business.uc3Partager.Description;

/**
 * Interface de persistance de la gestion des descriptions
 */
public interface IGestion {
	
	/*
	 * Création
	 */
	public void addDescription(Description description);
	
	/*
	 * Modification
	 */
	public void updateDescription(Description description);
	
	/*
	 * Suppression par Id
	 */
	public void deleteDescription(int id);
	
	/*
	 * Suppression description
	 */
	public void deleteDescription(Description description);
}
