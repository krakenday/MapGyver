package clientServeur.exception;

public class ServiceFacadeExceptionUtilisateur extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;

	public ServiceFacadeExceptionUtilisateur() {
		super();
	}
	
	public ServiceFacadeExceptionUtilisateur(int code) {
		super();
		this.code = code;
	}

	public ServiceFacadeExceptionUtilisateur(String message, int code) {
		super(message); 
		this.code= code;
	}

	public ServiceFacadeExceptionUtilisateur(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public ServiceFacadeExceptionUtilisateur(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
