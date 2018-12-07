package service.exception.uc8Utilisateur;

public class ServiceUtilisateurExistantException extends ServiceExceptionUtilisateur {

	private static final long serialVersionUID = 1L;

	private int code;

	public ServiceUtilisateurExistantException(String message) {
		super(message);
	}

	public ServiceUtilisateurExistantException(int code, String message) {
		super(message); 
		this.code= code;
	}

	public int getCode() {
		return code;
	}

}
