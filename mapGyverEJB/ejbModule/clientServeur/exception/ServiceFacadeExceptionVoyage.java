package clientServeur.exception;

public class ServiceFacadeExceptionVoyage extends Exception {

	private static final long serialVersionUID = 3L;
	
	private int code;

	public ServiceFacadeExceptionVoyage(String message) {
		super(message);
	}

	public ServiceFacadeExceptionVoyage(int code, String message) {
		super(message); 
		this.code= code;
	}

	public int getCode() {
		return code;
	}
}
