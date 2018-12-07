package service.exception.uc8Utilisateur;

public class ServiceExceptionUtilisateur extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int code;

	public ServiceExceptionUtilisateur(String message) {
		super(message);
	}

	public ServiceExceptionUtilisateur(int code, String message) {
		super(message); 
		this.code= code;
	}

	public int getCode() {
		return code;
	}

}
