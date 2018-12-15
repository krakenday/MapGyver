package business.uc8Utilisateur;

import java.io.Serializable;
/**
 * Projet - MapGyver
 * Cette classe permet d'instancier un objet de type Password, le mot de passe d'un utilisateur qui s'enregistre ou s'authentifie sur l'application
 * <Br> 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 * 
 */

public class Password implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String password;

	
	public Password(String password) {
		super();
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
