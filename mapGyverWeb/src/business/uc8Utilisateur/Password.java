package business.uc8Utilisateur;

import java.io.Serializable;

public class Password implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String password;

	public Password() {
	}
	
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
