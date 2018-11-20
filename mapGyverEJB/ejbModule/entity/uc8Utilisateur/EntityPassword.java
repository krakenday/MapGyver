package entity.uc8Utilisateur;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntityPassword {

	@Column(length=20, nullable= false)
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
