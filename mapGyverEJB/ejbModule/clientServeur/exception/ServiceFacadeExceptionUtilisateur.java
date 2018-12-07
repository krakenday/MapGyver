package clientServeur.exception;

public class ServiceFacadeExceptionUtilisateur extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;
	
	public ServiceFacadeExceptionUtilisateur() {
		super();
	}

	public ServiceFacadeExceptionUtilisateur(String message) {
		super(message);
	}

	public ServiceFacadeExceptionUtilisateur(int code, String message) {
		super(message); 
		this.code= code;
	}

	public int getCode() {
		return code;
	}

}
