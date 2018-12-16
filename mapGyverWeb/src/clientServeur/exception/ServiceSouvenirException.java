package clientServeur.exception;

public class ServiceSouvenirException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int code;
	private String solution;



	public ServiceSouvenirException(int code, String message) {
		super(message); 
		this.code= code;
	}

	
	public int getCode() {
		return code;
	}

	public String getSolution() {
		return solution;
	}

}
