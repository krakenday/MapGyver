package clientServeur;

import business.uc8Utilisateur.Utilisateur;

public interface IGestionUtilisateur {
	
	public void create(Utilisateur utilisateur);
	
	//à corriger retourne un type utilisateur ou IUtilisateur si on utilise la fabrique
	public Utilisateur read(int id);
	
	public void update(Utilisateur utilisateur);
	
	public void delete(int id);
	
}
