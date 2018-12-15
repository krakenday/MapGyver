package entity.uc8Utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * Projet - MapGyver
 * <Br> 
 * @author Djallal
 * @version 1.0 AFPA ECF2 Projet MapGyver
 * 
 * Un password appartient à un seul utilisateur 
 */

@Embeddable
public class EntityPassword implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(length=20, name="pw", nullable= false)
	private String password;


	public EntityPassword() {
	}
	
	public EntityPassword(String password) {
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
