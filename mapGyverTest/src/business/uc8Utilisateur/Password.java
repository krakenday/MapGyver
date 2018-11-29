package business.uc8Utilisateur;

//@Embeddable
public class Password {

	// @Column(length=20, nullable= false)
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
